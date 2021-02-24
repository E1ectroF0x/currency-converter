package org.example.currencyConverter.controller;


import org.example.currencyConverter.model.InputModel;
import org.example.currencyConverter.model.OutputModel;
import org.example.currencyConverter.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/convert")
public class ConverterController {

    @Autowired
    private ConverterService converterService;

    @PostMapping
    public OutputModel convertValueToValue(@RequestBody InputModel inputmodel) {
        return converterService.convertValue(inputmodel);
    }

}
