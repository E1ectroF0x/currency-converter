package org.example.currencyConverter.controller;

import org.example.currencyConverter.model.Rate;
import org.example.currencyConverter.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/rates")

public class RateController {
    @Autowired
    private RateService rateService;
    @GetMapping("/{value}")
    public Rate getRates(@PathVariable String value, @RequestParam(required = false) String type){
        if (type.equals("1") || type == null){
           return rateService.getRateByAbbreviation(value);
        }
        else{
            return rateService.getRateByID(value);
        }

    }
}
