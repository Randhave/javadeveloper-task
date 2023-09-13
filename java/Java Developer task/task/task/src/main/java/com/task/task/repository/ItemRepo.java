package com.task.task.repository;

import com.task.task.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ItemRepo extends JpaRepository<Item,Long> {
}
