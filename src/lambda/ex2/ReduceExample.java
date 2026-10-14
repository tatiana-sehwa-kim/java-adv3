package lambda.ex2;

import java.util.List;

public class ReduceExample {

    // 함수를 인자로 받아, 리스트 요소를 하나로 축약(reduce)하는 고차 함수
    public static int reduce(List<Integer> list, int initial, MyReducer reducer) {

        // 코드 작성
        int result = initial;
        for (Integer integer : list) {
            result = reducer.reduce(result, integer);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        System.out.println("리스트: " + numbers);

        // 1. 합 구하기 (초깃값 0, 덧셈 로직) // 코드 작성
        int sum = reduce(numbers, 0, (a, b) -> a + b);
        System.out.println("sum = " + sum);

        // 2. 곱 구하기 (초깃값 1, 곱셈 로직) // 코드 작성
        int multiply = reduce(numbers, 0, (a, b) -> a * b);
        System.out.println("multiply = " + multiply);
    }
}

//    여러 값을 계산해서 하나의 최종 값을 반환하는 경우 reduce(축약하다) , fold(접는다) 같은 단어를 사용한다.
