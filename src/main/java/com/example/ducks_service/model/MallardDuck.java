package com.example.ducks_service.model;

public class MallardDuck extends Duck{

    public MallardDuck(int id) {
        super(id, Type.MALLARD);
    }

    public void display(){
        System.out.println("It looks like a mallard");
    }

    public void setFlyBehavior(){
        this.flyBehavior = new FlyWithWings();
    }

    public void setQuackBehavior(){
        this.quackBehavior = new Quack();
    }
}
