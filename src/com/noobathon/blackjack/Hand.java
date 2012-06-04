package com.noobathon.blackjack;

import java.util.ArrayList;


public class Hand 
{
	ArrayList<Card> hand;
	
	public Hand()
	{
		hand = new ArrayList<Card>();
	}

	public void addCard(Card card) 
	{
		hand.add(card);
	}

	public int getTotalHandValue() 
	{
		int sum = 0;
		boolean acesLow = true;
		boolean hasAces = false;
		
		for (Card card : hand)
		{
			if (card.toString().equals("A"))
				hasAces = true;
			sum += card.getCardValue(acesLow);
		}
		
		if (hasAces && (sum + 10) < 21)
			return sum + 10;
		else
			return sum;
	}

	public void clear() 
	{
		hand.clear();
	}

	@SuppressWarnings("unused")
	public String toStringShowingTopCardOnly() 
	{
		if (hand.size() == 0)
			return "Empty Hand";
		else
		{
			String revealFirst = hand.get(0).toString() + " ";
			
			for (Card card : hand.subList(1, hand.size()))
			{
				revealFirst += "X ";
			}
			
			return revealFirst.trim();
		}
	}
	
	public String toString()
	{
		if (hand.size() == 0)
			return "Empty Hand";
		else
		{
			String revealFirst = hand.get(0).toString() + " ";
			
			for (Card card : hand.subList(1, hand.size()))
			{
				revealFirst += card.toString() + " ";
			}
			
			return revealFirst.trim();
		}
	}

}
