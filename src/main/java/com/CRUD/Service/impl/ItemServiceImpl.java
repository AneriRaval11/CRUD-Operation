package com.CRUD.Service.impl;

import com.CRUD.DAO.ItemDAO;
import com.CRUD.DTO.ItemDTO;
import com.CRUD.Exception.ResourceNotFoundException;
import com.CRUD.Mapper.ItemMapper;
import com.CRUD.Service.ItemService;
import com.CRUD.Validator.ItemValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDAO dao;

    @Autowired
    private ItemMapper mapper;

    @Autowired
    private ItemValidator validator;


    @Override
    public ItemDTO create(ItemDTO dto) {
        validator.validateNameUnique(dto.getName());
        return mapper.toDTO(dao.save(mapper.toEntity(dto)));
    }

    @Override
    public List<ItemDTO> getAll() {
        return dao.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ItemDTO getById(Long id) {
        var item = dao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found: " + id));
        item.setFinalPrice(item.getPrice() * (1 - item.getDiscount() / 100.0));
        return mapper.toDTO(item);    }

    @Override
    public ItemDTO update(Long id, ItemDTO dto) {
        var item = dao.findById(id).orElseThrow(()->new ResourceNotFoundException("Item not found: " + id));
        var updatedItem = item.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .discount(dto.getDiscount())
                .finalPrice(dto.getPrice()*(1-dto.getDiscount() / 100.0))
                .build();
        return mapper.toDTO(dao.save(updatedItem));
    }

    @Override
    public void delete(Long id) {
        if (!dao.existsById(id)) {
            throw new ResourceNotFoundException("Item not found: " + id);
        }
        dao.deleteById(id);
    }
 }

