/*
 *Author Name: Nikita Chauhan
 *Date: 29-11-2022
 *Created With: IntelliJ IDEA Community Edition
 */


package com.example.userauthenticationservice.controller;


import com.example.userauthenticationservice.domain.User;
import com.example.userauthenticationservice.exception.UserNotFoundException;
import com.example.userauthenticationservice.service.IUserService;
import com.example.userauthenticationservice.service.SecurityTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping("/api/v1")
public class UserController {

    private IUserService iUserService;
    private SecurityTokenGenerator securityTokenGenerator;


    @Autowired
    public UserController(IUserService iUserService, SecurityTokenGenerator securityTokenGenerator) {
        this.iUserService = iUserService;
        this.securityTokenGenerator = securityTokenGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveFun(@RequestBody User user) {
        return new ResponseEntity<>(iUserService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/fetch")
    public ResponseEntity<?> fetch() {
        return new ResponseEntity<>(iUserService.getAllUsers(), HttpStatus.OK);
    }


    @GetMapping("/api/v1/fetchById/{id}")
    public ResponseEntity<?> fetchById(@PathVariable int id) {
        return new ResponseEntity<>(iUserService.getByUserId(id), HttpStatus.OK);
    }


    @GetMapping("/login")
    public ResponseEntity<?> loginFun(@RequestBody User user) throws UserNotFoundException {
        try {
            iUserService.loginCheck(user.getUserName(), user.getPassword());
            Map<String, String> secretKey = new HashMap<>();
            secretKey = securityTokenGenerator.generateToken(user);
            return new ResponseEntity<>(secretKey, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException();
        } catch (Exception e) {
            return new ResponseEntity<>("Network Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteUserById{userId}")
    public ResponseEntity<?> deleteFunction(@PathVariable int userId) {
        iUserService.deleteById(userId);
        return new ResponseEntity<>("Record Deleted Successfully", HttpStatus.OK);
    }
}















