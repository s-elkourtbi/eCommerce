package com.poke.eCommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

/**
 * The product entitie.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "SEQ_PRODUCT", sequenceName = "SEQ_PRODUCT", allocationSize = 1)
@Table(name = "PRODUCT")
@Entity(name = "Product")
@DynamicUpdate
@NamedQuery(name = "product.findByName",
        query = "SELECT u FROM Product u WHERE u.name = :name")
public class Product {

    /**
     * The product id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_PRODUCT")
    @Column(name = "ID_PRODUCT", nullable = false, unique = true)
    private Long idProduct;

    @Column(name = "NAME", length = 256, unique = true)
    private String name;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "WEIGHT", nullable = false)
    private Long weight;

//    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER , cascade = CascadeType.PERSIST)
//    private List<ListProduct> listProducts;

//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "ID_ORDER")
//    private Order order;

}
