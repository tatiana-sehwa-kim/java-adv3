package functional;

import java.util.function.Function;

public class SideEffectMain2 {

    public static void main(String[] args) {

        Function<Integer, Integer> func = x -> {
            int result = x * 2;

            // 부수 효과(Side Effect)
            System.out.println("x = " + x + ", result = " + (x * 2));
            return result;
        };

        func.apply(10);
    }
}
//    x = 10, result = 20
//
//    이 예제에서는 콘솔에 출력을 하는 동작이 부수 효과이다. 출력은 결과값 자체와 무관하지만,
//    외부 세계(콘솔)에 영향을 미치므로 순수 함수로 보기는 어렵다.

