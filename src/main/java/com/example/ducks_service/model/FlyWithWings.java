package com.example.ducks_service.model;

public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly(){
        System.out.println("I'm flying with wings!");
    }
}
