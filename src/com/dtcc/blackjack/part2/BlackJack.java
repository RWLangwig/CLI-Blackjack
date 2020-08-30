package com.dtcc.blackjack.part2;

import java.util.Objects;
import java.util.Scanner;

public class BlackJack {

	public BlackJack() {}
	
	public boolean isBlackJack(Card[] cards)
	{
		boolean isBlackJack=false;
		if(getTotalCardsValue(cards)==21) { isBlackJack=true;}
		else {isBlackJack=false;}
		return isBlackJack;	
	}
	
	public int getTotalCardsValue(Card[] cards)
	{
		int total=0;
		for(Card c:cards)
		{
			if(Objects.isNull(c)){}	//to check if card object is null/empty or not.
			else 
			{ 
				if((getRankIntValue(c.rank.toString())==11))
				{
					if(total>10) { total+=1;}
					else{total+=getRankIntValue(c.rank.toString());}	 
				}
				else{total+=getRankIntValue(c.rank.toString());}
			}
		}
		return total;
	}
	
	public int getRankIntValue(String rank)
	{
		switch(rank)
		{
		 case "TWO":   	return 2; 
         case "THREE":  	return 3; 
         case "FOUE":   	return 4; 
         case "FIVE":   	return 5;
         case "SIX":   	return 6;
         case "SEVEN":   	return 7;
         case "EIGHT":   	return 8;
         case "NINE":   	return 9;
         case "TEN":  	return 10;
         case "JACK":		return 10;
         case "QUEEN": 	return 10;
         case "KING" :	return 10;
         case "ACE"  :	return 11;
         default : return 0;
		
		}
	}
	
	public boolean playAgain(String strPlayAgain)
	{
		return false;
	}
	
	//getRankString
	public void displayCards(Card[] cardArray)
	{
		Card cardObj=new Card();
		for(Card c: cardArray)
		{
			if(Objects.isNull(c)){}
			else {System.out.print(cardObj.getRankString(c.rank)+" of "+c.suit+", ");}
		}
	}
	
	public Result comparePlayerCardsValues(Card[] cardArray)
	{
		BlackJack bj=new BlackJack();
		Result strResult=null;
		int cardsTotal=0;
		
		cardsTotal=bj.getTotalCardsValue(cardArray);
		
		if(cardsTotal==21)
		{
			strResult=Result.WIN;
		}
		else if(cardsTotal>21)
		{
			strResult=Result.BUST;
		}
		else if(cardsTotal>=0 && cardsTotal<=20)
		{
			strResult=Result.NEXTMOVE;
		}
		return strResult;
	}
	
	public Result compareDealerCardsValues(Card[] cardDealerArray, Card[] cardPlayerArray)
	{
		BlackJack bj=new BlackJack();
		Result strResult=null;
		int cardsDealerTotal=0;
		int cardsPlayerTotal=0;
		
		cardsDealerTotal=bj.getTotalCardsValue(cardDealerArray);
		cardsPlayerTotal=bj.getTotalCardsValue(cardPlayerArray);
		
		if(cardsDealerTotal==21 )
		{
			strResult=Result.WIN;
		}
		else if(cardsDealerTotal>21 || cardsPlayerTotal==21)
		{
			strResult=Result.BUST;
		}
		else if(cardsDealerTotal>=0 && cardsDealerTotal<=17)
		{
			strResult=Result.NEXTMOVE;
		}
		else if(cardsDealerTotal>=17 && cardsDealerTotal<21)
		{
			if(cardsPlayerTotal<cardsDealerTotal && cardsPlayerTotal<=21) {strResult=Result.WIN;} 
			else if(cardsPlayerTotal>cardsDealerTotal && cardsPlayerTotal<=21) {strResult=Result.BUST;}
		}
		else if(cardsDealerTotal==cardsPlayerTotal)
		{
			strResult=Result.TIE;
		}
			
		return strResult;
	}

}

