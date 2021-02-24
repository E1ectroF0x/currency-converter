package org.example.currencyConverter.controller;

import org.example.currencyConverter.model.Currency;
import org.example.currencyConverter.model.Rate;
import org.example.currencyConverter.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rates")

public class RateController {
    @Autowired
    private RateService rateService;

   /*
    @GetMapping("/{value}")
    public Rate getRates(@PathVariable String value, @RequestParam(required = false) String type){

        if ("1".equals(type)) {
           return rateService.getRateByAbbreviation(value);
        }
        else if ("0".equals(type)) {
            return rateService.getRateByID(value);
        }
        else {
            return rateService.getRateByAbbreviation(value);
        }

    }

    */

    // TODO: implement api/rates/update/{id}/{value}
    // need to implement update rate value for single currency
    // with value must be updated date


/*
    @GetMapping("/{value}")
    public Rate getRateByID(@PathVariable String value, @RequestParam(defaultValue = "0") String type) {
        if (type.equals("1")) {
            return rateService.getRateByAbbreviation(value);
        } else if (type.equals("0")) {
            return rateService.getRateByID(value);
        }
        else {
            return rateService.getRateByAbbreviation(value);
        }
    }
 */

    @GetMapping("/all")
    public List<Rate> getRateList() {
        return rateService.getAllRates();
    }
}
