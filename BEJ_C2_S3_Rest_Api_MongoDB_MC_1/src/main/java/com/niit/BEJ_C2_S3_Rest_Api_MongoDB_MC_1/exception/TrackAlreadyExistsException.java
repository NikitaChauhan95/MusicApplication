/*
 *Author Name: Nikita Chauhan
 *Date: 24-11-2022
 *Created With: IntelliJ IDEA Community Edition
 */


package com.niit.BEJ_C2_S3_Rest_Api_MongoDB_MC_1.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Track already exists")
public class TrackAlreadyExistsException extends Exception {
}
