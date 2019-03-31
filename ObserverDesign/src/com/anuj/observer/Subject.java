package com.anuj.observer;

public interface Subject {
	public void registerObserver(Observer obs);
	public void unRegisterObserver(Observer obs);
	public void notifyObservers();
	
}
