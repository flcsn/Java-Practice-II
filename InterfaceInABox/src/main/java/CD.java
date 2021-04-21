/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Frankie
 */
public class CD implements Packable {
    private String artist;
    private String CD;
    private int publicationYear;
    
    public CD(String artist, String CD, int publicationYear) {
        this.artist = artist;
        this.CD = CD;
        this.publicationYear = publicationYear;
    }
    
    public double weight() {
        return 0.1;
    }
    
    public String toString() {
        return this.artist + ": " + this.CD + " (" + this.publicationYear + ")";
    }
}
