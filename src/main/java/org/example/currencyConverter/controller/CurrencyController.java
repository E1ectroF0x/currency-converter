package org.example.currencyConverter.controller;

import org.example.currencyConverter.model.Currency;
import org.example.currencyConverter.model.ValueModel;
import org.example.currencyConverter.service.CurrencyService;
import org.example.currencyConverter.service.impl.CurrencyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    /*@GetMapping
    public Currency getCurrency() {
        return currencyService.getCurrency();
    }
     */

    @GetMapping("/{abbreviation}")
    public Currency getCurrencyByAbbreviation(@PathVariable String abbreviation){
       return currencyService.getCurrencyByAbbreviation(abbreviation);
    }

    @GetMapping("/all")
    public List<Currency> getCurrencyList() {
        //currencyService.saveValue();
        return currencyService.getAllCurrencies();
    }

    @GetMapping("/update")
    public void updateCurrency() {
        currencyService.uploadCurrencies();
    }



    /*
    @GetMapping("/{value}")
    public List<Currency> getSortedCurrencies(@PathVariable double value) {
        return currencyService.getSortedCurrencies(value);
    }

    @PostMapping
    public List<Currency> getSortedCurrenciesPost(@RequestBody ValueModel value) {
        return currencyService.getSortedCurrencies(value.getValue());
    }

    @GetMapping
    public List<Currency> getSortedCurrenciesParam(@RequestParam double value) {
        return currencyService.getSortedCurrencies(value);
    }
*/
}
