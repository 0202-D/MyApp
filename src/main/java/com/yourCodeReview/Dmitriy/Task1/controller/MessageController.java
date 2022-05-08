package com.yourCodeReview.Dmitriy.Task1.controller;

import com.yourCodeReview.Dmitriy.Task1.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("message")
public class MessageController {
    @Autowired
   private Cache cache;

    @GetMapping
    public Map<String, String> keys() {
        return cache.storage();
    }

    @GetMapping("{key}")
    public String get(@PathVariable String key) {
        return cache.get(key);
    }

    @PostMapping
    public String set(@RequestBody String key, String message) {
     return cache.put(key,message);
    }

    @DeleteMapping("{key}")
    public void delete(@PathVariable String key) {
       cache.delete(key);
    }
}



