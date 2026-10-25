package optional;

import java.util.Optional;
import java.util.Random;

public class OrElseGetMain {
    public static void main(String[] args) {

        Optional<Integer> optValue = Optional.of(100);
        Optional<Integer> optEmpty = Optional.empty();

        System.out.println("단순 계산");
        Integer i1 = optValue.orElse(10 + 20);  // 10 + 20 계산 후 버림
        Integer i2 = optEmpty.orElse(10 + 20);  // 10 + 20 계산 후 사용

        System.out.println("i1 = " + i1);   // i1 = 100
        System.out.println("i2 = " + i2);   // i2 = 30

            // 값이 있으면 그 값, 없으면 지정된 기본값 사용
        System.out.println("=== orElse ===");
        System.out.println("값이 있는 경우");
        Integer value1 = optValue.orElse(createData());
        System.out.println("value1 = " + value1);

        System.out.println("값이 없는 경우");
        Integer empty1 = optEmpty.orElse(createData());
        System.out.println("empty1 = " + empty1);
            // 있어도 생성, 없어도 생성 createData(). "빈 값이면 other" 에서 other을 "항상" 미리 계산한다. "즉시 평가"

            // 값이 있으면 그 값, 없으면 지정된 람다 사용 Supplier
        System.out.println("=== orElse ===");
        System.out.println("값이 있는 경우");
        Integer value2 = optValue.orElseGet(() -> createData());    // OrElseGetMain::createData
        System.out.println("value2 = " + value2);

        System.out.println("값이 없는 경우");
        Integer empty2 = optEmpty.orElseGet(() -> createData());
        System.out.println("empty2 = " + empty2);
            // 있으면 그 값, 없으면 creatdData() 생성. 값이 있을 때는 supplier가 호출되지 않는다. "지연 평가"
            // 생성 비용이 높은 객체를 다룰 때는 orElseGet()이 더 효율적이다.
    }

    static int createData() {      // 3초 정도 걸리는 엄청나게 큰 작업 예시
        System.out.println("데이터를 생성합니다...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int createValue = new Random().nextInt(100);
        System.out.println("데이터 생성이 완료되었습니다. 생성 값: " + createValue);
        return createValue;
    }
}

//    단순한 대체 값을 전달하거나 코드가 매우 간단하다면 orElse() 를 사용하고, 객체 생성 비용이 큰 로직이 들어있고,
//    Optional에 값이 이미 존재할 가능성이 높다면 orElseGet() 을 고려해볼 수 있다.
