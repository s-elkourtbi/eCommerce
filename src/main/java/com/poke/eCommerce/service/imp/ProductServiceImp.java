package com.poke.eCommerce.service.imp;

import com.poke.eCommerce.dto.ProducDto;
import com.poke.eCommerce.entities.Product;
import com.poke.eCommerce.repository.ProductRepository;
import com.poke.eCommerce.service.ProductService;
import com.poke.eCommerce.valueObject.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EntityManager em;

    @Override
    public Boolean newProduct(ProductVO productVO) {
        Boolean success = Boolean.FALSE;
        try {

            productRepository.save(ProducDto.productFromVoToEntitie(productVO));
            success = Boolean.TRUE;
            log.info("A new product has being added to to data base ! " + productVO.getName());
        }catch (TransactionException e) {
            log.error(e.getMessage());
        }
        return success;
    }

    @Override
    public ProductVO findProductByName(String name) {
        ProductVO productVO = new ProductVO();
        try {
            if(name != null) {
                Query q = em.createNamedQuery("product.findByName");
                q.setParameter("name", name);
                productVO = ProducDto.productFromEntitieToVo(
                        (Product) q.getSingleResult());
                log.info("Product found" + productVO.getName());
            }
        } catch (TransactionException e) {
            log.error(e.getMessage());
        }
        return  productVO;
    }

    @Override
    public ProductVO findProductById(Long idProduct) {
        ProductVO productVO = new ProductVO();
        try {
            if(idProduct != null) {
               productVO = ProducDto.productFromEntitieToVo(productRepository.findById(idProduct).get());
            }
        } catch (TransactionException e) {
            log.error(e.getMessage());
        }
        return productVO;
    }

    @Override
    public List<Product> findAllProduct() {
        List<Product> product = new ArrayList<Product>();
        try {
             {
                product = productRepository.findAll();
            }
        } catch (TransactionException e) {
            log.error(e.getMessage());
        }
        return product;
    }

    @Override
    public boolean deletProductByName(String name) {
        Boolean success = Boolean.FALSE;
        ProductVO ProductVO = findProductByName(name);
        try {

            if (ProductVO != null) {
                productRepository.
                        delete(productRepository.findById(ProductVO.getIdProduct()).get());
                success = Boolean.TRUE;
                log.info(ProductVO.getName() + "delet !");
            }
        }
        catch(TransactionException e){
            log.error(e.getMessage());
        }
        return success;
    }

    @Override
    public boolean deletProductByID(Long idProduct) {
        Boolean success = Boolean.FALSE;
        try {

            if (idProduct != null) {
                productRepository.
                        delete(productRepository.findById(idProduct).get());
                success = Boolean.TRUE;
                log.info("the product Id number "+idProduct + "was deleted !");
            }
        }
        catch(TransactionException e){
            log.error(e.getMessage());
        }
        return success;
    }

}
