package com.example.mydormitory.Admin;

class Admin_Messenger {
    private String Id_send;
    private String messenger;
    private String status;
    private String time;

    public Admin_Messenger() {
    }

    public Admin_Messenger(String id_send, String messenger, String status, String time) {
        Id_send = id_send;
        this.messenger = messenger;
        this.status = status;
        this.time = time;
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
}
