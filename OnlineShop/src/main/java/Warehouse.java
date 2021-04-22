/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Frankie
 */
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class Warehouse {
    private Map<String,Integer> stocks;
    private Map<String,Integer> prices;
    
    public Warehouse() {
        this.stocks = new HashMap<>();
        this.prices = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock) {
        this.stocks.put(product, stock);
        this.prices.put(product, price);
    }
    
    public int price(String product) {
        if (!this.prices.containsKey(product)) {
            return -99;
        }
        
        return this.prices.get(product);
    }
    
    public int stock(String product) {
        if (!this.stocks.containsKey(product)) {
            return 0;
        }
        
        return this.stocks.get(product);
    }
    
    public boolean take(String product) {
        if (!this.stocks.containsKey(product) || this.stocks.get(product) == 0) {
            return false;
        }
        int newStock = this.stocks.get(product) - 1;
        this.stocks.put(product, newStock);
                
        return true;
    }
    
    public Set<String> products() {
        return this.stocks.keySet();
    }
    
    
    
    
    
    
}
