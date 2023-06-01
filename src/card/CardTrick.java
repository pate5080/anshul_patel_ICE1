/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author srinivsi
 * @modifier pate5080 
 * Anshul Alpesh Patel
 * @studentNumber 991710958 
 * @date : 05-31-23
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        Random rn = new Random();
        Scanner sc = new Scanner(System.in);
        
        /*
         * the loop to randomly select a card from the deck of 52
         * There will be 7 cards selected in the magicHand
         */
        for (int i=0; i<magicHand.length; i++)
        {
            Card c = new Card();
            c.setValue(rn.nextInt(13)+1);
            c.setSuit(Card.SUITS[rn.nextInt(4)]);
            magicHand[i] = c;
            
        }
        
        /*
         * Programmer's lucky card
         */
        Card luckyCard = new Card();
        luckyCard.setValue(7);
        luckyCard.setSuit(Card.SUITS[2]);
        
        /*
         * Prompting the user to enter the card value and suit value
         */
        System.out.print("Pick a card value (1-13): ");
        int pickedValue = sc.nextInt();
        
        System.out.print("Pick a card suit (0-3): ");
        int pickedSuit = sc.nextInt();
        
        /*
         * Based on the choice, retriving the card
         */
        Card pickedCard = new Card();
        pickedCard.setValue(pickedValue);
        pickedCard.setSuit(Card.SUITS[pickedSuit]);
        
        boolean isCardFound = false;
        
        /*
         * Checking for the card to be on of the card in the array
         */
        for (Card card : magicHand) {
            if (card.getValue() == pickedCard.getValue() && card.getSuit().equals(pickedCard.getSuit())){
                isCardFound = true;
                break;
            }
        }
        
        /*
         * Printing out the result
         */
        if (isCardFound) {
            System.out.println("Congratualations! Your card is in the magic hand.");
        } else {
            System.out.println("Sorry! Your card is not in the magic hand.");
        }
        
        /*
         * Comparing the lucky card to the picked card
         */
        if (luckyCard.getValue() == pickedCard.getValue() && luckyCard.getSuit().equals(pickedCard.getSuit())) {
            System.out.println("You picked the lucky card!");
        } else {
            System.out.println("The lucky card is not the card you picked.");
        }
        
        /*
         * Printing the Lucky card and the choosen card
         */
        System.out.println("The lucky card is: " + luckyCard.getValue() + luckyCard.getSuit());
        System.out.println("Your card is: " + pickedCard.getValue() + pickedCard.getSuit());
    }
    
}
