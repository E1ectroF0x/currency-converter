package org.example.currencyConverter.service;


import org.example.currencyConverter.model.InputModel;
import org.example.currencyConverter.model.OutputModel;

public interface ConverterService {

    OutputModel convertValue(InputModel inputModel);

}
