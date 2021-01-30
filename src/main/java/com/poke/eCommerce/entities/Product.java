package com.poke.eCommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class Product {

    /**
     * The product id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_PRODUCT")
    @Column(name = "ID_PRODUCT", nullable = false, unique = true)
    private Long idProduct;

    @Column(name = "NAME", length = 256)
    private String name;

    @Column(name = "PRICE", nullable = false)
    private Long price;

    @Column(name = "WEIGHT", nullable = false)
    private Long weight;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER , cascade = CascadeType.PERSIST)
    private List<ListProduct> listProducts;

}