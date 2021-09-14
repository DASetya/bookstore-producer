package com.enigma.bookshop.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class HelloWorld {

    @GetMapping("/hello")
    String hello(){
        return "Hello World";
    }

    // path variable
    // query string

    // localhost:8080/hello/1
    @GetMapping("/hello/{var}")
    public String pathVar(@PathVariable String var){
        return "Path var: " + var;
    }

    // define di url, biasanya untuk pagination, searching
    // localhost:8080/hello?var=1
    @GetMapping("/req-query")
    public String queryString(@RequestParam String var){
        return "Request Param: " + var;
    }

    // request body
    // localhost:8080/hello-body
    @PostMapping("/hello-body")
    public String reqBody(@RequestBody HashMap<String, String> mapBody){
        return "Request Body: " + mapBody;
    }
}
