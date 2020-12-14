/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wkwcyg;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Mark Stone 832376
 */
public class Deck {
    
    private int cards;
    private ArrayList<Integer> intDeck = new ArrayList<Integer>();
    private ArrayList<String> strDeck = new ArrayList<String>();
    
    public Deck(){
        cards = 52;
        int i = 0;
        int random = 0;
        Random rand = new Random();
        while(i < cards){
            random = rand.nextInt(cards);
            if(intDeck.contains(random + 1)){
                
            }else{
                intDeck.add(random + 1);
                i++;
            }
            
        }
        
    }
    
    public Deck(double players){
        int decks = 0;
        if(players > 4){
            decks = (int)Math.ceil(players/2);
            cards = decks*52;
        }else if(players > 2){
            cards = 104;
            decks = 2;
        }else{
            cards = 52;
            decks = 1;
        }
        //System.out.println("decks = " + decks);
        //System.out.println("Number of Cards: " + cards);
        int i = 0;
        int random = 0;
        Random rand = new Random();
        while(i < cards){
            random = rand.nextInt(cards);
            if(intDeck.contains(random + 1)){
                
            }else{
                intDeck.add(random + 1);
                i++;
            }
            
        }
        //System.out.println("intDeck.size(): " + intDeck.size());
    }
    public int getCards(){
        return cards;
    }
    public void convertToStr(){
        int card = 0;
        //System.out.println("intdeck(0): " + intDeck.get(0));
        for(int i = 0; i < intDeck.size(); i++){
            card = intDeck.get(i);
            while(card > 52){
                card = card - 52;
                //System.out.println("card - 52 while loop");
            }
            switch (card) {
                case 1:
                    strDeck.add("Ace of Hearts");
                    break;
                case 2:
                    strDeck.add("Two of Hearts");
                    break;
                case 3:
                    strDeck.add("Three of Hearts");
                    break;
                case 4:
                    strDeck.add("Four of Hearts");
                    break;
                case 5:
                    strDeck.add("Five of Hearts");
                    break;
                case 6:
                    strDeck.add("Six of Hearts");
                    break;
                case 7:
                    strDeck.add("Seven of Hearts");
                    break;
                case 8:
                    strDeck.add("Eight of Hearts");
                    break;
                case 9:
                    strDeck.add("Nine of Hearts");
                    break;
                case 10:
                    strDeck.add("Ten of Hearts");
                    break;
                case 11:
                    strDeck.add("Jack of Hearts");
                    break;
                case 12:
                    strDeck.add("Queen of Hearts");
                    break;
                case 13:
                    strDeck.add("King of Hearts");
                    break;
                case 14:
                    strDeck.add("Ace of Diamonds");
                    break;
                case 15:
                    strDeck.add("Two of Diamonds");
                    break;
                case 16:
                    strDeck.add("Three of Diamonds");
                    break;
                case 17:
                    strDeck.add("Four of Diamonds");
                    break;
                case 18:
                    strDeck.add("Five of Diamonds");
                    break;
                case 19:
                    strDeck.add("Six of Diamonds");
                    break;
                case 20:
                    strDeck.add("Seven of Diamonds");
                    break;
                case 21:
                    strDeck.add("Eight of Diamonds");
                    break;
                case 22:
                    strDeck.add("Nine of Diamonds");
                    break;
                case 23:
                    strDeck.add("Ten of Diamonds");
                    break;
                case 24:
                    strDeck.add("Jack of Diamonds");
                    break;
                case 25:
                    strDeck.add("Queen of Diamonds");
                    break;
                case 26:
                    strDeck.add("King of Diamonds");
                    break;
                case 27:
                    strDeck.add("Ace of Spades");
                    break;
                case 28:
                    strDeck.add("Two of Spades");
                    break;
                case 29:
                    strDeck.add("Three of Spades");
                    break;
                case 30:
                    strDeck.add("Four of Spades");
                    break;
                case 31:
                    strDeck.add("Five of Spades");
                    break;
                case 32:
                    strDeck.add("Six of Spades");
                    break;
                case 33:
                    strDeck.add("Seven of Spades");
                    break;
                case 34:
                    strDeck.add("Eight of Spades");
                    break;
                case 35:
                    strDeck.add("Nine of Spades");
                    break;
                case 36:
                    strDeck.add("Ten of Spades");
                    break;
                case 37:
                    strDeck.add("Jack of Spades");
                    break;
                case 38:
                    strDeck.add("Queen of Spades");
                    break;
                case 39:
                    strDeck.add("King of Spades");
                    break;
                case 40:
                    strDeck.add("Ace of Clubs");
                    break;
                case 41:
                    strDeck.add("Two of Clubs");
                    break;
                case 42:
                    strDeck.add("Three of Clubs");
                    break;
                case 43:
                    strDeck.add("Four of Clubs");
                    break;
                case 44:
                    strDeck.add("Five of Clubs");
                    break;
                case 45:
                    strDeck.add("Six of Clubs");
                    break;
                case 46:
                    strDeck.add("Seven of Clubs");
                    break;
                case 47:
                    strDeck.add("Eight of Clubs");
                    break;
                case 48:
                    strDeck.add("Nine of Clubs");
                    break;
                case 49:
                    strDeck.add("Ten of Clubs");
                    break;
                case 50:
                    strDeck.add("Jack of Clubs");
                    break;
                case 51:
                    strDeck.add("Queen of Clubs");
                    break;
                case 52:
                    strDeck.add("King of Clubs");
                    //System.out.println(i);
                    //System.out.println(intDeck.get(i));
                    break;
                default:
                    break;
            }
        }
        //System.out.println("strDeck.size(): " + strDeck.size());
    }
    public String printOrder(){
        String order = "";
        for(int i = 0; i < strDeck.size(); i++){
            //System.out.println("printOrder for loop: " + i);
            //System.out.println("Added card: " + strDeck.get(i));
            if(i == 0){
                order = order + strDeck.get(i);
            }else{
                order = order + ", " + strDeck.get(i);
            }
            
        }
        return order;
    }
    public String dealCard(int x){
        return strDeck.get(x);
    }
}
