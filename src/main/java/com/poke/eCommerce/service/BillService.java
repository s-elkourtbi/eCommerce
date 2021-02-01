package com.poke.eCommerce.service;

import com.poke.eCommerce.entities.Bill;

import java.util.Date;
import java.util.List;

public interface BillService {
    List<Bill> sortBill(String sort);

    void generateBill(Date date, Double amount);
}
