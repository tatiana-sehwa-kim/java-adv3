package lambda.lambda1;

public class LambdaSimple4 {
    public static void main(String[] args) {

        MyCall call1 = (int value) -> value * 2;    // 기본
        MyCall call2 = (value) -> value * 2;    // 타입 추론
        MyCall call3 = value -> value * 2;    // 매개변수가 1개일때!!! () 생략 가능

        System.out.println("call3 = " + call3.call(10));
    }

    interface MyCall {      // 인터페이스 여기서만쓸꺼라 여기에 생성
        int call(int value);
    }
}
