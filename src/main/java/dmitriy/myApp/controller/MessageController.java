package dmitriy.myApp.controller;

import dmitriy.myApp.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("message")
public class MessageController {

    private long counter = 1;
    private final Map<String, String> myCash = new HashMap<>();

    @GetMapping
    public Set<String> KEYS() {
        return myCash.keySet();
    }

    @GetMapping("{id}")
    public String GET(@PathVariable String id) {
        if (myCash.containsKey(id)) {
            return myCash.get(id);
        } else {
            throw new NotFoundException();
        }
    }

    @PostMapping
    public String SET(@RequestBody String message) {
        myCash.put(String.valueOf(counter++), message);
        return message;
    }

    @DeleteMapping("{id}")
    public void DEL(@PathVariable String id) {
        myCash.remove(myCash.get(id));
    }
}



