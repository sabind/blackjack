package com.noobathon.blackjack;

public class Player {
	
	private String name;
	private Hand hand;
	
	public Player(String name)
	{
		this.name = name;
		this.hand = new Hand();
	}

	public int getHandValue() {
		return hand.getTotalHandValue();
	}

	public void newHand() {
		hand.clear();
	}

	public void dealCard(Card card) 
	{
		hand.addCard(card);
	}

	public String getName() {
		return name;
	}

	public String toStringShowingTopCardOnly() {
		return name + ": Current Hand: " + hand.toStringShowingTopCardOnly(); 
	}
	
	public String toString()
	{
		return name + ": Current Hand: " + hand; 
	}
}
