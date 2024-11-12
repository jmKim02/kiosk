package org.example.ui;

import java.time.LocalDateTime;
import java.time.Month;

public class AdvertiseManager {
    public static String getMonthAdvertisement(){
        return checkMonthAdvertisement();
    }

    private static String checkMonthAdvertisement(){
        LocalDateTime today = LocalDateTime.now();
        Month thisMonth = today.getMonth();

        String eventName = "images/advertise/event00.jpg";

        if (thisMonth == Month.JANUARY){
            eventName = "images/advertise/event01.jpg";
        }
        if (thisMonth == Month.FEBRUARY){
            eventName = "images/advertise/event02.jpg";
        }
        if (thisMonth == Month.MARCH){
            eventName = "images/advertise/event03.jpg";
        }
        if (thisMonth == Month.APRIL){
            eventName = "images/advertise/event04.jpg";
        }
        if (thisMonth == Month.MAY){
            eventName = "images/advertise/event05.jpg";
        }
        if (thisMonth == Month.JUNE){
            eventName = "images/advertise/event06.jpg";
        }
        if (thisMonth == Month.JULY){
            eventName = "images/advertise/event07.jpg";
        }
        if (thisMonth == Month.AUGUST){
            eventName = "images/advertise/event08.jpg";
        }
        if (thisMonth == Month.SEPTEMBER){
            eventName = "images/advertise/event09.jpg";
        }
        if (thisMonth == Month.OCTOBER){
            eventName = "images/advertise/event10.jpg";
        }
        if (thisMonth == Month.NOVEMBER){
            eventName = "images/advertise/event11.jpg";
        }
        if (thisMonth == Month.DECEMBER){
            eventName = "images/advertise/event12.jpg";
        }
        return eventName;
    }
}