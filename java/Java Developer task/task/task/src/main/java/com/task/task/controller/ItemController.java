package com.task.task.controller;

import com.task.task.model.Item;
import com.task.task.repository.ItemRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private ItemRepo itemRepo ;

    @PostMapping("/item-new")
    public ResponseEntity<Item> addNewItem(@RequestBody Item items) {
        Item items1 = this.itemRepo.save(items);
        return new ResponseEntity<>(items1, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public  ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = this.itemRepo.findAll();
        return new ResponseEntity<>(items,HttpStatus.OK);
    }

    @GetMapping("/item/{itemId}")
    public ResponseEntity<Item> getSingleItems(@RequestParam("itemId")Long itemId) {
        Item item = this.itemRepo.findById(itemId).get();
        return new ResponseEntity<>(item,HttpStatus.OK);
    }
}
