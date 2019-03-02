package app;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) throws Exception {
        simpleDateTimeTest();
        dateTimeFormatterTest();
    }

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void simpleDateTimeTest() {
        long start = System.currentTimeMillis();

        System.out.println("Start convert use SimpleDateFormat");

        Date now = new Date();

        for (int i = 0; i < 100; i++) {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = format.format(now);
        }

        long duration = System.currentTimeMillis() - start;

        System.out.println("Duration use SimpleDateFormat:" + duration);
    }

    public static void dateTimeFormatterTest(){
        long start = System.currentTimeMillis();

        System.out.println("Start convert use DateFormatter");

        LocalDateTime now = LocalDateTime.now();

        for (int i = 0; i < 100; i++) {
            
            String time = dateTimeFormatter.format(now);
        }

        long duration = System.currentTimeMillis() - start;

        System.out.println("Duration use DateFormatter:" + duration);

    }

}