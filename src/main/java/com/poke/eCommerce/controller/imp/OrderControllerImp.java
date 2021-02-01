package com.poke.eCommerce.controller.imp;

import com.poke.eCommerce.controller.OrderController;
import com.poke.eCommerce.entities.Bill;
import com.poke.eCommerce.entities.Order;
import com.poke.eCommerce.service.BillService;
import com.poke.eCommerce.service.OrderService;
import com.poke.eCommerce.valueObject.OrderVO;
import com.poke.eCommerce.valueObject.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class OrderControllerImp implements OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BillService billService;

    @Override
    @RequestMapping(value = "/newOrder", method = RequestMethod.POST)
    public Boolean newProduct(@RequestBody List<ProductVO> productVO) {
        Boolean succes = Boolean.FALSE;
        try {
            succes = orderService.newOrder(productVO);
        } catch (Exception e) {
            e.getMessage();
        }
        return succes;
    }

    @Override
    @RequestMapping(value = "/findOrderById", method = RequestMethod.GET)
    public OrderVO findOrderById(@RequestParam Long idOrder) {
        OrderVO orderVO = new OrderVO();
        try {
            orderVO = orderService.findOrderById(idOrder);
        }catch (Exception e) {
            e.getMessage();
        }
        return orderVO;
    }

    @Override
    @RequestMapping(value = "/findAllOrder", method = RequestMethod.GET)
    public List<Order> findAllOrder() {
        List<Order> order = new ArrayList<>();
        try {
            order = orderService.findAllOrder();
        }catch (Exception e) {
            e.getMessage();
        }
        return order;
    }

    @Override
    @RequestMapping(value = "/deletOrderById", method = RequestMethod.DELETE)
    public Boolean deleteById(@RequestParam Long idOrder) {
        Boolean succes = Boolean.FALSE;
        try {
            succes  = orderService.deletOrderByID(idOrder);
        } catch (Exception e) {
            e.getMessage();
        }
        return succes;
    }

    @Override
    @RequestMapping(value = "/updateOrder", method = RequestMethod.PATCH)
    public Boolean updateOrder(@RequestParam Long idOrder, @RequestParam String status) {
        Boolean succes = Boolean.FALSE;
        try {
            succes = orderService.updateOrderStatu(idOrder, status);
        } catch (Exception e) {
            e.getMessage();
        }
        return succes;
    }

    @Override
    @RequestMapping(value = "/sortAllPBill", method = RequestMethod.GET)
    public List<Bill> sortAllProduct(@RequestParam String sort) {
        List<Bill> billList= new ArrayList<>();
        try {
            billList = billService.sortBill(sort);
        } catch (Exception e) {
            e.getMessage();
        }
        return billList;
    }
}
