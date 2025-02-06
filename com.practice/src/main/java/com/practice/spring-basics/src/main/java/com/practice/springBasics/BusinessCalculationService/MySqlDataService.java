package com.practice.springBasics.BusinessCalculationService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("sql")
public class MySqlDataService implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[]{1,2,3,4,5,6,7,9,10};
    }
}
