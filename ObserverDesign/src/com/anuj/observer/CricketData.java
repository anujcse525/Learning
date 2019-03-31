package com.anuj.observer;

import java.util.ArrayList;
import java.util.Observer;

public class CricketData implements Subject {

	int runs=0, wickets=0;
	float overs=0.0f;
	ArrayList<Observer> observers;

	public CricketData() {
		observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer obs) {
		
		observers.add(obs);

	}

	@Override
	public void unRegisterObserver(Observer obs) {
		observers.remove(obs);

	}

	@Override
	public void notifyObservers() {
		for(int i=0; i< observers.size(); i++){
			observers.get(i).notify();
		}
	}
	
	public int getRuns(){
		runs = runs + 5;
		return runs;
	}

	@Override
	public void registerObserver(com.anuj.observer.Observer obs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unRegisterObserver(com.anuj.observer.Observer obs) {
		// TODO Auto-generated method stub
		
	}

}
