package com.michaelloi.common.models.utilities;

import com.michaelloi.common.constants.LanguageValues;
import com.michaelloi.common.constants.Locales;
import com.michaelloi.common.constants.TimeZones;
import org.springframework.context.i18n.LocaleContextHolder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateConversion {
    public static String toString(
        Date date,
        String pattern
    ) {
        Locale locale = LocaleContextHolder.getLocale();
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, locale);
        return dateFormat.format(date);
    }

    public static String toString(
        String language,
        Date date,
        String pattern
    ) {
        Locale locale = language.equalsIgnoreCase(LanguageValues.enLanguage)
            ? Locales.english
            : Locales.indonesia;
        TimeZone zone = TimeZone.getTimeZone(TimeZones.jakarta);
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, locale);
        dateFormat.setTimeZone(zone);
        return dateFormat.format(date);
    }

    public static Date toDate(
        String date,
        String pattern
    ) throws ParseException {
        Locale locale = LocaleContextHolder.getLocale();
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, locale);
        return dateFormat.parse(date);
    }

    public static String convert(
        String date,
        String oldDateFormat,
        String dateFormat
    ) {
        DateTimeFormatter oldFormatter = DateTimeFormatter.ofPattern(oldDateFormat);
        LocalDate localDate = LocalDate.parse(date, oldFormatter);
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneOffset.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return zonedDateTime.format(formatter);
    }
}
