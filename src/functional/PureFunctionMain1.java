package functional;

import java.util.function.Function;

public class PureFunctionMain1 {
    public static void main(String[] args) {

        // 순수 함수 : 입력값이 동일하면 항상 동일한 결과를 반환한다
        Function<Integer, Integer> func = x -> x * 2;
        System.out.println("result1 = " + func.apply(10));
        System.out.println("result2 = " + func.apply(10));
        System.out.println("result3 = " + func.apply(10));
    }
}
