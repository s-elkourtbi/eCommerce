package com.poke.eCommerce.service.imp;

import com.poke.eCommerce.dto.OrderDto;
import com.poke.eCommerce.entities.Order;
import com.poke.eCommerce.repository.OrderRepository;
import com.poke.eCommerce.service.BillService;
import com.poke.eCommerce.service.OrderService;
import com.poke.eCommerce.utils.Status;
import com.poke.eCommerce.utils.Utils;
import com.poke.eCommerce.valueObject.OrderVO;
import com.poke.eCommerce.valueObject.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImp implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BillService billService;

    @Override
    public Boolean newOrder(List<ProductVO> ProductVO) {
        Boolean success = Boolean.FALSE;
        OrderVO orderVO = new OrderVO();
        Double amount = Double.valueOf(1);
        Double shipmentAmount = Double.valueOf(1);
        Long weight = 1L;
        try {
            if(!ProductVO.isEmpty()) {
                for (ProductVO productVO : ProductVO) {
                    amount += productVO.getPrice();
                    weight += productVO.getWeight();
                }
                orderVO.setWeight(weight);
                orderVO.setShipmentAmount(shipmentCoast(weight));
                orderVO.setTotalAmount(amount + orderVO.getShipmentAmount());
                orderVO.setStatus(Status.PENDING);
                orderVO.setProductVOs(ProductVO);
                orderRepository.save(OrderDto.orderFromVoToEntity(orderVO));
                success = Boolean.TRUE;
                log.info("A new order has being added to to data base ! " + orderVO.getIdOrder());
            } else
                log.info("The order must contain at least 1 product !");
        }catch (TransactionException e) {
            log.error(e.getMessage());
        }
        return success;
    }

    @Override
    public OrderVO findOrderById(Long idOrder) {
        OrderVO orderVO = new OrderVO();
        try {
            if(idOrder != null) {
                orderVO = OrderDto.orderFromEntitieToVo(orderRepository.findById(idOrder).get());
            }
        } catch (TransactionException e) {
            log.error(e.getMessage());
        }
        return orderVO;
    }

    @Override
    public List<Order> findAllProduct() {
        List<Order> orders = new ArrayList<Order>();
        try {
            {
                orders = orderRepository.findAll();
            }
        } catch (TransactionException e) {
            log.error(e.getMessage());
        }
        return orders;
    }

    @Override
    public boolean deletOrderByID(Long idOrder) {
        Boolean success = Boolean.FALSE;
        if (idOrder != null) {
            Order order = orderRepository.findById(idOrder).get();
                try {
                    if (order.getStatus() != Status.PAID) {
                    orderRepository.
                            delete(order);
                    success = Boolean.TRUE;
                    log.info("the product Id number " + idOrder + "was deleted !");
                } else
                        log.info("The order cannot be deleted");

                }catch (TransactionException e) {
                    log.error(e.getMessage());
                }

        }
        return success;
    }

    @Transactional
    @Override
    public boolean updateOrderStatu(Long idOrder, Status status) {
        Boolean success = Boolean.FALSE;
        try {
            if (idOrder != null) {
                OrderVO orderVO = findOrderById(idOrder);
                orderRepository.save(OrderDto.orderFromVoToEntity(orderVO));
                orderVO.setStatus(status);
                log.info("the status has changed to " + orderVO.getStatus());
                if (status == Status.PAID) {
                    billService.generateBill(Utils.getCurrentDate(), orderVO.getTotalAmount());
                }
                success = Boolean.TRUE;
            }
        } catch (TransactionException e) {
            log.error(e.getMessage());
        }
        return false;
    }

    public Double shipmentCoast(Long weight) {
        Double coast = Double.valueOf(1);

        return coast = Double.valueOf((weight/10) * 25);
    }
}
