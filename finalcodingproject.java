package finalquiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class finalcodingproject {

	static class Card {
			private int value;
			private String name;
			
			public Card(int value, String name) {
				this.value = value;
				this.name = name;
			}
			public int getValue() {
				return value;
			}
			public void setValue(int value) {
				this.value = value;
			}
			public String getname() {
				return name ;
			}
			public void setName(String name) {
				this.name = name;
			}
			public void describe() {
				System.out.println("Card name: " + name + ", Card value: " + value);
			}
	}
	static class Deck {
		private List<Card> cards = new ArrayList<>();
		
		public Deck() {
			populateDeck();
		}
		
		public void shuffle() {
			Collections.shuffle(cards);
		}
	
		public Card draw() {
			if (!cards.isEmpty()) {
				return cards.remove(0);
			}
			return null;
		}
	private void populateDeck() {
		String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
		for (String suit : suits) {
			for (int value = 2; value <=14; value++) {
				String name;
				if (value <= 10) {
					name = Integer.toString(value);
				} else {
					switch (value) {
					case 11:
						name = "Jack";
						break;
					case 12: 
						name = "Queen";
						break;
					case 13:
						name = "King";
						break;
					case 14:
						name = "Ace";
						break;
					default:
						name = "";
						break;
					}
				}
				cards.add(new Card(value, name + " of " + suit));
			}
		}
	}
}
static class Player {
	private List<Card> hand = new ArrayList<>();
	private int score;
	private String name;
	
	public Player(String name) {
		this.name = name;
		this.score = 0;
	}
	public void describe() {
		System.out.println("Player: " + name);
		for (Card card : hand) {
			card.describe();
		}
	}
	public Card flip() {
		if (!hand.isEmpty()) {
			return hand.remove(0);
		}
		return null;
	}
	public void draw(Deck deck) {
		Card drawnCard = deck.draw();
		if (drawnCard != null) {
			hand.add(drawnCard);
		}
	}
	public void incrementScore() {
		score++;
	}
	public int getScore() {
		return score;
	}
}
public static class App {
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		Player player1 = new Player("Player 1");
		Player player2 = new Player("Player 2");
		
		deck.shuffle();
	
		for (int i=0; i<52; i++) {
			player1.draw(deck);
		}
		for (int i=0; i<26; i++) {
			Card card1 = player1.flip();
			Card card2 = player2.flip();
			
			System.out.println("Player 1 draws: " + card1.getname());
			System.out.println("Player 2 draws: " + card2.getname());
			
			if (card1.getValue() > card2.getValue()) {
				System.out.println("Player 1 gets a point!");
				player1.incrementScore();
			}else if (card1.getValue() < card2.getValue()) {
				System.out.println("Player 2 gets a point!");
				player2.incrementScore();
			} else {
				System.out.println("It's a draw! No points awarded.");
			}
		}
		int scorePlayer1 = player1.getScore();
		int scorePlayer2 = player2.getScore();
		
		System.out.println("Final scores!:");
		System.out.println("Player 1 got: " + scorePlayer1);
		System.out.println("Player 2 got: " + scorePlayer2);
		
		if (scorePlayer1 > scorePlayer2) {
			System.out.println("Player 1 is the winner!!");
		}else if (scorePlayer1 < scorePlayer2) {
			System.out.println("Player 2 is the winner!!");
		}else {
			System.out.println("It's a draw!!");
		}
	}
}
}
			
		


