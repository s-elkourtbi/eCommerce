package com.poke.eCommerce.valueObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {

    private Long idProduct;

    private String name;

    private Double price;

    private Long weight;
}
