package com.poke.eCommerce.dto;

import com.poke.eCommerce.entities.Product;
import com.poke.eCommerce.valueObject.ProductVO;

public class ProducDto {

    public static Product productFromEntitieToDto(ProductVO productVO) {
        Product product = new Product();

        product.setName(productVO.getName());
        product.setPrice(productVO.getPrice());
        product.setWeight(productVO.getWeight());

        return product;
    }

    public static ProductVO productFromVoToEntitie(Product product) {
        ProductVO productVO = new ProductVO();



        return productVO;
    }
}
