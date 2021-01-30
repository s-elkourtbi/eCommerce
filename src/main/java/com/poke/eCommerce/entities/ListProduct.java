package com.poke.eCommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "SEQ_LIST_PRODUCT", sequenceName = "SEQ_LIST_PRODUCT", allocationSize = 1)
@Table(name = "LISTPRODUCT")
@Entity(name = "ListProduct")
public class ListProduct {

    /**
     * The Bill ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_LIST_PRODUCT")
    @Column(name = "ID_LISTPRODUCT", nullable = false, unique = true)
    private Long idListProduct;

    /**
     * (FK) in order
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_ORDER")
    private Order order;

    /**
     * (FK) in order
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ID_PRODUCT")
    private Product product;
}
