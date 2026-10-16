package lambda.lambda5.mystream;

import lambda.lambda5.filter.GenericFilter;
import lambda.lambda5.map.GenericMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ex1_Number {
    public static void main(String[] args) {
        // 짝수만 남기고, 남은 값의 2배를 반환
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> directResult = direct(numbers);
        System.out.println("directResult = " + directResult);

        List<Integer> lambdaResult = lambda(numbers);
        System.out.println("lambdaResult = " + lambdaResult);
    }

    static List<Integer> direct(List<Integer> numbers) {
        // TODO 코드 작성
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {            // for문과 if 문 일일히 프로그래밍 (명령형 프로그래밍)
            if (number % 2 == 0) {
                result.add(number * 2);
            }
        }
        return result;
    }
    static List<Integer> lambda(List<Integer> numbers) {
        // TODO 코드 작성
        List<Integer> filtered = GenericFilter.filter(numbers, n -> n % 2 == 0);    // 짝수 필터
        List<Integer> mapped = GenericMapper.map(filtered, n -> n * 2);         // 2배 매핑    (선언적  프로그래밍)
        return mapped;
    }
}