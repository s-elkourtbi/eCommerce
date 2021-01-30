package com.poke.eCommerce.entities;

import com.poke.eCommerce.utils.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * The entitie of an order.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "SEQ_ORD", sequenceName = "SEQ_ORD", allocationSize = 1)
@Table(name = "ORD")
@Entity(name = "Ord")
public class Order {

    /**
     * The Order ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_ORD")
    @Column(name = "ID_ORD", nullable = false, unique = true)
    private Long idOrder;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;

    @Column(name = "SHIPMENTAMOUNT", nullable = false)
    private Long shipmentAmount;

    @Column(name = "TOTALAMOUNT", nullable = false)
    private Long totalAmount;

    @Column(name = "WEIGHT", nullable = false)
    private Long weight;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER , cascade = CascadeType.PERSIST)
    private List<ListProduct> listProducts;

}
