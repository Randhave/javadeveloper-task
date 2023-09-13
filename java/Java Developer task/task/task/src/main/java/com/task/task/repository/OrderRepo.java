package com.task.task.repository;

import com.task.task.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public interface OrderRepo extends JpaRepository<Order,Long> {
}
