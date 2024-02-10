package com.dio.livecoding.springboot.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.livecoding.springboot.dto.UserDTO;
import com.dio.livecoding.springboot.model.UserModel;
import com.dio.livecoding.springboot.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "User", description = "the user Api")
@RestController
@RequestMapping("/v1/users")
public class UserContoller {
    @Autowired
    private UserService userService;

    @Operation(
        summary = "Get all users",
        description = "Get all users from the database"
    )

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of users")
    })
    
    
    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<Iterable<UserModel>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @Operation(
        summary = "Get user by id",
        description = "Get user by id from the database"
    )

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User found"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<UserModel> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @Operation(
        summary = "Create user",
        description = "Create user in the database"
    )

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User created")
    })

    @PostMapping
    public ResponseEntity<UserModel> create(@RequestBody @Valid UserDTO userDTO) {
        return ResponseEntity.ok(userService.create(userDTO));
    }

    @Operation(
        summary = "Update user",
        description = "Update user in the database"
    )

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User updated")
    })

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> update(@PathVariable Long id, @RequestBody @Valid UserDTO userDTO) {
        return ResponseEntity.ok(userService.update(id, userDTO));
    }

    @Operation(
        summary = "Delete user",
        description = "Delete user from the database"
    )

    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "User deleted")
    })

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
