package com.atzzuli.imovie.entity;

public class Movie {
     public String type;
     public String name;
     public String date;
     public String actors;
     public String introduction;
     public String filename;
     public String picname;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPicname() {
        return picname;
    }

    public void setPicname(String picname) {
        this.picname = picname;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", actors='" + actors + '\'' +
                ", introduction='" + introduction + '\'' +
                ", filename='" + filename + '\'' +
                ", picname='" + picname + '\'' +
                '}';
    }
}

