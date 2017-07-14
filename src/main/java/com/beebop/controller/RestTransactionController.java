package com.beebop.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@Api("Rest controller for managing the Transaction related operations")
public class RestTransactionController implements TransactionController {
    @GetMapping
    public String hi() {
        return "hi";
    }
}
