package helpers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Generators {

    public static int randomNumberBetween(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public static int[] randomNumberBetweenArray(int index, int min, int max) {
        int[] array = new int[index];
        for (int i = 0; i < index; i++) {
            array[i] = randomNumberBetween(min, max);
        }
        return array;
    }

    public static ZonedDateTime convertDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate.atStartOfDay(ZoneId.of("Europe/Moscow"));
    }

    public static String convertDate(ZonedDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
    
    public static String getStartDate(String startOfTheSeason, String endOfTheSeason) {
        ZonedDateTime start = convertDate(startOfTheSeason);
        ZonedDateTime end = convertDate(endOfTheSeason);
        ZonedDateTime now = ZonedDateTime.now();
        if (now.isAfter(end)) {
            return convertDate(start.plusYears(1));
        }
        if (now.isBefore(start)) {
            return convertDate(start);
        }
        if (!end.isAfter(now.plusDays(3))) {
            return convertDate(end);
        }
        return convertDate(now.plusDays(3));
    }

    public static String getEndDate(String startOfTheSeason, String endOfTheSeason) {
        ZonedDateTime start = convertDate(startOfTheSeason);
        ZonedDateTime end = convertDate(endOfTheSeason);
        ZonedDateTime now = ZonedDateTime.now();
        if (now.isAfter(end)) {
            return convertDate(start.plusYears(1).plusDays(3));
        }
        if (now.isBefore(start)) {
            return convertDate(start.plusDays(3));
        }
        if (!end.isAfter(now.plusDays(6))) {
            return convertDate(end);
        }
        return convertDate(now.plusDays(6));
    }
}
