package com.ron.inetpsa.pattern;

import java.util.ArrayList;
import java.util.List;

class Subject{
    private int price=2000;
    private List<Observer> observerList = new ArrayList<>();

    public void setPrice(int price) {
        this.price = price;
        notifyAllObserver();
    }

    private void notifyAllObserver() {
        for(Observer o : observerList){
            /* Send Update to each Observer*/
            o.update(price);
        }
    }

    public void add(Observer observer){
    observerList.add(observer);
    }

}
class Observer{
    private int price;
    public void update(int price) {
      this.price=price;
      displayLatest();
    }

    private void displayLatest() {
        System.out.println("The Latest Price :"+this.price);
    }

}

public class ObserverDesignPattern {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer ob1 = new Observer();
        Observer obj2 = new Observer();
        subject.add(ob1);
        subject.add(obj2);
        subject.setPrice(3000);
        subject.setPrice(5000);

    }
}
