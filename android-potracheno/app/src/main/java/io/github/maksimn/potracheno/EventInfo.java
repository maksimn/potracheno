package io.github.maksimn.potracheno;

import java.util.Calendar;
import java.util.Date;

public class EventInfo {
    public String name;
    public Date date;
    public int persons;

    public String dateToFormattedString() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        return dayOfMonth + " " + getMonthRusName(month) + ", " + getDayOfWeekRusName(dayOfWeek);
    }

    private String getMonthRusName(int month) {
        switch (month) {
            case 0: return "января";
            case 1: return "февраля";
            case 2: return "марта";
            case 3: return "апреля";
            case 4: return "мая";
            case 5: return "июня";
            case 6: return "июля";
            case 7: return "августа";
            case 8: return "сентября";
            case 9: return "октября";
            case 10: return "ноября";
            case 11: return "декабря";
        }
        return null;
    }

    private String getDayOfWeekRusName(int dayOfWeek) {
        switch (dayOfWeek) {
            case 0: return "понедельник";
            case 1: return "вторник";
            case 2: return "среда";
            case 3: return "четверг";
            case 4: return "пятница";
            case 5: return "суббота";
            case 6: return "воскресенье";
        }
        return null;
    }

}