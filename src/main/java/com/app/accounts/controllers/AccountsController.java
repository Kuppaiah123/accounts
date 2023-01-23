package com.app.accounts.controllers;

import com.app.accounts.config.AccountServiceConfig;
import com.app.accounts.dto.CardsDto;
import com.app.accounts.dto.CustomerDetails;
import com.app.accounts.dto.LoansDto;
import com.app.accounts.model.Accounts;
import com.app.accounts.model.Customer;
import com.app.accounts.model.Properties;
import com.app.accounts.repositories.AccountsRepository;
import com.app.accounts.service.clients.CardsFeignClient;
import com.app.accounts.service.clients.LoansFeignClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountsController {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private AccountServiceConfig accountServiceConfig;
    @Autowired
    private CardsFeignClient cardsFeignClient;

    @Autowired
    private LoansFeignClient loansFeignClient;

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
@PostMapping("/myCustomerDetails")
    public  CustomerDetails getCustomerDetails(@RequestBody Customer customer){
        Accounts accounts=accountsRepository.findAccountsByCustomerId(customer.getCustomerId());
        List<CardsDto> cardsDtoList=cardsFeignClient.getCardDetails(customer);
        List<LoansDto> loansDtos = loansFeignClient.getLoanDetails(customer);
        CustomerDetails customerDetails=new CustomerDetails();
        customerDetails.setCards(cardsDtoList);
        customerDetails.setLoans(loansDtos);
        return customerDetails;
    }
}
