package com.bobo.demo.entity;

public class Fruit {
    public Integer id;
    public String name;
    public Integer price;
    public Integer weight;
    public String locations;


    public Fruit(String name, Integer price, Integer weight, String locations) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.locations = locations;
    }

    public Fruit(Integer id, String name, Integer price, Integer weight, String locations) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.locations = locations;
    }

    public Fruit() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

}
