/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Frankie
 */
public class LiteracyRate implements Comparable<LiteracyRate>{
    private String theme;
    private String ageGroup;
    private String gender;
    private String country;
    private int year;
    private double literacyPercent;
    
    public LiteracyRate(String theme, String ageGroup, String gender, String country, int year, double literacyPercent) {
        this.theme = theme;
        this.ageGroup = ageGroup.trim();
        this.gender = gender.replace("(%)", "").trim();
        this.country = country;
        this.year = year;
        this.literacyPercent = literacyPercent;
    }

    public String getTheme() {
        return theme;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public double getLiteracyPercent() {
        return literacyPercent;
    }
    
    public int compareTo(LiteracyRate other) {
        if (this.literacyPercent > other.getLiteracyPercent()) {
            return 1;
        } else if (this.literacyPercent < other.getLiteracyPercent()) {
            return -1;
        }
        return 0;
    }
    
    public String toString() {
        return country + " (" + year + "), " + gender + ", " + literacyPercent;
    }
}
