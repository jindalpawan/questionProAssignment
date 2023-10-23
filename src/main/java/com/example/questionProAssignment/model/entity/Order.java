package com.example.questionProAssignment.model.entity;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
@Table(name="grocery_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<OrderItem> orderItems;

    private Float totalAmount;

//    public List<OrderItem> getOrderItems() {
//        return orderItems;
//    }

//    public void setOrderItems(List<OrderItem> orderItems) {
//        this.orderItems = orderItems;
//    }
    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }
}
