package day10;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class TimeExam {
    public static void main(String[] args) {
        LocalTime time=LocalTime.now();
        System.out.println(time);

        LocalDate date=LocalDate.now();
        System.out.println(date);

        System.out.println(LocalDateTime.now());

        ZonedDateTime now=ZonedDateTime.now();
        System.out.println(now);

        //포맷팅해서 날짜값 출력
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss z");
        System.out.println(now.format(formatter));

        ZonedDateTime nowInNewYork = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("현재 시간(뉴욕): " + nowInNewYork);

    }
}
