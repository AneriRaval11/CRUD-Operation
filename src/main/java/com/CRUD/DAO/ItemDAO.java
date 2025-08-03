package com.CRUD.DAO;

import com.CRUD.Entity.Item;
import com.CRUD.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ItemDAO {
    @Autowired
    private ItemRepository repo;

    public Item save(Item item) {
        item.setFinalPrice(item.getPrice() * (1 - item.getDiscount() / 100.0));
        return repo.save(item);
    }

    public Optional<Item> findById(Long id) {
        return repo.findById(id);
    }

    public List<Item> findAll() {
        return repo.findAll();
    }

    public boolean existsById(Long id) {
        return repo.existsById(id);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public boolean existsByName(String name) {
        return repo.existsByName(name);
    }
}
