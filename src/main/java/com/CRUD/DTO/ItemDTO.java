package com.CRUD.DTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ItemDTO {
    private Long id;
    private String name;
    private double price;
    private int discount;
    private double finalPrice;
}
