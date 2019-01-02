package com.example.asus.a1000animestories;

public class Stories {

    private String judul;
    private String isi;
    private String genre;


    public Stories(String judul, String isi, String genre) {
        this.judul = judul;
        this.isi = isi;
        this.genre = genre;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
