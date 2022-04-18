package com.example.signingoogle.HelperClasses;

public class MostviewHelperClass {
    int image;
    String titlemv, descmv;

    public MostviewHelperClass(int image, String titlemv, String descmv) {
        this.image = image;
        this.titlemv = titlemv;
        this.descmv = descmv;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitlemv() {
        return titlemv;
    }

    public void setTitlemv(String titlemv) {
        this.titlemv = titlemv;
    }

    public String getDescmv() {
        return descmv;
    }

    public void setDescmv(String descmv) {
        this.descmv = descmv;
    }
}
