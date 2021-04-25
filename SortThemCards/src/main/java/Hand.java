/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Frankie
 */
import java.util.Collections;
import java.util.ArrayList;

public class Hand implements Comparable<Hand> {
    private ArrayList<Card> cards;
    
    public Hand() {
        this.cards = new ArrayList<>();
    }
    
    public void add(Card card) {
        cards.add(card);
    }
    
    public void print() {
        cards.stream().forEach(card -> System.out.println(card));
    }
    
    public void sort() {
        Collections.sort(cards);
    }
    
    public void sortBySuit() {
        Collections.sort(cards, new BySuitInValueOrder());
    }
    
    public int compareTo(Hand other) {
        int thisSum = 0;
        for (Card card : this.cards) {
            thisSum += card.getValue();
        }
        
        int otherSum = 0;
        for (Card card : other.cards) {
            otherSum += card.getValue();
        }
        
        return thisSum - otherSum;
    }
    
}
