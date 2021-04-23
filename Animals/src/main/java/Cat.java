/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Frankie
 */
public class Cat extends Animal implements NoiseCapable {
    
    public Cat(String name) {
        super(name);
    }
    
    public Cat() {
        super("Cat");
    }
    
    public void purr() {
        System.out.println(this.getName() + " purrs");
    }
    
    @Override
    public void makeNoise() {
        this.purr();
    }
}
