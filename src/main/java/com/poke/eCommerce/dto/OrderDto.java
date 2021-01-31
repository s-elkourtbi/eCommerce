package com.poke.eCommerce.dto;

import com.poke.eCommerce.entities.Order;
import com.poke.eCommerce.valueObject.OrderVO;

public class OrderDto {

    public static OrderVO orderFromEntitieToVo(Order order) {
        OrderVO orderVO = new OrderVO();

        orderVO.setShipmentAmount(order.getShipmentAmount());
        orderVO.setStatus(order.getStatus());
        orderVO.setTotalAmount(order.getTotalAmount());
        orderVO.setWeight(order.getWeight());

        return orderVO;
    }

    public static Order orderFromVoToEntity(OrderVO orderVO) {
        Order order = new Order();

        order.setShipmentAmount(orderVO.getShipmentAmount());
        order.setStatus(orderVO.getStatus());
        order.setTotalAmount(orderVO.getTotalAmount());
        order.setWeight(orderVO.getWeight());

        return order;
    }
}
