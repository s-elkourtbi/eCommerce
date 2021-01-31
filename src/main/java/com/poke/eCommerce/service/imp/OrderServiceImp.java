package com.poke.eCommerce.service.imp;

import com.poke.eCommerce.dto.OrderDto;
import com.poke.eCommerce.dto.ProducDto;
import com.poke.eCommerce.entities.Order;
import com.poke.eCommerce.entities.Product;
import com.poke.eCommerce.repository.OrderRepository;
import com.poke.eCommerce.service.OrderService;
import com.poke.eCommerce.valueObject.OrderVO;
import com.poke.eCommerce.valueObject.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImp implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    public Boolean newOrder(OrderVO orderVO) {
        Boolean success = Boolean.FALSE;
        try {

            orderRepository.save(OrderDto.orderFromVoToEntity(orderVO));
            success = Boolean.TRUE;
            log.info("A new order has being added to to data base ! " + orderVO.getIdOrder());
        }catch (TransactionException e) {
            log.error(e.getMessage());
        }
        return success;
    }

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

    public boolean deletOrderByID(Long idOrder) {
        Boolean success = Boolean.FALSE;
        try {

            if (idOrder != null) {
                orderRepository.
                        delete(orderRepository.findById(idOrder).get());
                success = Boolean.TRUE;
                log.info("the product Id number "+ idOrder + "was deleted !");
            }
        }
        catch(TransactionException e){
            log.error(e.getMessage());
        }
        return success;
    }
}
