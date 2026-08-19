package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/api/users")
    public List<Map<String, Object>> getUsers() {

        return List.of(
            Map.of(
                "id", 1,
                "name", "Johny",
                "email", "john@examplebgfffffff.com"
            ),
            Map.of(
                "id", 2,
                "name", "Alice",
                "email", "alice@example.com"
            ),
            Map.of(
                "id", 3,
                "name", "Bob",
                "email", "bob@example.com"
            )
        );
    }
}