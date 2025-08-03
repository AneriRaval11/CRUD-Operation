package com.CRUD.Validator;

import com.CRUD.DAO.ItemDAO;
import com.CRUD.Exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemValidator {
    @Autowired
    private ItemDAO dao;
    public void validateNameUnique(String name) {
        if (dao.existsByName(name)) {
            throw new BadRequestException("Item name already exists: " + name);
        }
    }
}
