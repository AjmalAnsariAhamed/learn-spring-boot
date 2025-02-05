package com.practice.springBasics;

public class Earth {
    private Person person;

    public Earth(Person person) {
        this.person = person;
    }
    public void name(){
        System.out.println(person.getName());
    }
}
