package com.app.accounts.controllers;

import com.app.accounts.config.AccountServiceConfig;
import com.app.accounts.model.Accounts;
import com.app.accounts.model.Customer;
import com.app.accounts.model.Properties;
import com.app.accounts.repositories.AccountsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private AccountServiceConfig accountServiceConfig;

    @PostMapping("/myAccounts")
    public Accounts getAccountDetails(@RequestBody Customer customer) {
        return accountsRepository.findAccountsByCustomerId(customer.getCustomerId());
    }

    @GetMapping("/accounts/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(accountServiceConfig.getMsg(), accountServiceConfig.getBuildVersion(), accountServiceConfig.getMailDetails(), accountServiceConfig.getActiveBranches());
        return ow.writeValueAsString(properties);

    }
}
