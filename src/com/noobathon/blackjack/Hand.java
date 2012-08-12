package com.noobathon.blackjack;

import java.util.ArrayList;


public class Hand 
{
  // NOTE: We want to use an ArrayList<Card> here because it lets us not worry about
  // managing the set of cards. We only have to add and remove them using the 
  // collection's methods.
  //
  // Also note the use of generics. This will help us when we remove cards from the hand. 
  // Without generics we'd have to cast them to Card objects.
 
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
			if (card.isAce())
				hasAces = true;
			sum += card.getCardValue(acesLow);
		}
		
    //We don't have to keep track of all the aces. Two aces evaluated at 11 makes the count 22 so 
    //we only actually need to evaluate the hand as aces low every time and if he did bumb across 
    //an ace see if adding 20 helps the player. If it pushes them over 21 then leave all aces as 1.

		if (hasAces && (sum + 10) <= 21)
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
			String revealFirst = hand.get(0).getCardString() + " ";
			
      //This is a new way of moving across collections in Java.
      //It's similar to new languages.

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
			String revealFirst = hand.get(0).getCardString()+ " ";
			
			for (Card card : hand.subList(1, hand.size()))
			{
				revealFirst += card.getCardString() + " ";
			}
			
			return revealFirst.trim();
		}
	}

	public int getNumberOfCards() 
	{
		return hand.size();
	}

	public boolean isHandEmpty()
	{
		return hand.isEmpty();
	}
}
