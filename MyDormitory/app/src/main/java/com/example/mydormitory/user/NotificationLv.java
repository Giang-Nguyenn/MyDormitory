package com.example.mydormitory.user;

class NotificationLv {
    private String Id;
    private String Describe;
    private String Content;
    private String Create;
    private String Add_Infor;

    public NotificationLv(String id, String describe, String content, String create, String add_Infor) {
        Id = id;
        Describe = describe;
        Content = content;
        Create = create;
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

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getCreate() {
        return Create;
    }

    public void setCreate(String create) {
        Create = create;
    }

    public String getAdd_Infor() {
        return Add_Infor;
    }

    public void setAdd_Infor(String add_Infor) {
        Add_Infor = add_Infor;
    }
}
