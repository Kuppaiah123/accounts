package com.app.accounts.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class CustomerDetails {

    private List<CardsDto> cards;

    private List<LoansDto> loans;
}
