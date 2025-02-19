package com.example.ducks_service.model;

public class RubberDuck extends Duck{

    public RubberDuck(int id) {
        super(id, Type.RUBBER_DUCK);
    }

    public void display(){
        System.out.println("It looks like a rubberduck");
    }

    public void setFlyBehavior(){
        this.flyBehavior = new FlyNoWay();
    }

    public void setQuackBehavior(){
        this.quackBehavior = new Squeak();
    }
}
