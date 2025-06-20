//package cardGame;
//Izel Rodriguez Diaz
//6/20/2025
//Card game with ood

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CardGame {

	private static ArrayList<Card> deckOfCards = new ArrayList<Card>();
	private static ArrayList<Card> playerCards = new ArrayList<Card>();


	public static void main(String[] args) {

		Scanner input = null;
		try {
			input = new Scanner(new File("cards.txt"));
		} catch (FileNotFoundException e) {
			// error
			System.out.println("error");
			e.printStackTrace();
		}

		while(input.hasNext()) {
			String[] fields  = input.nextLine().split(",");
			//	public Card(String cardSuit, String cardName, int cardValue, String cardPicture) {
			Card newCard = new Card(fields[0], fields[1].trim(),
					Integer.parseInt(fields[2].trim()), fields[3]);
			deckOfCards.add(newCard);	
		}

		shuffle();

		//for(Card c: deckOfCards)
			//System.out.println(c);

		//deal the player 5 cards
		for(int i = 0; i < 4; i++) {
			playerCards.add(deckOfCards.remove(i));
		}
		
		System.out.println("players cards");
		for(Card c: playerCards)
			System.out.println(c);

		System.out.println("pairs is " + checkFor2Kind());

		gameMenu();

	}//end main

	public static void shuffle() {

		//shuffling the cards by deleting and reinserting
		for (int i = 0; i < deckOfCards.size(); i++) {
			int index = (int) (Math.random()*deckOfCards.size());
			Card c = deckOfCards.remove(index);
			//System.out.println("c is " + c + ", index is " + index);
			deckOfCards.add(c);
		}
	}

	//check for 2 of a kind in the players hand
	public static boolean checkFor2Kind() {

		int count = 0;
		for(int i = 0; i < playerCards.size() - 1; i++) {
			Card current = playerCards.get(i);
			Card next = playerCards.get(i+1);
			
			for(int j = i+1; j < playerCards.size(); j++) {
				next = playerCards.get(j);
				//System.out.println(" comparing " + current);
				//System.out.println(" to " + next);
				if(current.equals(next))
					count++;
			}//end of inner for
			if(count == 1)
				return true;

		}//end outer for
		return false;
	}

	//player hand
	public static void showPlayerHand(){
		System.out.println("\n Player's Cards:");
		for (int i = 0; i <playerCards.size();i++){
			 System.out.println((i + 1) + ". " + playerCards.get(i));
		}

	}

	public static void gameMenu(){

		Scanner scn = new Scanner(System.in);
		boolean playing = true;
		/*creating simple menu for user to have some
		 * choices when playing the game
		 */
	 while (playing){
			System.out.println("\n Choose an option:");
			System.out.println("1. Draw a card");
			System.out.println("2. Discard a card");
			System.out.println("3. Check for pair");
			System.out.println("4. View Hand");
			System.out.println("5. Exit");

			//ask for choice via number ex 1 for draw 5 for exit
			int choice = scn.nextInt();
		// works like else if statments but with less writting	
		switch(choice){
			//adds card 
			case 1:
				if(!deckOfCards.isEmpty()){
					Card drawn = deckOfCards.remove(0);
					playerCards.add(drawn);
					System.out.print("You drew: "+ drawn);
				}else{
					System.out.println("deck is empty");
				}
				break;
			// case which happens when #2 is inputed by user	
			case 2:
			showPlayerHand();;
			System.out.print("Enter card number to discard: ");
			int discard = scn.nextInt()-1;
			 if(discard >= 0 && discard < playerCards.size()){
				Card removed = playerCards.remove(discard);
				System.out.println("You discarded: "+ removed);
			 }else{
				System.out.println("Invalid Input");
			 }
			 break;
			 //checks for pair
		 case 3:
		     System.out.println("Pair found? " + checkFor2Kind());
             break;
		//shows hand
		 case 4:
			showPlayerHand();
			break;
		 case 5:
			playing =false;
			break;
		// checks fun the number input ex if 6 was inputed it would return this message
		 default:
			System.out.println("Invalid Input");	 

			}
		}
		System.out.println("Thanks for playing");
	}
}//end class
