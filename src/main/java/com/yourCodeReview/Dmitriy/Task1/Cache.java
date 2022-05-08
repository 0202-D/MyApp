package com.yourCodeReview.Dmitriy.Task1;

import com.yourCodeReview.Dmitriy.Task1.exception.NotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Cache {
    private final Map<String, String> cache = new HashMap<>();

    public String get(String key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            throw new NotFoundException("request by key " + key + " not found");
        }
    }

    public String put(String key, String message) {
        if (key != null && message != null && !message.equals("")) {
            cache.put(key, message);
        }
        return message;
    }

    public Map<String, String> storage() {
        return cache;
    }

    public void delete(String key) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
    }
}