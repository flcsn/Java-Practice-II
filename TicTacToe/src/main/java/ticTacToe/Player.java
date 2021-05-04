/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

/**
 *
 * @author Frankie
 */
public class Player {
    private Symbol symbol;
    
    public Player(Symbol symbol) {
        this.symbol = symbol;
    }
    
    public Symbol getSymbol() {
        return this.symbol;
    }
    
    public String toString() {
        return this.symbol.name();
    }
    
}
