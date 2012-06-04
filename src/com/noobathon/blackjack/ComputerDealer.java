package com.noobathon.blackjack;

public class ComputerDealer extends Player
{

	public ComputerDealer(String name) 
	{
		super(name);
	}

	public Action takeAction() 
	{
		if (this.getHandValue() < 17)
			return Action.Hit;
		else
			return Action.Stay;
	}

}
