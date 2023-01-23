package com.app.accounts.service.clients;

import com.app.accounts.dto.CardsDto;
import com.app.accounts.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("cards")
public interface CardsFeignClient {
@RequestMapping(method = RequestMethod.POST,value = "myCards",consumes = "application/json")
List<CardsDto> getCardDetails(@RequestBody Customer customer);
}
