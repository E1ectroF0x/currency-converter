package org.example.currencyConverter.controller;


import org.example.currencyConverter.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/update")

public class UpdateController {
    @Autowired
    private UpdateService updateService;

    @GetMapping("/all")
    public void updateAll(){
        updateService.updateAll();
    }
}
