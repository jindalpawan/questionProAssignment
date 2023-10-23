package com.example.questionProAssignment.service;

import com.example.questionProAssignment.model.entity.GroceryItem;
import com.example.questionProAssignment.persistence.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroceryItemService {
    @Autowired
    private GroceryItemRepository itemRepository;

    // Create a new grocery item
    public GroceryItem createGroceryItem(GroceryItem item) {
        return itemRepository.save(item);
    }

    // Get all grocery items
    public List<GroceryItem> getAllGroceryItems() {
        List<GroceryItem> items = new ArrayList<>();
        itemRepository.findAll().forEach(items::add);
        return items;
    }

    // Get a grocery item by ID
    public Optional<GroceryItem> getGroceryItemById(Long id) {
        return itemRepository.findById(id);
    }

    // Update an existing grocery item
    public GroceryItem updateGroceryItem(Long id, GroceryItem updatedItem) {
        if (itemRepository.existsById(id)) {
            updatedItem.setId(id);
            return itemRepository.save(updatedItem);
        } else {
            return null; // Item with the given ID does not exist
        }
    }

    // Delete a grocery item
    public void deleteGroceryItem(Long id) {
        itemRepository.deleteById(id);
    }
}
