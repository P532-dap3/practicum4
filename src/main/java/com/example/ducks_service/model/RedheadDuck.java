package com.example.ducks_service.model;

public class RedheadDuck extends Duck{

    public RedheadDuck(int id) {
        super(id, Type.REDHEAD);
    }

    public void display(){
        System.out.println("It looks like a redhead");
    }

    public void setFlyBehavior(){
        this.flyBehavior = new FlyWithWings();
    }

    public void setQuackBehavior(){
        this.quackBehavior = new Quack();
    }
}
