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
		if (bet > chips)
		{
			chipsInPlay += chips;
			chips = 0;
		}
		else 
		{
			chips -= bet;
			chipsInPlay += bet;
		}
	}

	public void loseBet() 
	{
		chipsInPlay = 0;
	}

	public void winBet() 
	{
		chips += 2 * chipsInPlay;
	}

}
