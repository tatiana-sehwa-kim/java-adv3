package functional;

import java.util.function.Function;

public class SideEffectMain1 {

    public static int count = 0;

    public static void main(String[] args) {
        System.out.println("before count = " + count);

        // 부수 효과(Side Effect)
        Function<Integer, Integer> func = x -> {
            count++;
            return x * 2;
        };

        func.apply(10);
        System.out.println("after count = " + count);
    }
}

//    이 예제에서는 함수가 count 라는 전역 변수를 변경하고 있다. 함수 호출 전후로 count 가 0에서 1로 바뀌는데,
//    이런 외부 상태 변화가 부수 효과의 대표적인 예시이다.
//    함수형 프로그래밍에서는 이러한 외부 상태 변경을 최소화하는 것을 권장한다.
