package lambda.lambda4;

public class TriMain {  // 3개부터는 직접 만들어야

    public static void main(String[] args) {

        TriFunction<Integer, Integer, Integer, Integer> triFunction =
                (a,b,c) -> a + b + c ;
        System.out.println("triFunction.apply(1,5,3) = " + triFunction.apply(1, 5, 3));
    }

    @FunctionalInterface
    interface TriFunction<A, B, C, R> {
        R apply(A a, B b, C c);
    }
}
