/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wkwcyg;

import java.util.ArrayList;

/**
 *
 * @author Mark Stone 832376
 */
public class Player {
    private String name;
    private ArrayList<String> hand = new ArrayList<String>();
    private String activeCard;
    
    public Player(){
        
    }
    
    public Player(String playName){
        name = playName;
    }
    public String getName(){
        return name;
    }
    public void addCard(String card){
        hand.add(card);
    }
    public int cardCount(){
        return hand.size();
    }
    public String getCard(int x){
        return hand.get(x);
    }
    public ArrayList<String> throwIn(int x){
        ArrayList<String> inPlay = new ArrayList<String>();
        int i = 0;
        int z = 0;
        for(i = 0; i < x; i++){
            inPlay.add(hand.get(i));
        }
        //System.out.println("i in throwIn = " + i);
        for(z = 0; z < x; z++){
            hand.remove(0);
        }
        //System.out.println("z in throwIn = " + z);
        return inPlay;
    }
    public String inPlay(){
        activeCard = hand.get(0);
        String play = hand.get(0);
        hand.remove(0);
        return play;
    }
    
    public String actCard(){
        return activeCard;
    }
  
}
