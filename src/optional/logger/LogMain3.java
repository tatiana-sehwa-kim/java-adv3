package optional.logger;

public class LogMain3 {

    public static void main(String[] args) {

        Logger logger = new Logger();       // 괄호를 람다로
        logger.setDebug(true);
        logger.debug(() -> value100() + value200());

        System.out.println("=== 디버그 모드 끄기 ===");
        logger.setDebug(false);
        logger.debug(() -> value100() + value200());    // 호출되지 않음

    }

    static int value100() {
        System.out.println("value100 호출");
        return 100;
    }

    static int value200() {
        System.out.println("value200 호출");
        return 200;
    }
}
