package com.poke.eCommerce.service;

import com.poke.eCommerce.entities.Order;
import com.poke.eCommerce.utils.Status;
import com.poke.eCommerce.valueObject.OrderVO;
import com.poke.eCommerce.valueObject.ProductVO;

import javax.transaction.Transactional;
import java.util.List;

public interface OrderService {
    Boolean newOrder(List<ProductVO> ProductVO);

    OrderVO findOrderById(Long idOrder);

    List<Order> findAllOrder();

    boolean deletOrderByID(Long idOrder);

    @Transactional
    boolean updateOrderStatu(Long idOrder, String status);
}
