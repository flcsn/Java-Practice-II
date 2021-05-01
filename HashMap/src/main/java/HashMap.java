/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Frankie
 */
import java.util.ArrayList;

public class HashMap<K, V> {
    private ArrayList<Pair<K, V>>[] values;
    private int firstFreeIndex;
    
    public HashMap() {
        this.values = new ArrayList[32];
        this.firstFreeIndex = 0;
    }
    
    public V get(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);
        if (values[hashValue] == null) {
            return null;
        }
        ArrayList<Pair<K, V>> list = values[hashValue];
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                return list.get(i).getValue();
            }
        }
        return null;
    }
    
    public void add(K key, V value) {
        ArrayList<Pair<K, V>> list = getListBasedOnKey(key);
        int index = getIndexOfKey(list, key);
        
        if (index >= 0) {
            list.get(index).setValue(value);
            
        } else if (index < 0) {
            list.add(new Pair<>(key, value));
            this.firstFreeIndex++;
        }
        
        if ((double) this.firstFreeIndex / this.values.length > 0.75) {
            grow();
        }
    }
    
    public ArrayList<Pair<K, V>> getListBasedOnKey(K key) {
        int hashValue = Math.abs(key.hashCode() % this.values.length);
            if (values[hashValue] == null) {
                values[hashValue] = new ArrayList<>();
            }
        return values[hashValue];
    }
    
    public int getIndexOfKey(ArrayList<Pair<K, V>> list, K key) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                index = i;
                break;
            }
        }
        return index;
    }
    
    private void grow() {
        int newSize = this.values.length * 2;
        ArrayList<Pair<K, V>>[] newArray = new ArrayList[newSize];
        
        for (int i = 0; i < values.length; i++) {
            copy(newArray, this.values[i]);
        }
        
        this.values = newArray;
    }
    
    private void copy(ArrayList<Pair<K, V>>[] newArray, ArrayList<Pair<K, V>> listAtOldIndex) {
        for (int i = 0; i < listAtOldIndex.size(); i++) {
            Pair<K, V> pair = listAtOldIndex.get(i);
            int newHashValue = Math.abs(pair.getKey().hashCode() % newArray.length);
            
            ArrayList<Pair<K, V>> newList = newArray[newHashValue];
            
            if (newList == null) {
                newList = new ArrayList<>();
            }
            
            newList.add(pair);
        }
    }
    
    public V remove(K key) {
        ArrayList<Pair<K, V>> listOfKey = getListBasedOnKey(key);
        if (listOfKey == null) {
            return null;
        }
        
        int indexOfKey = getIndexOfKey(listOfKey, key);
        if (indexOfKey < 0) {
            return null;
        }
        
        Pair<K, V> pairToRemove = listOfKey.get(indexOfKey);
        listOfKey.remove(pairToRemove);
        return pairToRemove.getValue();
    }
    
    
}
