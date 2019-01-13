package com.accolite;

import java.util.Arrays;
import java.util.Comparator;

class Checker implements Comparator<Player>{
	@Override
	public int compare(Player o1, Player o2) {
		// TODO Auto-generated method stub
		if(o1.score == o2.score){
			return o1.name.compareTo(o2.name);
		}
		return o1.score - o2.score;
	}
}


class Player {

	public int score;
	public String name;
	
	public Player(int score, String name) {
		super();
		this.score = score;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Player [score=" + score + ", name=" + name + "]";
	}
	
}
public class ComparatorPlayers {

	public static void main(String[] args) {
		Player[] players = new Player[5];
		players[0] = new Player(100, "Anuj");
		players[1] = new Player(20, "Ratan");
		players[2] = new Player(50, "Alok");
		players[3] = new Player(80, "Anup");
		players[4] = new Player(80, "Raj");
		Arrays.sort(players, new Checker());
		for(Player pl : players){
			System.out.println(pl);
		}
	}

}
