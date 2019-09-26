package com.example.myapplication;

public class Contact {
    private String genre;
    private String year;

    public Contact() {
    }

    public Contact( String genre, String year) {

        this.genre = genre;
        this.year = year;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}