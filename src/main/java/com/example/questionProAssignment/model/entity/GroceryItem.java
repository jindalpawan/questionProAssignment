package com.example.questionProAssignment.model.entity;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "grocery_item")
public class GroceryItem {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double price;
    private int quantity;
}

