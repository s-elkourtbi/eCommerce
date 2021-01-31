package com.poke.eCommerce.dto;

import com.poke.eCommerce.entities.Product;
import com.poke.eCommerce.valueObject.ProductVO;

public class ProducDto {

    public static Product productFromVoToEntitie(ProductVO productVO) {
        Product product = new Product();

        product.setName(productVO.getName());
        product.setIdProduct(productVO.getIdProduct());
        product.setPrice(productVO.getPrice());
        product.setWeight(productVO.getWeight());

        return product;
    }

    public static ProductVO productFromEntitieToVo(Product product) {
        ProductVO productVO = new ProductVO();

        productVO.setIdProduct(product.getIdProduct());
        productVO.setName(product.getName());
        productVO.setPrice(product.getPrice());
        productVO.setWeight(product.getWeight());

        return productVO;
    }
}
