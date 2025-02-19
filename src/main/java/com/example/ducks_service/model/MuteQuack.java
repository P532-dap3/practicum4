package com.example.ducks_service.model;

public class MuteQuack implements QuackBehavior{
    public void quack(){
        System.out.println("I can't quack!");
    }
}
