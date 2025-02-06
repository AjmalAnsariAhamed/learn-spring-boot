package com.practice.springBasics.BusinessCalculationService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("sql")
public class MySqlDataService implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[]{1,29,31,4,56,62,7,29,30};
    }
}
