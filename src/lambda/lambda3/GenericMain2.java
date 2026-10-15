package lambda.lambda3;

public class GenericMain2 {
    public static void main(String[] args) {

        objectFunction upperCase = s -> ((String)s).toUpperCase();      // toUpperCase 적용 위해 String으로 다운캐스팅
        String result1 = (String) upperCase.apply("hello");            // String으로 강제 다운캐스팅
        System.out.println("result1 = " + result1);

        objectFunction square = n -> (Integer)n * (Integer)n;
        Integer result2 = (Integer) square.apply(3);
        System.out.println("result2 = " + result2);
    }

    @FunctionalInterface
    interface objectFunction {
        Object apply(Object s);         // Object를 써서 안전하지 않다. 다운캐스팅과 타입 안전성 문제
    }
}
