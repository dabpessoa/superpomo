package com.atma.superpomo.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by diego.pessoa on 26/01/2017.
 */
public class DateUtils {

    public static enum TimeType {
        SECOND, MINUTE, HOUR;
    }

    public static boolean isZeroTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.HOUR) == 0 && c.get(Calendar.MINUTE) == 0 && c.get(Calendar.SECOND) == 0;
    }

    public static Date addSecond(Date date, int amount) {
        return addTime(date, amount, TimeType.SECOND);
    }

    public static Date addMinute(Date date, int amount) {
        return addTime(date, amount, TimeType.MINUTE);
    }

    public static Date addHour(Date date, int amount) {
        return addTime(date, amount, TimeType.HOUR);
    }

    private static Date addTime(Date date, int amount, TimeType timeType) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        switch (timeType) {
            case SECOND: {
                c.add(Calendar.SECOND, amount);
                break;
            }
            case MINUTE: {
                c.add(Calendar.MINUTE, amount);
                break;
            }
            case HOUR: {
                c.add(Calendar.HOUR, amount);
                break;
            }
        }
        return c.getTime();
    }

}
