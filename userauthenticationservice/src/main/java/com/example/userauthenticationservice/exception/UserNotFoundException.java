/*
 *Author Name: Nikita Chauhan
 *Date: 29-11-2022
 *Created With: IntelliJ IDEA Community Edition
 */


package com.example.userauthenticationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Login Failed!!")
public class UserNotFoundException extends Exception {
}
