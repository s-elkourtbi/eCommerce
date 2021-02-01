package com.poke.eCommerce.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    /**
     * Get current date formated.
     * @return
     */
    public static Date getCurrentDate() {
        long time = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultdate = new Date(time);
        return resultdate;
    }
}
