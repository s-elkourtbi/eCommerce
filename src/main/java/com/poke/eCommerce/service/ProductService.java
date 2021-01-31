package com.poke.eCommerce.service;

import com.poke.eCommerce.entities.Product;
import com.poke.eCommerce.valueObject.ProductVO;

import java.util.List;

public interface ProductService {

    Boolean newProduct(ProductVO productVO);

    ProductVO findProductByName(String name);

    ProductVO findProductById(Long idProduct);

    List<Product> findAllProduct();

    boolean deletProductByName(String name);

    boolean deletProductByID(Long idProduct);

    List<Product> sortProduct(String sort);
}
