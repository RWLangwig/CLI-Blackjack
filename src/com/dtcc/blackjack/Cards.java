package com.dtcc.blackjack;

//This code will create a CLI Blackjack simulator by CJ and RWL

import java.util.*;

public class Cards {
	
	public static void main(String[] args) {
		boolean yesOrNo=false;
		
		do 
		{
			int[] deck = new int [52];
			int[] arrayPlayer= {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}; //to store players cards
			int[] arrayDealer= {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};	//to store dealers cards
			
			int iPlayerCard=-1, iPlayerCard1=-1, iPlayerCard2=-1;
			int iDealerCard=-1, iDealerCard1=-1, iDealerCard2=-1;
			int iplayerIndex=2;	//starting index for arrayPlayer after dealing first 2 cards
			int idealerIndex=2;	//starting index for arrayDealer after dealing first 2 cards
			int nextIndex=4;	//starting index of deck after first four cards.
			
			String[] arrayMoves = { "HIT", "STAND"};	//array for move HIT,STAND
			String[] arrayResult= {"WIN","BUST","NEXTMOVE","TIE"};	//array for Result
			String strPlayerMove=null;
		//	String strDealerMove=null;
			String strResult=null;
			String strDealerCard=null;
			String strPlayerCard=null;
					
			boolean hitFlag=false;
			boolean standFlag=false;
			boolean dealerLoop=false;
			
			Scanner input=new Scanner(System.in);
			
			for (int i = 0; i < deck.length; i++) // Create card deck
				deck[i] = i;
			
			//Bullet 2: Random Cards for player and dealer
			for(int i=0;i<deck.length;i++) //shuffle the cards.
			{
				int index=(int)(Math.random()*deck.length);
				int temp=deck[i];
				deck[i]=deck[index];
				deck[index]=temp;
			}
				
			iDealerCard1=deck[0]; iDealerCard2=deck[1];//Dealers 2 cards from shuffled deck.
			iPlayerCard1=deck[2];iPlayerCard2=deck[3]; //Player 2 cards from shuffled deck.
			
			arrayDealer[0]=iDealerCard1;		//FIRST TWO VALUES IN arrayDealer (dealer's 2 cards)
			arrayDealer[1]=iDealerCard2;
			
			arrayPlayer[0]=iPlayerCard1;		//FIRST TWO VALUES IN arrayPlayer (Player's 2 cards)
			arrayPlayer[1]=iPlayerCard2;
			
			System.out.println("****** BlackJack ******");
			System.out.print("Dealer hand: " + " "+ displayCardName(iDealerCard1)+"  ");
			System.out.println("Your hand: " + " "+ displayCardName(iPlayerCard1) + ", " + displayCardName(iPlayerCard2));
////	//		System.out.print("Dealer hand: " + " "+ displayCardName(arrayDealer)+"  ");
			
		//Bullet 5. HIT and STAND Part.
			System.out.println("Please enter HIT or STAND ");
			System.out.println("Your Move: ");
			strPlayerMove=input.nextLine().toUpperCase().trim();
			boolean bProperInput=checkProperInput(strPlayerMove);
			
			while(bProperInput!=true) //check proper input
			{
				
		//		System.out.println("Your Move: "); 
		//		strPlayerMove=input.nextLine().toUpperCase().trim();
		//		bProperInput=checkProperInput(strPlayerMove);
			}
			
			//**************CODE FOR HIT ********************
			if(strPlayerMove.equals(arrayMoves[0])) 
			{
				hitFlag=true;
				while(hitFlag==true)
				{
					iPlayerCard=deck[nextIndex++];
					arrayPlayer[iplayerIndex++]=iPlayerCard;		//add players card to the player array.
					strPlayerCard=displayCardName(iPlayerCard);		//display player card name
					
					System.out.print("Dealer Hand: "+displayCardName(iDealerCard1)+". Your Hand: ");
					for(int i=0;i<arrayPlayer.length;i++)
						if(arrayPlayer[i]!=-1)
							System.out.print((displayCardName(arrayPlayer[i])+", "));
					
					strResult= compareDealerPlayerValues(arrayPlayer,arrayDealer);	//comparing the total of player cards and dealer cards.
					if(strResult.equals(arrayResult[0])) 	//player win, dealer bust
					{
						System.out.println();
						hitFlag=false;
						System.out.println("Dealer Bust! You win! Play again (y/n): ");
						yesOrNo=playAgain();
					}
					else if(strResult.equals(arrayResult[1])) 	//player bust , dealer win
					{
						System.out.println();
						hitFlag=false;
						System.out.println("BUST! Dealer Wins! Play again (y/n): ");
						yesOrNo=playAgain();
					}
					else if(strResult.equals(arrayResult[2])) 
					{
						System.out.println();
						System.out.println("Your Move: ");
						strPlayerMove=input.nextLine().toUpperCase().trim();
						bProperInput=checkProperInput(strPlayerMove);	//check valid input
						while(bProperInput!=true) //check proper input
						{
							System.out.println("Please enter proper input: HIT or STAND");System.out.println("Your Move: "); 
							strPlayerMove=input.nextLine().toUpperCase().trim();
							bProperInput=checkProperInput(strPlayerMove);
						}
						if(strPlayerMove.equals(arrayMoves[0])) {hitFlag=true;}else{hitFlag=false;}
					
				}				
					else if(strResult.equals(arrayResult[3]))
					{
						hitFlag=false;
						System.out.println("TIE : Player and Dealer got same points!!! Play again(y/n): ");
						yesOrNo=playAgain();
					}
					else {System.out.println("Something went wrong >>> Please run the game again.");}
				}
			}
					
			//***************CODE FOR STAND******************
			//Put dealers cards value in arrayDealer and use standFlag
			
			if(strPlayerMove.equals(arrayMoves[1]))
			{
				dealerLoop=true;
		//		System.out.println("Player stands. ");
				
				iDealerCard=deck[nextIndex++];
				arrayDealer[idealerIndex++]=iDealerCard;		
				//add dealers card to the dealer array.
				
				
				System.out.print("Dealer Hand: ");
				for(int i=0;i<arrayDealer.length;i++)
					if(arrayDealer[i]!=-1)
						System.out.print((displayCardName(arrayDealer[i])+", "));
				
				System.out.print("Player's hand ");
				for(int i=0;i<arrayPlayer.length;i++)
					if(arrayPlayer[i]!=-1)
						System.out.print((displayCardName(arrayPlayer[i])+", "));
					
					strDealerCard=displayCardName(iDealerCard2);		//display dealer card name
					
					strResult= compareDealerPlayerValues(arrayPlayer,arrayDealer);	//comparing the total of player cards and dealer cards.
					if(strResult.equals(arrayResult[0])) 	//player win, dealer bust
					{
						System.out.println();
						dealerLoop=false;
						System.out.println("Dealer Bust! You win! Play again (y/n): ");
						yesOrNo=playAgain();
					}	
					else if (strResult.equals(arrayResult[1])){
						System.out.println();
						dealerLoop=false;
						System.out.println("Dealer Win! Player lose! Play again (y/n): ");
						yesOrNo=playAgain();
							
					}
					else if (strResult.equals(arrayResult[2])){
						iDealerCard=deck[nextIndex++];
						arrayDealer[idealerIndex++]=iDealerCard;		//add dealers card to the player array.					
						strResult= compareDealerPlayerValues(arrayPlayer,arrayDealer);
						
					}
								
				}
	//				else {System.out.println("Something went wrong >>> Please run the game again.");}
				}
			
		
		while(yesOrNo==true); //for y or n
	}
		//end while loop
	
	
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
	
