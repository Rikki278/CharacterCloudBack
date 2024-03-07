package org.example.authservice.controller;

import jakarta.ws.rs.Path;
import org.example.authservice.model.User;
import org.example.authservice.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    UserAccountService userAccountService;

    @Autowired
    public UserController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @DeleteMapping("/admin_only/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id){
        userAccountService.deleteByIdUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
