package stream.basic;

import java.util.List;
import java.util.stream.Stream;

public class DuplicateExecutionMain {
    public static void main(String[] args) {

        // 스트림 중복 실행 확인
        Stream<Integer> stream = Stream.of(1, 2, 3);        // "그냥 숫자 몇 개 스트림으로 가공해서 얼른 쓰고 버려야지" 할때
        stream.forEach(s -> System.out.println(s));     // 1. 최초 실행

//        오류 메시지 (IllegalStateException) 스트림이 이미 작동했거나 닫혔습니다.
//        stream.forEach(System.out::println);    // 2. 스트림 중복 실행X, 주석 풀면 예외 발생

        // 대안: 대상 리스트를 스트림으로 새로 생성해서 사용
        List<Integer> list = List.of(1, 2, 3);
        Stream.of(list).forEach(System.out::println);   // 최초 실행
        Stream.of(list).forEach(System.out::println);   // 중복 실행 가능: 원본은 변하지 않기때문에 스트림 객체를 새로 생성했다.

    }
}
    //            1
    //            2
    //            3
    //            [1, 2, 3]
    //            [1, 2, 3]