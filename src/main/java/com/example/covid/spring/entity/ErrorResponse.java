package com.example.covid.spring.entity;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class ErrorResponse {


    int status;
    String message;
    LocalDateTime timeStamp;
    

}
