package com.example.digital_socity.chairMain.events;


public class eventModel {
    private String EventTitle;
    private String EvenetDescription;
    private String Date;

    public eventModel(String eventTitle, String evenetDescription, String date) {
        EventTitle = eventTitle;
        EvenetDescription = evenetDescription;
        Date = date;
    }

    public String getEventTitle() {
        return EventTitle;
    }

    public void setEventTitle(String eventTitle) {
        EventTitle = eventTitle;
    }

    public String getEvenetDescription() {
        return EvenetDescription;
    }

    public void setEvenetDescription(String evenetDescription) {
        EvenetDescription = evenetDescription;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
