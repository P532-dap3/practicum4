package com.example.ducks_service.model;

public class Quack implements QuackBehavior{
    @Override
    public void quack(){
        System.out.println("Duck quacking");
    }
}
