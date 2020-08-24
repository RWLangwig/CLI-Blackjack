package com.dtcc.blackjack;

//This code will create a CLI Blackjack simulator by CJ and RWL

import java.util.*;

public class Cards {
	
	public static void main(String[] args) {
		
		int[] deck = new int [52];
		String[] suits = { "Diamonds ", "Hearts ", "Clubs ", "Spades " };
		String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", 
				"10", "Jack", "Queen", "King" };
		
		// Create card deck
		for (int i = 0; i < deck.length; i++) 
			deck[i] = i;
		
		//print deck array
		System.out.println("Deck: "+Arrays.toString(deck));
		//enter code for 2 random cards below bullet 2
		//
		//
		//
		//
		
		//  draft code to display card for bullet 3
//		for (int i = 0; i <= 51; i++) {
//			String suit = suits[deck[i] / 13];
//			String rank = ranks[deck[i] % 13];
//		
//		System.out.println("Card number " + deck[i] + ": " + rank + " of " + suit);
	}
}

