package com.example.dao;

import com.example.model.User;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static List<User> users = new ArrayList<>();

    static {
        // Adding sample users for testing purposes
        users.add(new User("John Doe", "john.doe@example.com", "1990-01-01", "password123"));
        users.add(new User("Jane Smith", "jane.smith@example.com", "1985-07-15", "password456"));
    }

    // Authenticate user by email and password
    public User authenticateUser(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;  // Return null if authentication fails
    }

    // Add a new user
    public void addUser(User user) {
        users.add(user);
    }

    // Get all users (for user list page)
    public List<User> getAllUsers() {
        return users;
    }
}
