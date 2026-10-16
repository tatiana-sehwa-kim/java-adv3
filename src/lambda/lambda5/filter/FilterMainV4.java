package lambda.lambda5.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static lambda.lambda5.filter.IntegerFilter.filter;

public class FilterMainV4 {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //짝수만 거르기
        List<Integer> evenNumbers = filter(numbers, num1 -> num1 % 2 == 0);     // alt enter 해서 import static의 filter
        System.out.println("evenNumbers = " + evenNumbers);

        //홀수만 거르기
        List<Integer> oddNumbers = filter(numbers, num -> num % 2 == 1);
        System.out.println("oddNumbers = " + oddNumbers);

    }
}
//    Integer 숫자에만 사용할 수 있는 한계가 있다. -> 제네릭 도입