package com.example.digital_socity.chairMain.notice;

public class noticeModel {
    private String Title;
    private String Desc;

    public noticeModel(String title, String desc) {
        Title = title;
        Desc = desc;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }
}
