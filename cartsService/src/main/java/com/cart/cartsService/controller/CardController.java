package com.cart.cartsService.controller;

import com.cart.cartsService.config.CardsServiceConfig;
import com.cart.cartsService.domain.Properties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class CardController {

    private final CardsServiceConfig cardsConfig;
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

    @GetMapping("/card/properties")
    public String getPropertyDetails() throws JsonProcessingException{
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(cardsConfig.getMsg(), cardsConfig.getBuildVersion(),
                cardsConfig.getMailDetails(), cardsConfig.getActiveBranches());
        String jsonStr = ow.writeValueAsString(properties);
        return jsonStr;
    }
}
