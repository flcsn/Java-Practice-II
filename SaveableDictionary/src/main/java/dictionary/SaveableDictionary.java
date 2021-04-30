/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.HashMap;
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.ArrayList;

/**
 *
 * @author Frankie
 */
public class SaveableDictionary {
    private HashMap<String, String> translations;
    private String file;
    
    public SaveableDictionary(String file) {
        this.translations = new HashMap<>();
        this.file = file;
    }
    
    public SaveableDictionary() {
        this.translations = new HashMap<>();
    }
    
    public void add(String words, String translation) {
        translations.putIfAbsent(words, translation);
        translations.putIfAbsent(translation, words);
    }
    
    public String translate(String word){
        return translations.getOrDefault(word, null);
    }
    
    public void delete(String word) {
        Iterator iterator = translations.keySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(word)) {
                iterator.remove();
            }
        }
        
        iterator = translations.values().iterator();
        
        while (iterator.hasNext()) {
            if (iterator.next().equals(word)) {
                iterator.remove();
            }
        }
    }
    
    public boolean load() {
        try (Scanner scanner = new Scanner(Paths.get(file))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                String[] splittedRow = row.split(":");
                this.add(splittedRow[0], splittedRow[1]);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean save(){
        ArrayList<String> alreadySaved = new ArrayList<>();
        
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (String word : translations.keySet()) {
                if (!alreadySaved.contains(word)) {
                    fileWriter.write(word + ":" + translations.get(word) + "\n");
                    alreadySaved.add(word);
                    alreadySaved.add(translations.get(word));
                }
            }
            fileWriter.flush();
            fileWriter.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    
    
      
    
}
