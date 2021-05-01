/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Frankie
 */
public class List<T> {
    private T[] elements;
    private int firstFreeIndex;
    
    public List() {
        this.elements = (T[]) new Object[10];
        this.firstFreeIndex = 0;
    }
    
    public void add(T object) {
        if (firstFreeIndex == elements.length) {
            grow();
        }
        elements[firstFreeIndex] = object;
        firstFreeIndex++;
    }
    
    public void grow() {
        int newSize = elements.length + elements.length / 2;
        T[] newArray = (T[]) new Object[newSize];
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }
        this.elements = newArray;
    }
    
    public boolean contains(T object) {
        if (indexOfValue(object) >= 0) return true;
        return false;
    }
    
    public int indexOfValue(T object) {
        for (int i = 0; i < firstFreeIndex; i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        } 
        return -1;
    }
    
    public T value(int index) {
        return elements[index];
    }
    
    public void remove(T object) {
        int index = indexOfValue(object);
        moveToTheLeft(index);
        firstFreeIndex--;
    }
    
    public void moveToTheLeft(int startIndex) {
        for (int i = startIndex; i < firstFreeIndex-1; i++) {
            elements[i] = elements[i+1];
        }
    }
    
    public int size() {
        return firstFreeIndex;
    }
    
    
    
}
