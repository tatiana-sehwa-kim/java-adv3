package lambda.lambda4;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class OperatorMain {
    public static void main(String[] args) {

        //UnaryOperator
        Function<Integer, Integer> square1 = x -> x * x;
        UnaryOperator<Integer> square2 = x -> x * x;    // 입력값(1개)과 반환값 형식이 같다
        System.out.println("square1 = " + square1.apply(3));
        System.out.println("square2 = " + square2.apply(3));

        //BinaryOperator
        BiFunction<Integer, Integer, Integer> addition1 = (a, b) -> a + b;  // 입력값 3개
        BinaryOperator<Integer> addition2 = (a, b) -> a + b;                // 가독성 향상
        System.out.println("addition1.apply(2,3) = " + addition1.apply(2, 3));
        System.out.println("addition2.apply(2,3) = " + addition2.apply(2, 3));
    }
}
