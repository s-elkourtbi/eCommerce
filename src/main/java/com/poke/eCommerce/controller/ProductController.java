package com.poke.eCommerce.controller;

import com.poke.eCommerce.entities.Product;
import com.poke.eCommerce.valueObject.ProductVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductController {
    @RequestMapping(value = "/newProduct", method = RequestMethod.POST)
    Boolean newProduct(@RequestBody ProductVO productVO);

    @RequestMapping(value = "/findByName", method = RequestMethod.GET)
    ProductVO findByName(@RequestParam String name);

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    ProductVO findById(@RequestParam Long idProduct);

    @RequestMapping(value = "/deletProductByName", method = RequestMethod.DELETE)
    Boolean deleteById(@RequestParam String name);

    @RequestMapping(value = "/deletProductById", method = RequestMethod.DELETE)
    Boolean deleteById(@RequestParam Long idProduct);

    @RequestMapping(value = "/findAllProduct", method = RequestMethod.GET)
    List<Product> findAllProduct();

    @RequestMapping(value = "/sortAllProduct", method = RequestMethod.GET)
    List<Product> sortAllProduct(@RequestParam String sort);
}
