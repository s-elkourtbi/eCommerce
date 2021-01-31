package com.poke.eCommerce.service.imp;

import com.poke.eCommerce.entities.Bill;
import com.poke.eCommerce.entities.Product;
import com.poke.eCommerce.repository.BillRepository;
import com.poke.eCommerce.service.BillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    public List<Bill> sortBill(String sort) {
        List<Bill> bills = new ArrayList<Bill>();
        try {
            switch(sort)
            {
                case "amount":
                    bills = billRepository.findAll(Sort.by(Sort.Direction.ASC, "amount"));
                    break;
                case "date":
                    bills = billRepository.findAll(Sort.by(Sort.Direction.ASC, "dateCreation"));
                    break;
                default:
                    System.out.println("no match");
            }
        } catch (TransactionException e) {
            log.error(e.getMessage());
        }
        return bills;
    }
}
