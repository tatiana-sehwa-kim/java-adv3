package lambda.lambda4;

import java.util.function.Consumer;

public class ConsumerMain {
    public static void main(String[] args) {    // Consumer<T> : 하나의 매개변수를 받아서 소비(처리)만 하고, 반환값은 없다.

        //익명 클래스
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer1.accept("hello consumer");

        //람다
        Consumer<String> consumer2 = s -> System.out.println(s);
        consumer2.accept("hello consumer");
    }
}
