package com.poke.eCommerce.valueObject;

import com.poke.eCommerce.utils.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderVO {

    private Status status;

    private Long shipmentAmount;

    private Long totalAmount;

    private Long weight;

}
