package com.poke.eCommerce.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * amount and a creation date
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "SEQ_BILL", sequenceName = "SEQ_BILL", allocationSize = 1)
@Table(name = "BILL")
@Entity(name = "Bill")
public class Bill {

    /**
     * The Bill ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQ_BILL")
    @Column(name = "ID_BILL", nullable = false, unique = true)
    private Long idBill;

    @Column(name = "AMOUNT", nullable = false)
    private Long amount;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_CREATION")
    private Date dateCreation;
}
