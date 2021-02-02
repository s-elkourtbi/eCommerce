package com.poke.eCommerce.controller.imp;

import com.poke.eCommerce.controller.ProductController;
import com.poke.eCommerce.entities.Product;
import com.poke.eCommerce.service.ProductService;
import com.poke.eCommerce.valueObject.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class ProductControllerImp implements ProductController {

    @Autowired
    private ProductService productService;

    @Override
    @RequestMapping(value = "/newProduct", produces =  "application/json", method = RequestMethod.POST)
    public Boolean newProduct(@RequestBody ProductVO productVO) {
        Boolean succes = Boolean.FALSE;
        try {
            succes = productService.newProduct(productVO);
        } catch (Exception e) {
            e.getMessage();
        }
        return succes;
    }

    @Override
    @RequestMapping(value = "/findByName", produces =  "application/json", method = RequestMethod.GET)
    public ProductVO findByName(@RequestParam String name) {
        ProductVO productVO = new ProductVO();
        try {
            productVO  = productService.findProductByName(name);
        } catch (Exception e) {
            e.getMessage();
        }
        return productVO;
    }

    @Override
    @RequestMapping(value = "/findById", produces =  "application/json", method = RequestMethod.GET)
    public ProductVO findById(@RequestParam Long idProduct) {
        ProductVO productVO = new ProductVO();
        try {
            productVO  = productService.findProductById(idProduct);
        } catch (Exception e) {
            e.getMessage();
        }
        return productVO;
    }

    @Override
    @RequestMapping(value = "/deletProductByName", produces =  "application/json", method = RequestMethod.DELETE)
    public Boolean deleteById(@RequestParam String name) {
        Boolean succes = Boolean.FALSE;
        try {
            succes  = productService.deletProductByName(name);
        } catch (Exception e) {
            e.getMessage();
        }
        return succes;
    }

    @Override
    @RequestMapping(value = "/deletProductById", produces =  "application/json", method = RequestMethod.DELETE)
    public Boolean deleteById(@RequestParam Long idProduct) {
        Boolean succes = Boolean.FALSE;
        try {
            succes  = productService.deletProductByID(idProduct);
        } catch (Exception e) {
            e.getMessage();
        }
        return succes;
    }

    @Override
    @RequestMapping(value = "/findAllProduct", produces =  "application/json", method = RequestMethod.GET)
    public List<Product> findAllProduct() {
        List<Product> productList = new ArrayList<>();
        try {
            productList = productService.findAllProduct();
        } catch (Exception e) {
            e.getMessage();
        }
        return productList;
    }

    @Override
    @RequestMapping(value = "/sortAllProduct", produces =  "application/json", method = RequestMethod.GET)
    public List<Product> sortAllProduct(@RequestParam String sort) {
        List<Product> productList = new ArrayList<>();
        try {
            productList = productService.sortProduct(sort);
        } catch (Exception e) {
            e.getMessage();
        }
        return productList;
    }

}
