package lambda.lambda4;

import java.util.function.Function;

public class FunctinMain {
    public static void main(String[] args) {    // Function<T, R> : 하나의 매개변수를 받아 결과를 반환한다.

        //익명 클래스
        Function<String, Integer> function1 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        System.out.println("function1 = " + function1.apply("hello"));

        // 람다
        Function<String, Integer> function2 = s -> s.length();
        System.out.println("function2 = " + function2.apply("hello"));
    }
}
