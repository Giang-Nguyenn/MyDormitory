package com.example.mydormitory.Admin;

class Admin_Messenger_Header {
    private  String Id_mess;
    private String Id_send;
    private String messenger;
    private String status;
    private String time;
    private String image;
    private String name;
    private String activiti;

    public Admin_Messenger_Header() {
    }

    public Admin_Messenger_Header(String id_mess, String id_send, String messenger, String status, String time, String image, String name, String activiti) {
        Id_mess = id_mess;
        Id_send = id_send;
        this.messenger = messenger;
        this.status = status;
        this.time = time;
        this.image = image;
        this.name = name;
        this.activiti = activiti;
    }

    public String getId_mess() {
        return Id_mess;
    }

    public void setId_mess(String id_mess) {
        Id_mess = id_mess;
    }

    public String getId_send() {
        return Id_send;
    }

    public void setId_send(String id_send) {
        Id_send = id_send;
    }

    public String getMessenger() {
        return messenger;
    }

    public void setMessenger(String messenger) {
        this.messenger = messenger;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActiviti() {
        return activiti;
    }

    public void setActiviti(String activiti) {
        this.activiti = activiti;
    }
}
