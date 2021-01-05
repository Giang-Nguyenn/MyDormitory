package com.example.mydormitory.Admin;

class Admin_Frees {
    private String Id;
    private String Describe;
    private String Create;
    private String Status;
    private String Add_Infor;

    public Admin_Frees(String id, String describe, String create, String status, String add_Infor) {
        Id = id;
        Describe = describe;
        Create = create;
        Status = status;
        Add_Infor = add_Infor;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

    public String getAdd_Infor() {
        return Add_Infor;
    }

    public void setAdd_Infor(String add_Infor) {
        Add_Infor = add_Infor;
    }
}
