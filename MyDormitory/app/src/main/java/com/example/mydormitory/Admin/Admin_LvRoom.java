package com.example.mydormitory.Admin;

public class Admin_LvRoom {
    private String Name;
    private String count;
    private String color;

    public Admin_LvRoom(String name, String count, String color) {
        Name = name;
        this.count = count;
        this.color = color;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
