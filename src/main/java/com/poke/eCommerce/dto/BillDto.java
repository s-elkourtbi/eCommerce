package com.poke.eCommerce.dto;

import com.poke.eCommerce.entities.Bill;
import com.poke.eCommerce.valueObject.BillVO;

public class BillDto {

    public static BillVO billFromEntitieToVo(Bill bill) {
        BillVO billVO = new BillVO();

        billVO.setAmount(bill.getAmount());
        billVO.setDateCreation(bill.getDateCreation());

        return billVO;
    }

    public static Bill billFromEntitieToVo(BillVO billVo) {
        Bill bill = new Bill();

        bill.setAmount(billVo.getAmount());
        bill.setDateCreation(billVo.getDateCreation());

        return bill;
    }
}
