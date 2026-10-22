package stream.colletors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collectors3Group {
    public static void main(String[] args) {

        // 첫 글자 알파벳 기준으로 그룹화
        List<String> names = List.of("Apple", "Avocado", "Banana", "Blueberry", "Cherry");
        Map<String, List<String>> grouped = names.stream()
                .collect(Collectors.groupingBy(name -> name.substring(0, 1)));  // 맨첫번째글자(substring) 기준으로 모아줘(groupingBy)
        System.out.println("grouped = " + grouped);     // grouped = {A=[Apple, Avocado], B=[Banana, Blueberry], C=[Cherry]}

        // 짝수(even) 인지 여부로 분할(파티셔닝)
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("partitioned = " + partitioned);         // partitioned = {false=[1, 3, 5], true=[2, 4, 6]}
    }
}
