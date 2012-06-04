package com.noobathon.blackjack;


public class HumanPlayer extends Player {

	private int chips;
	private int chipsInPlay;
	
	public HumanPlayer(String string, int chips) 
	{
		super(string);
		this.chips = chips;
		this.chipsInPlay = 0;
	}

	public int getChipCount() 
	{
		return chips;
	}

	public void betChips(int bet) 
	{
		chipsInPlay += bet;
	}

	public void loseBet() 
	{
		chips -= chipsInPlay;
	}

	public void winBet() 
	{
		chips += chipsInPlay;
	}

}
