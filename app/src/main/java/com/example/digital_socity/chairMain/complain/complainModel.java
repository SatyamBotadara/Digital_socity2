package com.example.digital_socity.chairMain.complain;

public class complainModel {

    private String Name;
    private String complainTitle;
    private String complainDesc;

    public complainModel(String name, String complainTitle, String complainDesc) {
        Name = name;
        this.complainTitle = complainTitle;
        this.complainDesc = complainDesc;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getComplainTitle() {
        return complainTitle;
    }

    public void setComplainTitle(String complainTitle) {
        this.complainTitle = complainTitle;
    }

    public String getComplainDesc() {
        return complainDesc;
    }

    public void setComplainDesc(String complainDesc) {
        this.complainDesc = complainDesc;
    }
}
