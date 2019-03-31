package com.anuj.misc;

import java.util.*; 

public class JobSequencing { 
	
	// Job class 
	public static class Job { 
		char id; 
		int deadline; 
		int profit; 

		// Constructor 
		Job(char id, int deadline, int profit) 
		{ 
			this.id = id; 
			this.deadline = deadline; 
			this.profit = profit; 
		}

		@Override
		public String toString() {
			return "Job [id=" + id + ", deadline=" + deadline + ", profit=" + profit + "]";
		} 
	} 

	public static class Sorted implements Comparator<Object> { 
		
		// Function to implement comparator 
		public int compare(Object o1, Object o2) 
		{ 
			Job j1 = (Job)o1; 
			Job j2 = (Job)o2; 

			if (j1.profit != j2.profit) 
				return j2.profit - j1.profit; 
			else
				return j2.deadline - j1.deadline; 
		} 
	} 
	
	// Function to print job scheduling 
	public static void printJobScheduling(Job jobs[], int n) 
	{ 
		// Creating object of Sorted class 
		Sorted sorter = new Sorted(); 
		
		Arrays.sort(jobs, sorter); 
	
		// Creating TreeSet Object 
		TreeSet<Integer> ts = new TreeSet<>(); 

		for (int i = 0; i < n; i++) 
			ts.add(i); 

		for (int i = 0; i < n; i++) { 
			Integer x = ts.floor(jobs[i].deadline - 1); 

			if (x != null) { 
				System.out.print(jobs[i].id + " "); 
				ts.remove(x); 
			} 
		} 
	} 
	
	// Driver Code 
	public static void main(String[] args) 
	{ 
		int n = 5; 
		Job[] jobs = new Job[n]; 

		jobs[0] = new Job('a', 2, 100); 
		jobs[1] = new Job('b', 1, 19); 
		jobs[2] = new Job('c', 2, 27); 
		jobs[3] = new Job('d', 1, 25); 
		jobs[4] = new Job('e', 3, 15); 

		printJobScheduling(jobs, n); 
	} 
	// Contributed by Dipesh Jain (dipesh_jain) 
} 

