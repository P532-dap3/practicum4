package com.example.ducks_service.model;

public class DecoyDuck extends Duck{

    public DecoyDuck(int id) {
        super(id, Type.DECOY_DUCK);
    }

    public void display(){
        System.out.println("It looks like a decoy duck");
    }

    public void setFlyBehavior(){
        this.flyBehavior = new FlyNoWay();
    }

    public void setQuackBehavior(){
        this.quackBehavior = new MuteQuack();
    }
}
