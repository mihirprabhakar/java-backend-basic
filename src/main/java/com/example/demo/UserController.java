// package com.example.demo;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RestController;

// import java.util.List;
// import java.util.Map;

// @RestController
// public class UserController {

//     @GetMapping("/api/users")
//     public List<Map<String, Object>> getUsers() {

//         return List.of(
//             Map.of(
//                 "id", 1,
//                 "name", "Johny",
//                 "email", "john@examplebgfffffff.com"
//             ),
//             Map.of(
//                 "id", 2,
//                 "name", "Alice",
//                 "email", "alice@example.com"
//             ),
//             Map.of(
//                 "id", 3,
//                 "name", "Bob",
//                 "email", "bob@example.com"
//             )
//         );
//     }
//     @PostMapping("/api/users")
//     public Map<String, Object> createUser(@RequestBody Map<String, Object> user) {

//         return Map.of(
//             "message", "User created successfully",
//             "user", user
//         );
//     }
// }

package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private final List<Map<String, Object>> users = new ArrayList<>(
        List.of(
            Map.of(
                "id", 1,
                "name", "Johny",
                "email", "john@example.com"
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
        )
    );

    // GET - Get system health
    @GetMapping("/api/health")
    public Map<String, String> getHealth() {
        return Map.of("status", "Working with 100% health");
    }

    // GET - Get all users
    @GetMapping("/api/users")
    public List<Map<String, Object>> getUsers() {
        return users;
    }

    // POST - Add a new user
    @PostMapping("/api/users")
    public Map<String, Object> createUser(
            @RequestBody Map<String, Object> user) {

        int id = users.size() + 1;

        Map<String, Object> newUser = Map.of(
            "id", id,
            "name", user.get("name"),
            "email", user.get("email")
        );

        users.add(newUser);

        return newUser;
    }

    // PUT - Update an existing user
    @PutMapping("/api/users/{id}")
    public Map<String, Object> updateUser(
            @PathVariable int id,
            @RequestBody Map<String, Object> user) {

        for (int i = 0; i < users.size(); i++) {

            Map<String, Object> existingUser = users.get(i);

            if ((int) existingUser.get("id") == id) {

                Map<String, Object> updatedUser = Map.of(
                    "id", id,
                    "name", user.get("name"),
                    "email", user.get("email")
                );

                users.set(i, updatedUser);

                return updatedUser;
            }
        }

        return Map.of(
            "error", "User not found"
        );
    }

    // DELETE - Delete a user
    @DeleteMapping("/api/users/{id}")
    public Map<String, Object> deleteUser(
            @PathVariable int id) {

        for (int i = 0; i < users.size(); i++) {

            Map<String, Object> user = users.get(i);

            if ((int) user.get("id") == id) {
                users.remove(i);

                return Map.of(
                    "message", "User deleted successfully",
                    "id", id
                );
            }
        }

        return Map.of(
            "error", "User not found"
        );
    }
}

