package stream.colletors;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toUnmodifiableList;

public class Collectors1Basic {     // List, Set
    public static void main(String[] args) {        // 스태틱 임포트 권장

        // 기본 기능
        List<String> list = Stream.of("Java", "Spring", "JPA")
                .collect(Collectors.toList());  // 수정 가능 리스트를 반환
        list.add("hello");
        System.out.println("list = " + list);       // list = [Java, Spring, JPA, hello]
        
        // 수정 불가능 리스트
        List<Integer> unmodifiableList = Stream.of(1, 2, 3)
                .collect(toUnmodifiableList());
//        unmodifiableList.add(3);    런타임 예외
        System.out.println("unmodifiableList = " + unmodifiableList);       // unmodifiableList = [1, 2, 3]

        Set<Integer> set = Stream.of(1, 2, 2, 3, 3)        //set: 중복ㄴㄴ
                .collect(Collectors.toSet());
        System.out.println("set = " + set);     // set = [1, 2, 3]

        //타입 지정
        TreeSet<Integer> treeSet = Stream.of(3, 4, 5, 2, 1)
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println("treeSet = " + treeSet);             // treeSet = [1, 2, 3, 4, 5] 순서를 보고 정렬을 유지
    }
}
