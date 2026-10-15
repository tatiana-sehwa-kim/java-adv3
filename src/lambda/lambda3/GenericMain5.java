package lambda.lambda3;

public class GenericMain5 {
    public static void main(String[] args) {

        //문자열 넣어서 문자열 반환
        GenericFunction<String, String> upperCase = s -> s.toUpperCase();
        String result1 = upperCase.apply("hello");
        System.out.println("result1 = " + result1);

        GenericFunction<Integer, Integer> square = n -> n * n;
        Integer result2 = square.apply(3);
        System.out.println("result2 = " + result2);
    }

    @FunctionalInterface
    interface GenericFunction<T, R> {   // T: 매개변수 타입, R: 반환타입
        R apply(T s);
    }
}
