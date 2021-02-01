package com.poke.eCommerce.valueObject;

import com.poke.eCommerce.utils.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderVO {

    private Long idOrder;

    private Status status;

    private Double shipmentAmount;

    private Double totalAmount;

    private Long weight;

    private List<ProductVO> productVOs;

}
