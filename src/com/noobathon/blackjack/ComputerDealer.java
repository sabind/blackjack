package com.noobathon.blackjack;

// Computer dealer also inherits from player so it already has a hand and everything else
// it needs to manage a hand. 

public class ComputerDealer extends Player
{

	public ComputerDealer(String name) 
	{
		super(name);
	}

	public Action takeAction() 
	{
		if (this.getHandValue() < 17)
			return Action.Hit; //In blackjack dealers must hit if they have below 17 pts.
		else
			return Action.Stay; //In blackjack dealers must stay if they have 17 pts.
    }

    public boolean needsMoreCards()
    {
        return (this.getHandValue() < 17);
    }

}
