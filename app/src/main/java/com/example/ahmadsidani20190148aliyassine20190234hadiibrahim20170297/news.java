package com.example.ahmadsidani20190148aliyassine20190234hadiibrahim20170297;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class news {

    public long id;
    public String category;
    public String title;
    public String description;
    public String keyword;
    public String date;
    public Boolean isactive;
    public int likes;


    public news(long id,String category, String title, String description, String keyword, String date) {

        this.id = id;
        this.category= category;
        this.title = title;
        this.description = description;
        this.keyword = keyword;
        this.date = date;
        this.isactive=true;
        this.likes=0;
    }
    public news( String category, String title, String description, String keyword, String date) {

        this.title = title;
        this.category= category;
        this.description = description;
        this.keyword = keyword;
        this.date = date;
        this.isactive=true;
        this.likes=0;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getCategory() {
        return category;
    }

    public int getLikes() {
        return likes;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }



    public Boolean getIsactive() {
        return isactive;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getDate() {
        return date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
