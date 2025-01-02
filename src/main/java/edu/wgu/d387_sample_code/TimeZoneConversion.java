package edu.wgu.d387_sample_code;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
public class TimeZoneConversion {

    public static String convertTimeZones() {

        ZoneId zEastern = ZoneId.of("America/New_York");
        ZoneId zMountain = ZoneId.of("America/Denver");
        ZoneId zUTC = ZoneId.of("UTC");

        LocalDateTime localDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

        // Eastern Time
        ZonedDateTime easternTime = localDateTime.atZone(ZoneId.systemDefault()).withZoneSameInstant(zEastern);
        String easternFormatted = easternTime.format(formatter) + " ET";

        // Mountain Time
        ZonedDateTime mountainTime = easternTime.withZoneSameInstant(zMountain);
        String mountainFormatted = mountainTime.format(formatter) + " MT";

        // UTC
        ZonedDateTime utcTime = easternTime.withZoneSameInstant(zUTC);
        String utcFormatted = utcTime.format(formatter) + " UTC";

        return "{ \"Eastern\": \"" + easternFormatted + "\", \"Mountain\": \"" + mountainFormatted + "\", \"UTC\": \"" + utcFormatted + "\" }";

    }

}
