package util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class MyLogger {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static void log(Object obj) {        // 로그를 남기는 메서드. 현재 시간, 스레드 이름, 그리고 전달받은 객체를 로그로 출력한다.
        String time = LocalTime.now().format(formatter);
        System.out.printf("%s [%9s] %s\n", time,
            Thread.currentThread().getName(), obj);
    }
}