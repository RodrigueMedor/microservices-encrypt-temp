package com.loans.loansService.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.loans.loansService.config.LoansServiceConfig;
import com.loans.loansService.domain.Properties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class LoanController {

    private final LoansServiceConfig loansConfig;
  /*  private final AccountsRepository accountsRepository;

    @PostMapping("/myAccount")
    public Account getAccountDetails(@RequestBody Customer customer){
        Account account = accountsRepository.findByCustomerId(customer.getCustomerId());
        if(account != null){
            return account;
        }else {
            return null;
        }
    }*/

    @GetMapping("/loan/properties")
    public String getPropertyDetails() throws JsonProcessingException{
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(loansConfig.getMsg(), loansConfig.getBuildVersion(),
                loansConfig.getMailDetails(), loansConfig.getActiveBranches());
        String jsonStr = ow.writeValueAsString(properties);
        return jsonStr;
    }
}
