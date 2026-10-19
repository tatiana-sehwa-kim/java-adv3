package stream.basic;

import java.util.List;

public class ImmutableMain {
    public static void main(String[] args) {

        List<Integer> originList = List.of(1, 2, 3, 4);     // 원본 리스트
        System.out.println("originList = " + originList);

        List<Integer> filteredList = originList.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println("filteredList = " + filteredList);   // 스트림 리스트
        System.out.println("originList = " + originList);       // 원본 리스트는 바뀌지 않는다
    }
}
