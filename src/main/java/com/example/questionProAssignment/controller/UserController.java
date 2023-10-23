package com.example.questionProAssignment.controller;

import com.example.questionProAssignment.model.entity.GroceryItem;
import com.example.questionProAssignment.model.entity.Order;
import com.example.questionProAssignment.model.entity.OrderItem;
import com.example.questionProAssignment.service.GroceryItemService;
import com.example.questionProAssignment.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private GroceryItemService groceryItemService;
    @Autowired
    private OrderItemService orderItemService;

    // View the list of available grocery items
    @GetMapping("/items")
    public List<GroceryItem> viewAvailableItems() {
        return groceryItemService.getAllGroceryItems();
    }


    // Ability to book multiple grocery items in a single order
    @PostMapping("/orders")
    public Order createOrder(@RequestBody List<OrderItem> orderItems) {
        return orderItemService.createOrder(orderItems);
    }
}
