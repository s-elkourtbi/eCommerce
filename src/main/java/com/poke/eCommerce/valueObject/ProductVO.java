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

    private String name;

    private Long price;

    private Long weight;
}
