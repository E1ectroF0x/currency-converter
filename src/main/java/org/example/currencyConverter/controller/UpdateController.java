package org.example.currencyConverter.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.currencyConverter.service.UpdateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/update")
@AllArgsConstructor
public class UpdateController {

    private final UpdateService updateService;

    @GetMapping
    public void update() {
        updateService.updateAllValues();
    }

}
