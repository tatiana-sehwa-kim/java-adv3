package lambda.lambda3;

public class GenericMain3 {
    public static void main(String[] args) {

        objectFunction upperCase = new objectFunction() {   //익명 클래스로 전환
            @Override
            public Object apply(Object s) {
                return ((String) s).toUpperCase();
            }
        };
        String result1 = (String) upperCase.apply("hello");
        System.out.println("result1 = " + result1);

        objectFunction square = new objectFunction() {
            @Override
            public Object apply(Object n) {
                return (Integer) n * (Integer) n;
            }
        };
        Integer result2 = (Integer) square.apply(3);
        System.out.println("result2 = " + result2);
    }

    @FunctionalInterface
    interface objectFunction {
        Object apply(Object s);
    }
}
