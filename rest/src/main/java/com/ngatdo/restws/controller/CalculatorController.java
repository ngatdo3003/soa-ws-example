package com.ngatdo.restws.controller;


import com.ngatdo.restws.dto.SumRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @PostMapping("/sum")
    public int sum(@RequestBody SumRequestDTO request) {
        return request.getFirstNumber() + request.getSecondNumber();
    }

    @GetMapping("/sqr/{number}")
    public double sqr(@PathVariable("number") Integer number) {
        return Math.pow(number, 2);
    }
}