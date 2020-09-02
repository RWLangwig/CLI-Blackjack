package com.dtcc.blackjack.part2;

import java.util.Scanner;

public class BlackJackMain {

	public static void main(String[] args) {
		boolean yesOrNO=false;
		
		do
		{
			Card[] allCards=new Card[52];
			Card[] playerCards=new Card[10];
			Card[] dealerCards=new Card[10];
			
			int playerIndex=2;
			int dealerIndex=2;
			int deckIndex=4;
			
			String strMove=null;
			String strPlayAgain=null;
			Result strResult;
			
			
			//boolean isWinner=false;
			boolean strResult2 = false;
			boolean hitFlag=false;
			boolean dealerLoop=false;
		
			Card card=new Card();
			Deck deck=new Deck();
			BlackJack blackjack=new BlackJack();
			Scanner input=new Scanner(System.in);
		
			System.out.println();
	
			allCards=deck.getAllCards();
		
			System.out.println("*************** WELCOME TO BLACKJACK **************");
			System.out.print("Dealer hand: " +card.getRankString(allCards[0].rank)+" of "+allCards[0].suit);
			System.out.println("\tYour hand: "+card.getRankString(allCards[2].rank)+" of "
							+allCards[2].suit+ ", "+card.getRankString(allCards[3].rank)+" of "+allCards[3].suit);
		
			//add player, dealer cards to their own Card array.
			dealerCards[0]=allCards[0];dealerCards[1]=allCards[1];
			playerCards[0]=allCards[2];playerCards[1]=allCards[3];
		
			if(blackjack.isBlackJack(playerCards)) 
			{
				System.out.println("HOORAY..YOU HAVE WON THE BLACKJACK");
				System.out.println("You want to play again (y/n): ");
				
				strPlayAgain=input.next().trim().toUpperCase();
				yesOrNO=playAgain();
				
			}
			else 
			{
				System.out.println("Your MOVE:");
				strMove=input.next().trim().toUpperCase();
				
				strResult2=blackjack.invalidMoveException(strMove); 
				while(strResult2==false)
				{
					System.out.println("Your MOVE:");
					strMove=input.next().trim().toUpperCase();
					
					}				
				}
				
				//HIT CODE
				if(strMove.equalsIgnoreCase(Move.HIT.toString()))
				
				{
					hitFlag=true;
					while(hitFlag)
					{
						playerCards[playerIndex++]=allCards[deckIndex++];
						System.out.print(("Dealer hand: " +card.getRankString(allCards[0].rank)+" of "+allCards[0].suit));
						System.out.print("\tYour Hand: ");
						blackjack.displayCards(playerCards);	
						strResult=blackjack.comparePlayerCardsValues(playerCards);
						if(strResult.equals(Result.WIN)) 	//player win
						{
							hitFlag=false;
							System.out.println();
							System.out.println("Dealer Busts! You win! Play again (y/n): ");
							yesOrNO=playAgain();
							
						}
						else if(strResult.equals(Result.BUST))
						{
							hitFlag=false;
							System.out.println();
							System.out.println("BUST! Dealer Wins! Play again (y/n): ");
							
							yesOrNO=playAgain();
						}
						else if(strResult.equals(Result.NEXTMOVE))
						{
							System.out.println();
							System.out.println("Your MOVE:");
							strMove=input.next().trim().toUpperCase();
							
							strResult2=blackjack.invalidMoveException(strMove); 
							while(strResult2==false)
							{
								System.out.println("Your MOVE:");
								strMove=input.next().trim().toUpperCase();
								if(strMove.equals(Move.HIT.toString())) {hitFlag=true;}
								else if(strMove.equals(Move.STAND.toString())){hitFlag=false;}
								else if(strMove.equals(Move.DOUBLE.toString())) {hitFlag=false;}
								else if (strMove.equals(Move.SPLIT.toString())) {hitFlag=false;}
											
							}																			
					   }
				}
	
				//STAND CODE
				if(strMove.equalsIgnoreCase(Move.STAND.toString())) 
				{
					dealerLoop=true;
					
					System.out.print("Dealer Hand: ");
					blackjack.displayCards(dealerCards);	
				
					System.out.print("\tYour Hand: ");
					blackjack.displayCards(playerCards);	
					
					while(dealerLoop==true)
					{
						strResult=blackjack.compareDealerCardsValues(dealerCards, playerCards);
						if(strResult.equals(Result.WIN)) 	//player win
						{
							dealerLoop=false;
							System.out.println();
							System.out.println("BUST! Dealer Wins! Play again (y/n): ");
							yesOrNO=playAgain();
							
						}
						else if(strResult.equals(Result.BUST)) 	//player win
						{
							dealerLoop=false;
							System.out.println();
							System.out.println("Dealer Busts! You win! Play again (y/n): ");
							yesOrNO=playAgain();
							
						}
						else if(strResult.equals(Result.NEXTMOVE))
						{
							System.out.println();
							dealerCards[dealerIndex++]=allCards[deckIndex++];
							System.out.print("Dealer Hand: ");
							blackjack.displayCards(dealerCards);
							
							System.out.print("\tYour Hand: ");
							blackjack.displayCards(playerCards);
							dealerLoop=true;
						}
						else if(strResult.equals(Result.TIE))
						{
							dealerLoop=false;
							System.out.println("Player and Dealer got same points!!! Play again(y/n): ");
							yesOrNO=playAgain();
						
						}
						else
						{
							System.out.println("Technical issue. >>> Pay again(y/n): ");
							yesOrNO=playAgain();
						}
					}
				}
				
			
				//DOUBLE CODE //Robert.
			if(strMove.equalsIgnoreCase(Move.DOUBLE.toString()))
			{
					System.out.println(" in double");
			}
				
				//SPLIT CODE
			if(strMove.equalsIgnoreCase(Move.SPLIT.toString()))
			{
				System.out.println("in split");
				}
			}
		
		
		}while(yesOrNO==true);
}

	
	
	public static boolean playAgain() 	//play again y or n.
	{	
		Scanner input1=new Scanner(System.in);
		boolean yesOrNo=false;
		boolean properInput=true;
		String strPlayAgain;
		strPlayAgain=input1.next().toLowerCase().trim();
		while(properInput)
		{
			if(strPlayAgain.equalsIgnoreCase("y") || strPlayAgain.equalsIgnoreCase("yes") ) {properInput=false;yesOrNo=true;}
			else if(strPlayAgain.equalsIgnoreCase("n") || strPlayAgain.equalsIgnoreCase("no")) {properInput=false; yesOrNo=false;}
			//else { System.out.println("Invalid input. Please run the program again.");yesOrNo=false;}	
		
			else 
			{
				System.out.println("Please enter 'y' or 'n'. Play again? (y/n)");
				strPlayAgain=input1.next().toLowerCase().trim();
				properInput=true;
				
			}	
		}
		return yesOrNo;
	}
}

