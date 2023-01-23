package com.app.accounts.service.clients;

import com.app.accounts.dto.LoansDto;
import com.app.accounts.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Method;
import java.util.List;

@FeignClient("loans")
public interface LoansFeignClient {
@RequestMapping(method = RequestMethod.POST,value = "myLoans",consumes = "application/json")
    List<LoansDto> getLoanDetails(Customer customer);
}
