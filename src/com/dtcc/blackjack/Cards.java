package com.dtcc.blackjack;

//This code will create a CLI Blackjack simulator by CJ and RWL

import java.util.*;

public class Cards {
	
	public static void main(String[] args) {
		
		int[] deck = new int [52];
		int iPlayerCard1=-1; int iPlayerCard2=-1;
		int iDealerCard1=-1; int iDealerCard2=-1;
		
		String[] suits = { "D", "H", "C", "S" };	//suits and ranks.
		String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", 
				"10", "Jack", "Queen", "King" };
		String[] arrayMoves = { "HIT", "STAND"};	//array for move HIT,STAND
		String[] arrayResult= {"WIN","BUST","NEXTMOVE"};	//array for Result
	
		// Create card deck
		for (int i = 0; i < deck.length; i++) 
			deck[i] = i;
		
	//	System.out.println("Deck: "+Arrays.toString(deck)); //print deck array
		
		//Bullet 2: Random Cards for player and dealer
		for(int i=0;i<deck.length;i++) //shuffle the cards.
		{
			int index=(int)(Math.random()*deck.length);
			int temp=deck[i];
			deck[i]=deck[index];
			deck[index]=temp;
		}
		
//		System.out.println("shuffled deck: "+Arrays.toString(deck));
		
		iDealerCard1=deck[0]; //Dealers 2 cards from shuffled deck.
		iDealerCard2=deck[1];
		
		iPlayerCard1=deck[2]; //player 2 cards from shuffled deck.
		iPlayerCard2=deck[3];

		System.out.println("Dealer hand: " + " "+ displayCardName(iDealerCard1));
		System.out.println("Your hand: " + " "+ displayCardName(iPlayerCard1) + ", " + displayCardName(iPlayerCard2));
		
		// code to display card for bullet 3 and 4
		//loop will run from 0-3 for first 4 cards from shuffled deck.
		
	for (int i = 0; i<4; i++) 
		{
		String suit = suits[deck[i] / 13];
			String rank = ranks[deck[i] % 13];	
			
//	System.out.println("Card number " + deck[i] + ": " + rank + " of " + suit);
		}
		
	}

	public static String displayCardName(int cardNumber)  //to get Card name display
	{
		String card=null;
		String suit;
		String rank;
		String[] suits = { "D", "H", "C", "S" };	//suits and ranks.
		String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", 
				"10", "Jack", "Queen", "King" };
		
		for(int i=0;i<52;i++)
		{
			if(i==cardNumber)
			{
				suit=suits[cardNumber/13];
				rank=ranks[cardNumber%13];
				card=rank+" of "+suit;
			}
		}
		return card;
	}
	
	public static int getCardValue(String cardname)	//to get card value.
	{
		return 0;
	}
	
	public static boolean doYouWantToPlayAgain() 	//play again y or n.
	{	
		
		
		return false;
	}
	
	public static String checkPlayerValue()	//total player cards value.
	{
		String result=null;
		
		
		
		return result;
	}
	
	public static String checkDealerValue()	//total dealer cards value.
	{
		String result=null;
		
		
		return result;
	}
}

