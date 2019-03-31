package com.anuj.delayeQueue;

//Java Program Demonstrate DelayQueue 

import java.util.concurrent.*;
import java.util.*;

//Driver Class 
public class DelayQueTest {
	public static void main(String[] args) throws InterruptedException {

		// create object of DelayQueue
		// using DelayQueue() constructor
		BlockingQueue<DelayObject> DQ = new DelayQueue<DelayObject>();

		// Add numbers to end of DelayQueue
		DQ.add(new DelayObject("A", 1));
		DQ.add(new DelayObject("B", 2));
		DQ.add(new DelayObject("C", 3));
		DQ.add(new DelayObject("D", 4));

		// print Dequee
		System.out.println("DelayQueue: " + DQ);

		// create object of DelayQueue
		// using DelayQueue(Collection c) constructor
		BlockingQueue<DelayObject> DQ2 = new DelayQueue<DelayObject>(DQ);

		// print Dequee
		System.out.println("DelayQueue: " + DQ2);
		
        // print queue 
        System.out.println("DelayQueue: "
                           + DQ); 
  
        Thread.sleep(2000);
        // print the head using peek() method 
        System.out.println("Head of DelayQueue: "
                           + DQ.peek()); 
  
        // print the size using size() method 
        System.out.println("Size of DelayQueue: "
                           + DQ.size()); 
  
        // remove the head using poll() method 
        System.out.println("Head of DelayQueue: "
                           + DQ.poll()); 
        Thread.sleep(2000);
        // print the size using size() method 
        System.out.println("Size of DelayQueue: "
                           + DQ.size()); 
  
        // clear the DelayQueue using clear() method 
        DQ.clear(); 
        System.out.println("Size of DelayQueue"
                           + " after clear: "
                           + DQ.size()); 
	}
}
