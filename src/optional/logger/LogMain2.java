package optional.logger;

public class LogMain2 {

    public static void main(String[] args) {

        Logger logger = new Logger();
        logger.setDebug(true);
        logger.debug(value100() + value200());      // [DEBUG] 300

        System.out.println("=== 디버그 모드 끄기 ===");
        logger.setDebug(false);
        logger.debug(value100() + value200());        // 2. 필요없는 연산이 추가되지만 코드는 깔끔

        // 코드 마지막에 추가
        System.out.println("=== 디버그 모드 체크 ===");
        if (logger.isDebug()) {     // false
            logger.debug(value100() + value200());    // 1. if 문을 통한 확실한 체크, 코드는 지저분해지지만, 필요 없는 연산 수행X
        }
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

//    2번과 같은 방식으로 깔끔하지만 미래에 사용하지 않을 연산이 미리 수행되지 않도록 하는 방법은 없을까?
//    2번의 코드의 깔끔함과 1번의 필요 없는 연산은 수행하지 않는 둘의 장점만 가져오는 방법은 없을까?

//    이렇게 하려면 100 + 200 , value100() + value200() 같은 연산을 정의하는 시점과 해당 연산을 실행하는 시 점을 분리해야 한다.
//    그래서 연산의 실행을 최대한 지연해서 평가(계산)해야 한다.