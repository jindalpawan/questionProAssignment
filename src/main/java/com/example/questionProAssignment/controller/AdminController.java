package com.example.questionProAssignment.controller;

import com.example.questionProAssignment.model.entity.GroceryItem;
import com.example.questionProAssignment.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/items")
public class AdminController {
    @Autowired
    private GroceryItemService itemService;

    @PostMapping
    public GroceryItem createGroceryItem(@RequestBody GroceryItem item) {
        return itemService.createGroceryItem(item);
    }

    @GetMapping()
    public List<GroceryItem> getAllGroceryItems() {
        return itemService.getAllGroceryItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryItem> getGroceryItem(@PathVariable Long id) {
        Optional<GroceryItem> item = itemService.getGroceryItemById(id);
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroceryItem> updateGroceryItem(@PathVariable Long id, @RequestBody GroceryItem updatedItem) {
        GroceryItem item = itemService.updateGroceryItem(id, updatedItem);
        return item != null ? ResponseEntity.ok(item) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroceryItem(@PathVariable Long id) {
        itemService.deleteGroceryItem(id);
        return ResponseEntity.noContent().build();
    }
}
