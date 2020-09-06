package practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class DateTimeFormatterDemo {

    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        TemporalAccessor parse = dateTimeFormatter.parse("2020-09-06 16:57:20");
        LocalDateTime parse = LocalDateTime.parse("2020-09-06 16:57:20", dateTimeFormatter);
        System.out.println(parse);

        LocalDateTime now = LocalDateTime.now();
        String format = dateTimeFormatter.format(now);
        System.out.println(format);


    }
}
