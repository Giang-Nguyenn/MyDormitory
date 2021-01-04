package com.example.mydormitory.user;

public class User_LvRoom {
    private String Name;
    private String Image;
    private String BirthDay;
    private String UserId;

    public User_LvRoom(String name, String image, String birthDay, String userId) {
        Name = name;
        Image = image;
        BirthDay = birthDay;
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

    public String getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(String birthDay) {
        BirthDay = birthDay;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}
