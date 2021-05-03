/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Frankie
 */
public class Dictionary {
    private HashMap<String, String> translations;
    private List<String> words;
    
    public Dictionary() {
        this.translations = new HashMap<>();
        this.words = new ArrayList<>();
        
        add("sana", "word");
    }
    
    public void add(String word, String translation) {
        if (!translations.keySet().contains(word)) {
            this.words.add(word);
        }
        
        this.translations.put(word, translation);
    }
    
    public String translate(String word) {
        return this.translations.get(word);
    }
    
    public String getRandomWord() {
        Random random = new Random();
        return this.words.get(random.nextInt(this.words.size()));
    }
}
