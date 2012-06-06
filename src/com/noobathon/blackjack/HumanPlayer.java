package com.noobathon.blackjack;

// We're going to use poly-morphism here so that we don't have to write as mant functions. 
// Some of the basic behavior will be inherited and save us time and help us maintain
// the code base better. It's similar in effect to the "final CONSTANT" we used earlier.

public class HumanPlayer extends Player {

	private int chips;
	private int chipsInPlay;
	
	public HumanPlayer(String string, int chips) 
	{
    // We don't need to do all the work that we did in the Player.java to initialze the "core" 
    // members of a player class like "hand".

		super(string);
		this.chips = chips;
		this.chipsInPlay = 0;
	}

	public int getChipCount() 
	{
		return chips;
	}
  
  // There are many ways to write the following three methods, but this one here 
  // helps us keep people from having negative chip balances.

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
