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
import org.springframework.http.HttpStatus;
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
    @RequestMapping(value = "/newOrder", produces = "application/json" ,method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Boolean newOrder(@RequestBody List<ProductVO> productVO) {
        Boolean succes = Boolean.FALSE;
        try {
            succes = orderService.newOrder(productVO);
        } catch (Exception e) {
            e.getMessage();
        }
        return succes;
    }

    @Override
    @RequestMapping(value = "/findOrderById", produces =  "application/json", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
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
    @RequestMapping(value = "/findAllOrder", produces =  "application/json", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
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
    @RequestMapping(value = "/deletOrderById", produces =  "application/json", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
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
    @RequestMapping(value = "/updateOrder", produces =  "application/json", method = RequestMethod.PATCH)
    @ResponseStatus(HttpStatus.PARTIAL_CONTENT)
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
    @RequestMapping(value = "/sortAllPBill", produces =  "application/json", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
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
