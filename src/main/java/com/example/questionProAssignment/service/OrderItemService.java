package com.example.questionProAssignment.service;

import com.example.questionProAssignment.exception.InsufficientInventoryException;
import com.example.questionProAssignment.exception.ResourceNotFoundException;
import com.example.questionProAssignment.model.entity.GroceryItem;
import com.example.questionProAssignment.model.entity.Order;
import com.example.questionProAssignment.model.entity.OrderItem;
import com.example.questionProAssignment.persistence.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private GroceryItemService groceryItemService;

    // Create a new order with a list of order items
    public Order createOrder(List<OrderItem> orderItems) {
        Order order = new Order();

        float totalAmount = 0.0F;

        for (OrderItem item : orderItems) {
            GroceryItem groceryItem = groceryItemService.getGroceryItemById(item.getGroceryItemId())
                    .orElseThrow(() -> new ResourceNotFoundException("Grocery item not found with id: " + item.getGroceryItemId()));

            if (groceryItem.getQuantity() < item.getQuantity()) {
                throw new InsufficientInventoryException("Insufficient inventory for item: " + groceryItem.getName());
            }

            groceryItem.setQuantity(groceryItem.getQuantity() - item.getQuantity());
            groceryItemService.updateGroceryItem(groceryItem.getId(), groceryItem);

            // Calculate the total amount for the order
            totalAmount += groceryItem.getPrice() * item.getQuantity();

        }

        order.setOrderItems(orderItems);
        order.setTotalAmount(totalAmount);

        return orderRepository.save(order);
    }
}
