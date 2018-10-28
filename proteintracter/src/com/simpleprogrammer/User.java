package com.simpleprogrammer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class User {

	private int id;
	private String name;

	private ProteinData proteinData;

	private Collection<UserHistory> history = new ArrayList<UserHistory>();

	private Set<GoalAlert> goalAlerts = new HashSet<GoalAlert>();

	public User() {
		setProteinData(new ProteinData());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProteinData getProteinData() {
		return proteinData;
	}

	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
		proteinData.setUser(this);
	}

	public Collection<UserHistory> getHistory() {
		return history;
	}

	public void setHistory(Collection<UserHistory> history) {
		this.history = history;
	}

	public void addHistory(UserHistory historyItem) {
		historyItem.setUser(this);
		history.add(historyItem);
	}

	public Set<GoalAlert> getGoalAlerts() {
		return goalAlerts;
	}

	public void setGoalAlerts(Set<GoalAlert> goalAlerts) {
		this.goalAlerts = goalAlerts;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", total=" + proteinData.getTotal() + ", goal="
				+ proteinData.getGoal() + "]";
	}

}
