package com.app.accounts.controllers;

import com.app.accounts.model.Accounts;
import com.app.accounts.model.Customer;
import com.app.accounts.repositories.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    @Autowired
    private AccountsRepository accountsRepository;

    @PostMapping("/myAccounts")
    public Accounts getAccountDetails(@RequestBody  Customer customer){
        return accountsRepository.findAccountsByCustomerId(customer.getCustomerId());
    }
}
