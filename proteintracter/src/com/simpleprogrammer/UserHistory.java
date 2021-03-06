package com.simpleprogrammer;

import java.util.Date;

public class UserHistory {

	private int id;
	private User user;
	private User2 user2;
	private Date entryTime;
	private String entry;
	
	public UserHistory() {}
	
	public UserHistory(Date entryTime, String entry) {
		super();
		this.entryTime = entryTime;
		this.entry = entry;
	}
	
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	public String getEntry() {
		return entry;
	}
	public void setEntry(String entry) {
		this.entry = entry;
	}

	@Override
	public String toString() {
		return "UserHistory [entryTime=" + entryTime + ", entry=" + entry + "]";
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public User2 getUser2() {
		return user2;
	}

	public void setUser2(User2 user2) {
		this.user2 = user2;
	}
}
