package com.poke.eCommerce.dto;

import com.poke.eCommerce.entities.Order;
import com.poke.eCommerce.entities.Product;
import com.poke.eCommerce.valueObject.OrderVO;
import com.poke.eCommerce.valueObject.ProductVO;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {

    public static OrderVO orderFromEntitieToVo(Order order) {
        OrderVO orderVO = new OrderVO();
        List<ProductVO> productVOList = new ArrayList<>();

        orderVO.setShipmentAmount(order.getShipmentAmount());
        orderVO.setStatus(order.getStatus());
        orderVO.setTotalAmount(order.getTotalAmount());
        orderVO.setWeight(order.getWeight());
        orderVO.setIdOrder(order.getIdOrder());
        for(Product product : order.getListProduct()) {
            productVOList.add(ProducDto.productFromEntitieToVo(product));
        }

        orderVO.setProductVOs(productVOList);

        return orderVO;
    }

    public static Order orderFromVoToEntity(OrderVO orderVO) {
        Order order = new Order();

        order.setShipmentAmount(orderVO.getShipmentAmount());
        order.setStatus(orderVO.getStatus());
        order.setTotalAmount(orderVO.getTotalAmount());
        order.setWeight(orderVO.getWeight());
        order.setIdOrder(orderVO.getIdOrder());

        return order;
    }
}
