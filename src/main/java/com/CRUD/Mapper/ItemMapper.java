package com.CRUD.Mapper;

import com.CRUD.DTO.ItemDTO;
import com.CRUD.Entity.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    public Item toEntity(ItemDTO dto) {
        return Item.builder()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .discount(dto.getDiscount())
                .build();
    }

    public ItemDTO toDTO(Item item) {
        return ItemDTO.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .discount(item.getDiscount())
                .finalPrice(item.getFinalPrice())
                .build();
    }
}
