package com.CRUD.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * The entity class Item which stores the details of the item.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int discount;
    private double finalPrice;
}
