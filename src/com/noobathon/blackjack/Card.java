package com.noobathon.blackjack;

public class Card 
{
	private int faceValue;
	
	public Card(int value)
	{
		this.faceValue = value;
	}
	
	public int getCardValue(boolean acesLow)
	{
		if (acesLow && faceValue == 1)
			return 1;
		else if (!acesLow && faceValue == 1)
			return 11;
			
		if (faceValue < 10)
			return faceValue;
		else
			return 10;
	}
	
	public String toString()
	{
		if (faceValue == 1)
			return "A";
		else if (faceValue > 1 && faceValue < 11)
			return "" + faceValue; // concatonating an empty string to something calls toString()
		else if (faceValue == 11)
			return "J";
		else if (faceValue == 12)
			return "Q";
		else if (faceValue == 13)
			return "K";
		else
			return "NaC"; //Not a Card
	}
}