	public static boolean checkProperInput(String strPlayerMove) 
	{
		boolean value=false;
		if(strPlayerMove.equalsIgnoreCase("HIT") || strPlayerMove.equalsIgnoreCase("STAND") || 
				strPlayerMove.equalsIgnoreCase("h") ||(strPlayerMove.equalsIgnoreCase("s")) ){value=true;}
		else {value=false;}
		return value;
	}
	
	public static int getCardsTotalValueFromArray(int[] arrayPlayerDealer)
	{
		int total=0;
		for(int i=0;i<arrayPlayerDealer.length;i++)
		{
			if(arrayPlayerDealer[i]!=-1) 
			{
				String display=displayCardName(arrayPlayerDealer[i]);
				if(getCardValue(display)==11) {if(total>10) {total+=1;}else {total+=getCardValue(display);}} //checking ace value.
				else{total+=getCardValue(display);}
			}
		}
		return total;
	}
	
	public static int getCardValue(String cardname)	//to get card value.
	{
		int value=0;
		if(cardname.contains("Ace")) {value=11;}
		else if(cardname.contains("Jack") || cardname.contains("Queen")|| cardname.contains("King")) {value=10;}
		else if (cardname.contains("2")) {value=2;}
		else if (cardname.contains("3")) {value=3;}
		else if (cardname.contains("4")) {value=4;}
		else if (cardname.contains("5")) {value=5;}
		else if (cardname.contains("6")) {value=6;}
		else if (cardname.contains("7")) {value=7;}
		else if (cardname.contains("8")) {value=8;}
		else if (cardname.contains("9")) {value=9;}
		else if (cardname.contains("10")) {value=10;}
		return value;
	}
	
	public static boolean playAgain() 	//play again y or n.
	{	
		Scanner input1=new Scanner(System.in);
		boolean yesOrNo=false;
		String strPlayAgain;
		strPlayAgain=input1.next().toLowerCase().trim();
		
		if(strPlayAgain.equalsIgnoreCase("y") || strPlayAgain.equalsIgnoreCase("yes") ) {yesOrNo=true;}
		else if(strPlayAgain.equalsIgnoreCase("n") || strPlayAgain.equalsIgnoreCase("no")) { yesOrNo=false;}
		else { System.out.println("Invalid input. Please run the program again.");yesOrNo=false;}	
		return yesOrNo;
	}
	
	public static String compareDealerPlayerValues(int[] arrayPlayer,int[]arrayDealer)	//LOGIC for WIN OR BUST
	{
		int idealerTotal=0;
		int iplayerTotal=0;
		String result=null;
		
		idealerTotal=getCardsTotalValueFromArray(arrayDealer);
		iplayerTotal=getCardsTotalValueFromArray(arrayPlayer);
		
		/*if(iplayerTotal==21 || (idealerTotal < iplayerTotal && iplayerTotal<=21)) {result="WIN";}
		else if(idealerTotal==21 || iplayerTotal >=21 ) {result="BUST";}*/
		
		//here WIN means win for player , so BUST will be win for Dealer. (as using same method to compare values)
		if(iplayerTotal==21 || idealerTotal >21){result="WIN";}
		else if(idealerTotal ==21 || iplayerTotal>21) {result="BUST";}
		else if(iplayerTotal>=1 && iplayerTotal<=20) {result="NEXTMOVE";}
		else if(iplayerTotal==idealerTotal) {result="TIE";}
		return result;
	}
}

