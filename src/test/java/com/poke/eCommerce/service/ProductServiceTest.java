package com.poke.eCommerce.service;

import com.poke.eCommerce.ECommerceApplication;
import com.poke.eCommerce.entities.Product;
import com.poke.eCommerce.valueObject.ProductVO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@SpringBootTest(classes = ECommerceApplication.class)
@WebAppConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    public void findProductByIdTest(){
        //given
        Long idProduct = 1L;
        //when
        ProductVO productVO = productService.findProductById(idProduct);
        //then
        Assert.assertTrue(productVO.getIdProduct() == 1L);
    }


    @Test
    public void findProductByNameTest() {
        //given
        String name = "Radio";
        //when
        ProductVO productVO = productService.findProductByName("Radio");
        //then
        Assert.assertTrue(productVO.getName().equals("Radio"));
    }

    @Test
    public void findAllProductTest() {

        //when
        List<Product> findAll = productService.findAllProduct();
        //then
        Assert.assertTrue(findAll.size() == 5);
    }
    @Test
    public void deletProductByIDTest() {
        //given
        Long id = 4L;
        //when
        boolean deletProductByID = productService.deletProductByID(id);
        //then
        Assert.assertTrue(deletProductByID);
    }

    @Test
    public void SortProductByPriceTest() {

        //when
        List<Product> sortedList1 = productService.sortProduct("price");
        List<Product> sortedList2 = productService.findAllProduct().stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
        //then
        Assert.assertEquals(sortedList1.get(0).getPrice(), sortedList2.get(0).getPrice());
        Assert.assertEquals(sortedList1.get(1).getPrice(), sortedList2.get(1).getPrice());
        Assert.assertEquals(sortedList1.get(2).getPrice(), sortedList2.get(2).getPrice());
        Assert.assertEquals(sortedList1.get(3).getPrice(), sortedList2.get(3).getPrice());
    }

}
