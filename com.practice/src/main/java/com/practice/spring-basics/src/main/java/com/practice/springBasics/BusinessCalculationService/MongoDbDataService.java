package com.practice.springBasics.BusinessCalculationService;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MongoDbDataService implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[]{10,9,13,14,56,17,18,19,20};
    }
}
