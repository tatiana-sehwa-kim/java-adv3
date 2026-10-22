package stream.colletors;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Collectors5Reducing {
    public static void main(String[] args) {

        List<String> names = List.of("a", "b", "c", "d");

        // 컬렉션의 리듀싱은 주로 다운 스트림에 활용
        // 모든 이름을 하나의 문자열로 이어 붙이기
        String joined1 = names.stream()
                .collect(Collectors.reducing(
                        (s1, s2) -> s1 + ", " + s2
                )).get();
        System.out.println("joined1 = " + joined1);     // joined1 = a, b, c, d

        String joined2 = names.stream()
                .reduce((a, b) -> a + ", " + b).get();      // get은 Optional 상자 속 String 값을 꺼내는 get()
        System.out.println("joined2 = " + joined2);     // joined2 = a, b, c, d

        // 문자열 전용 기능
        String joined3 = names.stream()
                .collect(Collectors.joining(", "));
        System.out.println("joined3 = " + joined3);         // joined3 = a, b, c, d

        // 위는 잘 쓰지않음. 왜냐면 String 문자 객체 자체에 있기 때문
        String joined4 = String.join(", ", "a", "b", "c", "d");
        System.out.println("joined4 = " + joined4);     // joined4 = a, b, c, d
    }
}
