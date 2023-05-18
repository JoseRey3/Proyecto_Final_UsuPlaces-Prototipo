package com.example.usuplace.Domain;

import java.io.Serializable;

public class CategoryDomain implements Serializable{
    public CategoryDomain(String category, String imgCat) {
        this.category = category;
        this.imgCat = imgCat;
    }

    private String category;
    private String imgCat;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImgCat() {
        return imgCat;
    }

    public void setImgCat(String imgCat) {
        this.imgCat = imgCat;
    }
}
