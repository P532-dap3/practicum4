package com.example.ducks_service.model;

public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly(){
        System.out.println("I can't fly!");
    }
}
