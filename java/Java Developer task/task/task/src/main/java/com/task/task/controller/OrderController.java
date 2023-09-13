package com.task.task.controller;

import com.task.task.model.Order;
import com.task.task.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepo orderRepo ;

    @PostMapping("/new-order")
    public ResponseEntity<Order> createNewOrder(@RequestBody Order order) {

        Order order1 = this.orderRepo.save(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = this.orderRepo.findAll();
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<Order> getSingleOrder(@RequestParam("orderId") Long orderId) {
        Order order = this.orderRepo.findById(orderId).get();
        return  new ResponseEntity<>(order,HttpStatus.OK);
    }
    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<String> deleteOrder(@RequestParam("orderId") Long orderId) {
        this.orderRepo.deleteById(orderId);
        return  new ResponseEntity<>("order deleted successfully",HttpStatus.OK);
    }


}
