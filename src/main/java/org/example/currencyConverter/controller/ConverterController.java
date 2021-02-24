package org.example.currencyConverter.controller;


import org.example.currencyConverter.model.InputModel;
import org.example.currencyConverter.model.OutputModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/convert")
public class ConverterController {

    @PostMapping
    public OutputModel convert(@RequestBody InputModel inputmodel) {
        return convert(inputmodel);
    }

}
