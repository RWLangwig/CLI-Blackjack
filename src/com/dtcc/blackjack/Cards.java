package com.dtcc.blackjack;

//This code will create a CLI Blackjack simulator by CJ and RWL

import java.util.*;

public class Cards {
	
	public static void main(String[] args) {
		
		
		int[] deck = new int [52];
		int iPlayerCard1=-1; int iPlayerCard2=-1;
		int iDealerCard1=-1; int iDealerCard2=-1;
		
		String[] suits = { "Diamonds ", "Hearts ", "Clubs ", "Spades " };
		String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", 
				"10", "Jack", "Queen", "King" };
		
		// Create card deck
		for (int i = 0; i < deck.length; i++) 
			deck[i] = i;
		
		
		System.out.println("Deck: "+Arrays.toString(deck)); //print deck array
		
		//Bullet 2: Random Cards for player and dealer
		for(int i=0;i<deck.length;i++) //shuffle the cards.
		{
			int index=(int)(Math.random()*deck.length);
			int temp=deck[i];
			deck[i]=deck[index];
			deck[index]=temp;
		}
		
		System.out.println("shuffled deck: "+Arrays.toString(deck));
		
		iPlayerCard1=deck[0]; //player 2 cards from shuffled deck.
		iPlayerCard2=deck[1];
		
		iDealerCard1=deck[2]; //Dealers 2 cards from shuffled deck.
		iDealerCard2=deck[3];
		
		//System.out.println("The player card numbers "+iPlayerCard1+", "+iPlayerCard2);
		//System.out.println("The dealer first card "+iDealerCard1);
		
		//  draft code to display card for bullet 3
//		for (int i = 0; i <= 51; i++) {
//			String suit = suits[deck[i] / 13];
//			String rank = ranks[deck[i] % 13];
//		
//		System.out.println("Card number " + deck[i] + ": " + rank + " of " + suit);
	}
}

