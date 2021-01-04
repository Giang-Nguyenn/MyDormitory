package com.example.mydormitory.Admin;

class Admin_LvUser {
    private  String Name;
    private  String Image;
    private  String Address;
    private  String UserId;

    public Admin_LvUser(String name, String image, String address, String userId) {
        Name = name;
        Image = image;
        Address = address;
        UserId = userId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}
