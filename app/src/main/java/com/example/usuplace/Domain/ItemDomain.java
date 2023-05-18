package com.example.usuplace.Domain;

import java.io.Serializable;

public class ItemDomain implements Serializable{
    private String title;
    private String addres;
    private String description;
    private int price;
    private String pic;

    public ItemDomain(String title, String addres, String description, int price, String pic) {
        this.title = title;
        this.addres = addres;
        this.description = description;
        this.price = price;
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
