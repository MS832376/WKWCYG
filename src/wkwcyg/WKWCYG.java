/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wkwcyg;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mark Stone 832376
 */
public class WKWCYG {
    /**
     * @param args the command line arguments
     */
    public static ArrayList<Player> thePlayers = new ArrayList<>();
    public static ArrayList<String> thePot = new ArrayList<>();
    public static boolean playing = true;
    
    public static void startIt(){
        
        //Player mark = new Player("Stone");
        //Player brandon = new Player("BG");
        //Player brendan = new Player("King");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter amount of players");
        int joined = 0;
        joined = scan.nextInt();
        Deck theDeck = new Deck(joined);
        theDeck.convertToStr();
        //System.out.println(theDeck.printOrder());
        //System.out.println("getCards: " + theDeck.getCards());
        Scanner scan2 = new Scanner(System.in);
        while(thePlayers.size() < joined){
            System.out.println("Enter player name: ");
            String name = scan2.nextLine();
            thePlayers.add(new Player(name));
        }
        //thePlayers.add(mark);
        //thePlayers.add(brandon);
        //thePlayers.add(brendan);
        Scanner scan3 = new Scanner(System.in);
        deal(theDeck);
        String roundWinner = "";
        while(playing == true){
            roundWinner = battle();
            System.out.println(roundWinner + " won that round!\n");
            for(int l = 0; l < thePlayers.size(); l++){
                if(thePlayers.get(l).cardCount() == 0){
                    System.out.println("Oh no! " + thePlayers.get(l).getName() + " is out of cards!");
                    System.out.println("The rest of the game will have to be played without them!\n");
                    thePlayers.remove(l);
                }
            }
            
            if(thePlayers.size() == 1){
                System.out.println("Congratulations " + thePlayers.get(0).getName() + "! You Won!");
                playing = false;
                break;
            }
            System.out.println("Do you want to play another round? (Y/N)");
            String answer = scan3.nextLine();
            answer = answer.trim();
            if(answer.equals("n")){
                playing = false;
                break;
            }
            //System.out.println("answer = " + answer);
        }
        System.out.println("Thanks for Playing 'WHO KNOWS WHAT CARDS YOU'LL GET?'");
        System.out.println("This game was created by Mark Stone, Brandon Green, and Brendan King!");
        //for(int i = 0; i < thePlayers.size(); i++){
        //    Player fill = thePlayers.get(i);
        //    System.out.println(fill.getName() + "'s handcount: " + fill.cardCount());
        //}
        //System.out.println("Stone's handcount: " + mark.handCount());
        //System.out.println("BG's handcount: " + brandon.handCount());
        //System.out.println("King's handcount: " + brendan.handCount());
        //System.out.println(order);
        //System.out.println("# Cards: " + deck.getCards());
        //System.out.println("Ace of Diamonds: " + convertToInt("Ace of Diamonds"));
        //System.out.println("Four of Spades: " + convertToInt("Four of Spades"));
        //System.out.println("Jack of Hearts: " + convertToInt("Jack of Hearts"));
        //System.out.println("Ten of Clubs: " + convertToInt("Ten of Clubs"));
    }
    public static void deal(Deck deck){
        int i = 0;
        while(i < deck.getCards()){
            for(int x = 0; x < thePlayers.size(); x++){
                if(i < deck.getCards()){
                    Player fill = thePlayers.get(x);
                    fill.addCard(deck.dealCard(i));
                    i++;
                }
            }
        }
        
    }
    public static String battle(){
        String winner = "";
        ArrayList<String> thePlay = new ArrayList<>();
        Player low = new Player();
        int min = 99999999;
        for(int i = 0; i < thePlayers.size(); i++){
            if(min > thePlayers.get(i).cardCount()){
                min = thePlayers.get(i).cardCount();
                low = thePlayers.get(i);
            }
            System.out.println("cardCount for player " + i + " = " + thePlayers.get(i).cardCount());
            
        }
        //System.out.println("min = " + min);
        if(min < 4){
            System.out.println("Uh-Oh, " + low.getName() + " only has " + low.cardCount() + " Cards!");
            System.out.println("All players will add " + (min-1) + " cards to the pot this round.");
            for(int z = 0; z < thePlayers.size(); z++){
                thePot.addAll(thePlayers.get(z).throwIn(min-1));
            }
        }else{
            System.out.println("Everyone has enough cards for a normal round!");
            for(int y = 0; y < thePlayers.size(); y++){
                thePot.addAll(thePlayers.get(y).throwIn(3));
            }
        }
        for(int x = 0; x < thePlayers.size(); x++){
            thePlay.add(thePlayers.get(x).inPlay());
        }
        int won = 0;
        int start = -1;
        int temp = -1;
        ArrayList<Player> winners = new ArrayList<>();
        ArrayList<Player> losers = new ArrayList<>();
        for(int v = 0; v < thePlay.size(); v++){
            System.out.println(thePlayers.get(v).getName() + " played a " + thePlay.get(v) + ".");
            temp = convertToVal(thePlay.get(v));
            int temp2 = 0;
            if(losers.size() > 0){
                temp2 = convertToVal(losers.get(0).actCard()); 
            }  
            if(temp > start){
                start = temp;
                won = v;
                if(winners.size() < 1){
                    winners.add(thePlayers.get(v));
                }else{
                    if(losers.size() < 1){
                        losers.addAll(winners);                        
                    }
                    winners.removeAll(thePlayers);
                    winners.add(thePlayers.get(v));  
                    won = v;
                }   
            }else if(temp == start){
                winners.add(thePlayers.get(v));
                //System.out.println("winners size = " + winners.size());
            }else if(temp < start){
                if(losers.size() < 1){
                    losers.add(thePlayers.get(v));
                }
            }
            if(temp2 == temp){
                //System.out.println("temp2 == temp");
                losers.add(thePlayers.get(v));
            }
            //System.out.println("losers size = " + losers.size());
        }
        if(losers.size() > 1){
            String lowerWar = "LOWER WAR! ";
            for(int ls = 0; ls < losers.size(); ls++){
                if(ls+1 == losers.size()){
                    lowerWar = lowerWar + losers.get(ls).getName() + " ";
                }else{
                    lowerWar = lowerWar + losers.get(ls).getName() + " and ";
                }
            }
            
            lowerWar = lowerWar + "have tied lower card values.";
            System.out.println(lowerWar);
            winner = war(losers);
            
            for(int f = 0; f < thePlayers.size(); f++){
                if(winner.equalsIgnoreCase(thePlayers.get(f).getName())){
                    won = f;
                    winners.add(thePlayers.get(won));
                }
            }
        }
        
        if(winners.size() > 1){
            String warAnnounce = "WAR! ";
            for(int ws = 0; ws < winners.size(); ws++){
                if(ws+1 == winners.size()){
                    warAnnounce = warAnnounce + winners.get(ws).getName() + " ";
                }else{
                    warAnnounce = warAnnounce + winners.get(ws).getName() + " and ";
                }
            
            }
            warAnnounce = warAnnounce + "must fight for the win!";
            System.out.println(warAnnounce);
            winner = war(winners);
        }
        for(int f = 0; f < thePlayers.size(); f++){
            if(winner.equalsIgnoreCase(thePlayers.get(f).getName())){
                won = f;
            }
        }
        thePot.addAll(thePlay);
        Player youWon = thePlayers.get(won);
        for(int w = 0; w < thePot.size(); w++){
            youWon.addCard(thePot.get(w));
        }
        
        //for(int u = 0; u < thePot.size(); u++){
        //    System.out.println("Index " + u + " of thePot: " + thePot.get(u));
        //}
        thePot.removeAll(thePot);
        return thePlayers.get(won).getName();
    }
    public static String war(ArrayList<Player> warPlayers){
        String winner = "";
        ArrayList<String> thePlay = new ArrayList<>();
        Player low = new Player();
        int min = 99999999;
        for(int i = 0; i < warPlayers.size(); i++){
            if(min > warPlayers.get(i).cardCount()){
                min = warPlayers.get(i).cardCount();
                low = warPlayers.get(i);
            }
            //System.out.println("cardCount for player " + i + " = " + thePlayers.get(i).cardCount());
            
        }
        //System.out.println("min = " + min);
        if(min < 4){
            System.out.println("Uh-Oh, " + low.getName() + " only has " + low.cardCount() + " Cards!");
            System.out.println("All players will add " + (min-1) + " cards to the pot this round");
            for(int z = 0; z < warPlayers.size(); z++){
                thePot.addAll(warPlayers.get(z).throwIn(min-1));
            }
        }else{
            System.out.println("All participants have enough cards for a war round!");
            for(int y = 0; y < warPlayers.size(); y++){
                thePot.addAll(warPlayers.get(y).throwIn(3));
            }
        }
        for(int x = 0; x < warPlayers.size(); x++){
            thePlay.add(warPlayers.get(x).inPlay());
        }
        
        int won = 0;
        int start = -1;
        int temp = -1;
        ArrayList<Player> winners = new ArrayList<>();
        for(int v = 0; v < thePlay.size(); v++){
            System.out.println(warPlayers.get(v).getName() + " played a " + thePlay.get(v) + ".");
            temp = convertToVal(thePlay.get(v));
            if(temp > start){
                start = temp;
                won = v;
                if(winners.size() < 1){
                    winners.add(warPlayers.get(v));
                }else{
                    for(int e = 0; e < winners.size(); e++){
                       winners.remove(e);      
                    }
                    winners.add(warPlayers.get(v));
                    won = v;
                }
            }else if(temp == start){
                winners.add(warPlayers.get(v));
            }
        }
        if(winners.size() > 1){
            String warAnnounce = "WAR! ";
            for(int ws = 0; ws < winners.size(); ws++){
                if(ws+1 == winners.size()){
                    warAnnounce = warAnnounce + winners.get(ws).getName() + " ";
                }else{
                    warAnnounce = warAnnounce + winners.get(ws).getName() + " and ";
                }
            
            }
            warAnnounce = warAnnounce + "must fight for the win!";
            System.out.println(warAnnounce);
            winner = war(winners);
        }
        for(int f = 0; f < warPlayers.size(); f++){
            if(winner.equalsIgnoreCase(warPlayers.get(f).getName())){
                won = f;
            }
        }
        thePot.addAll(thePlay);
        return warPlayers.get(won).getName();
    }
    public static int convertToVal(String card){

        switch (card) {
                case "Ace of Hearts":
                    return 14;
                case "Ace of Spades":
                    return 14;
                case "Ace of Diamonds":
                    return 14;
                case "Ace of Clubs":
                    return 14;
                case "Two of Hearts":
                    return 2;
                case "Three of Hearts":
                    return 3;
                case "Four of Hearts":
                    return 4;
                case "Five of Hearts":
                    return 5;
                case "Six of Hearts":
                    return 6;
                case "Seven of Hearts":
                    return 7;
                case "Eight of Hearts":
                    return 8;
                case "Nine of Hearts":
                    return 9;
                case "Ten of Hearts":
                    return 10;
                case "Jack of Hearts":
                    return 11;
                case "Queen of Hearts":
                    return 12;
                case "King of Hearts":
                    return 13;
                case "Two of Diamonds":
                    return 2;
                case "Three of Diamonds":
                    return 3;
                case "Four of Diamonds":
                    return 4;
                case "Five of Diamonds":
                    return 5;
                case "Six of Diamonds":
                    return 6;
                case "Seven of Diamonds":
                    return 7;
                case "Eight of Diamonds":
                    return 8;
                case "Nine of Diamonds":
                    return 9;
                case "Ten of Diamonds":
                    return 10;
                case "Jack of Diamonds":
                    return 11;
                case "Queen of Diamonds":
                    return 12;
                case "King of Diamonds":
                    return 13;
                case "Two of Spades":
                    return 2;
                case "Three of Spades":
                    return 3;
                case "Four of Spades":
                    return 4;
                case "Five of Spades":
                    return 5;
                case "Six of Spades":
                    return 6;
                case "Seven of Spades":
                    return 7;
                case "Eight of Spades":
                    return 8;
                case "Nine of Spades":
                    return 9;
                case "Ten of Spades":
                    return 10;
                case "Jack of Spades":
                    return 11;
                case "Queen of Spades":
                    return 12;
                case "King of Spades":
                    return 13;
                case "Two of Clubs":
                    return 2;
                case "Three of Clubs":
                    return 3;
                case "Four of Clubs":
                    return 4;
                case "Five of Clubs":
                    return 5;
                case "Six of Clubs":
                    return 6;
                case "Seven of Clubs":
                    return 7;
                case "Eight of Clubs":
                    return 8;
                case "Nine of Clubs":
                    return 9;
                case "Ten of Clubs":
                    return 10;
                case "Jack of Clubs":
                    return 11;
                case "Queen of Clubs":
                    return 12;
                case "King of Clubs":
                    return 13;
                default:
                    return 0;
            }
    }
    public static void main(String[] args) {
        startIt();  
    }
}
