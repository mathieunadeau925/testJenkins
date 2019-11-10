    package com.team3.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilDate {

    public static Date creerDate(int annee, int mois, int jour) {
        Calendar cal = Calendar.getInstance();
        cal.set(annee, mois, jour);
        Date date = cal.getTime();
        return date;
    }

    public static Date creerDateIso8601(String date) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date formattedDate = null;
        try {
            formattedDate = dateFormatter.parse(date);
        } catch (ParseException ex) {
            LoggerLocal.logErreur(ex);
        }
        return formattedDate;
    }
}
