package com.bobo.demo.entity;

public class Shop {

    public Integer id;
    public Integer sid;
    public String name;
    public Integer price;
    public Integer weight;
    public String locations;

    public Shop(Integer id, Integer sid, String name, Integer price, Integer weight, String locations) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.locations = locations;
    }

    public Shop() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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
