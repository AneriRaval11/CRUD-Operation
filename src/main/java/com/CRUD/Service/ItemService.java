package com.CRUD.Service;

import com.CRUD.DTO.ItemDTO;

import java.util.List;

public interface ItemService {
    ItemDTO create(ItemDTO dto);
    List<ItemDTO> getAll();
    ItemDTO getById(Long id);
    ItemDTO update(Long id, ItemDTO dto);
    void delete(Long id);

}
