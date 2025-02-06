package com.practice.springBasics.BusinessCalculationService;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessCalculationServiceRunner {
    private DataService dataService;

    public BusinessCalculationServiceRunner(DataService dataService) {
        super();
        this.dataService = dataService;
    }
    public int findMax(){
        int max=Arrays.stream(dataService.retrieveData()).max().orElse(0);
        return max;
    }
}