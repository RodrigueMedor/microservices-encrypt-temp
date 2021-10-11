package com.account.accountservice.controller;

//import ch.qos.logback.core.net.ObjectWriter;
import com.account.accountservice.config.AccountsServiceConfig;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.account.accountservice.domain.Properties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountsServiceConfig accountsConfig;
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

    @GetMapping("/account/properties")
    public String getPropertyDetails() throws JsonProcessingException{
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(accountsConfig.getMsg(), accountsConfig.getBuildVersion(),
                accountsConfig.getMailDetails(), accountsConfig.getActiveBranches());
        String jsonStr = ow.writeValueAsString(properties);
        return jsonStr;
    }
}
