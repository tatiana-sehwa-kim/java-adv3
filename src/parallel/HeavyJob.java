package parallel;

import util.MyLogger;

public class HeavyJob {

    public static int heavyTask(int i) {    // 무거운 작업
        MyLogger.log("calculate " + i + " -> " + i * 10);   // i에 10을 곱하는 거지만 엄청 무겁다고 가정
        try {
            Thread.sleep(1000);     // 1,000밀리초(= 딱 1초) 동안 강제 일시정지
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return i * 10;
    }

    public static int heavyTask(int i, String name) {    // 추가적인 정보를 더 남겨주는 것
        MyLogger.log("[" + name +"] " + i + " -> " + i * 10);   //
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return i * 10;
    }
}
