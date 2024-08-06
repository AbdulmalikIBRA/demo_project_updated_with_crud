package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;

import java.util.List;

/**
 * UserController is a REST controller for handling user-related requests.
 * It provides endpoints for retrieving, creating, updating, and deleting users.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    /**
     * Constructor for UserController.
     * @param userService the user service to handle business logic.
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Retrieves all users.
     * @return a list of UserDTO objects.
     */
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Creates a new user.
     * @param userDTO the data transfer object representing the user to be created.
     * @return the created UserDTO object.
     */
    @PostMapping
    public UserDTO createUser(UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    /**
     * Updates an existing user.
     * @param id the ID of the user to be updated.
     * @param userDTO the data transfer object representing the updated user.
     * @return the updated UserDTO object.
     */
    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

    /**
     * Deletes a user.
     * @param id the ID of the user to be deleted.
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
