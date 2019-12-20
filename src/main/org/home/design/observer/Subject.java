package org.home.design.observer;

public interface Subject {
    public void register(Observer obj);
    public void deRegister(Observer obj);
    public void notifyObservers();
    public void getUpdate(Observer obj);
}
