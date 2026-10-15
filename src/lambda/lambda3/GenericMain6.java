package lambda.lambda3;

import static java.lang.Integer.parseInt;

public class GenericMain6 {
    public static void main(String[] args) {

        GenericFunction<String, String> toUpperCase = str -> str.toUpperCase();
        GenericFunction<String, Integer> stringLength = str -> str.length();
        GenericFunction<Integer, Integer> square = x -> x * x;
        GenericFunction<Integer, Boolean> isEven = num -> num % 2 == 0;

        System.out.println("toUpperCase.apply(\"hello\") = " + toUpperCase.apply("hello"));
        System.out.println("stringLength.apply(\"hello\") = " + stringLength.apply("hello"));
        System.out.println("square.apply(5) = " + square.apply(5));
        System.out.println("isEven.apply(33) = " + isEven.apply(33));
    }

    @FunctionalInterface
    interface GenericFunction<T, R> {   // 이거 하나로 다 통일
        R apply(T s);
    }
}
