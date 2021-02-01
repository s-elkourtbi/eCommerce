package com.poke.eCommerce.controller;

import com.poke.eCommerce.entities.Bill;
import com.poke.eCommerce.entities.Order;
import com.poke.eCommerce.valueObject.OrderVO;
import com.poke.eCommerce.valueObject.ProductVO;

import java.util.List;

public interface OrderController {

    Boolean newProduct(List<ProductVO> productVO);

    OrderVO findOrderById(Long idOrder);

    List<Order> findAllOrder();

    Boolean deleteById( Long idOrder);

    Boolean updateOrder(Long idOrder, String status);

    List<Bill> sortAllProduct(String sort);
}
