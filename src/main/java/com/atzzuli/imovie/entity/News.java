package com.atzzuli.imovie.entity;

public class News {
    private String news;
    private String date;

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "News{" +
                "news='" + news + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
