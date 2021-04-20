/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Frankie
 */
public class ProductWarehouseWithHistory extends ProductWarehouse {
    private ChangeHistory changeHistory;
    
    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        this.changeHistory = new ChangeHistory();
        this.setBalance(initialBalance);
        this.changeHistory.add(initialBalance);
    }
    
    public String history() {
        return this.changeHistory.toString();
    }
    
    @Override
    public void addToWarehouse(double amount) {
        if (amount < 0) {
            return;
        }
        
        if (amount <= this.howMuchSpaceLeft()) {
            this.setBalance(this.getBalance() + amount);
        } else {
            amount = this.howMuchSpaceLeft();
            this.setBalance(amount);
        }
        
        this.changeHistory.add(this.getBalance());
    }
    
    @Override
    public double takeFromWarehouse(double amount) {
        if (amount < 0) {
            return 0;
        }
        
        if (amount > this.getBalance()) {
            amount = this.getBalance();
            this.setBalance(amount);
        } else {
            this.setBalance(this.getBalance() - amount);
        }
        
        this.changeHistory.add(this.getBalance());
        return amount;
    }
    
    public void printAnalysis() {
        System.out.println("Product: " + this.getName());
        System.out.println("History: " + this.changeHistory);
        System.out.println("Largest amount of product: " + this.changeHistory.maxValue());
        System.out.println("Smallest amount of product: " + this.changeHistory.minValue());
        System.out.println("Average: " + this.changeHistory.average());
    }
    
    
    
}
