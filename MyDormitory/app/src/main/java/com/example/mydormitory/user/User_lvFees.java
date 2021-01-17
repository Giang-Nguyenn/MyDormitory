package com.example.mydormitory.user;

class User_lvFees {
    private String Describe;
    private String Create;
    private String Status;

    public User_lvFees(String describe, String create, String status) {
        Describe = describe;
        Create = create;
        Status = status;
    }

    public String getDescribe() {
        return Describe;
    }

    public void setDescribe(String describe) {
        Describe = describe;
    }

    public String getCreate() {
        return Create;
    }

    public void setCreate(String create) {
        Create = create;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
