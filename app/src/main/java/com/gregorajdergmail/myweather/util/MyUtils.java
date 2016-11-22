package com.gregorajdergmail.myweather.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MyUtils {

    public static String convertDate(long dt) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dt * 1000);
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy EEEE", Locale.getDefault());
        return date.format(calendar.getTime() );
    }

    public static String convertTemperature(Double morn) {

        return null;
    }
}
