package com.example.volleyglidetutorial.model;

public class Anime {

    private String name;
    private String description;
    private String rating;
    private int episodes;
    private String category;
    private String image_url;
    private String studio;


    public Anime(){

    }

    public Anime(String name, String description, String rating, int episodes, String category, String image_url, String studio) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.episodes = episodes;
        this.category = category;
        this.image_url = image_url;
        this.studio = studio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
}

