package com.poke.eCommerce.service;

import com.poke.eCommerce.ECommerceApplication;
import com.poke.eCommerce.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.CoreMatchers.is;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = ECommerceApplication.class)
@WebAppConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Autowired
    JdbcTemplate jdbcTemplate;


//    @Test
//    public void getOrderById_shouldGiveCorrespondigOrder(){
//        //given
//        Long idProduct = 1l;
//        //when
//        Product product = productService.findProductById(idProduct);
//        //then
//        assertThat(order.getId(), is(1l));
//    }

}
