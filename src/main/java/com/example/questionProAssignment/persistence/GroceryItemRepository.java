package com.example.questionProAssignment.persistence;

import com.example.questionProAssignment.model.entity.GroceryItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryItemRepository extends CrudRepository<GroceryItem, Long> {
}

