package com.poke.eCommerce.controller;

import com.poke.eCommerce.entities.Product;
import com.poke.eCommerce.valueObject.ProductVO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductController {

    Boolean newProduct(@RequestBody ProductVO productVO);

    ProductVO findByName(@RequestParam String name);

    ProductVO findById(@RequestParam Long idProduct);

    Boolean deleteById(@RequestParam String name);

    Boolean deleteById(@RequestParam Long idProduct);

    List<Product> findAllProduct();

    List<Product> sortAllProduct(@RequestParam String sort);
}
