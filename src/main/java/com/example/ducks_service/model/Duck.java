package com.example.ducks_service.model;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    int id;
    Type type;

    public Duck(int id, Type type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    abstract void display();

    public void swim(){
        System.out.println("I can swim!");
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public String toString(){
        return String.valueOf(id) + ", " + type;
    }

    abstract void setFlyBehavior();

    abstract void setQuackBehavior();
}
