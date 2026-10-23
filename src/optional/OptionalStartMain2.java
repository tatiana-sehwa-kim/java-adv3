package optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalStartMain2 {

    private static final Map<Long, String> map = new HashMap<>();

    static {
        map.put(1L, "Kim");     // long 타입 8바이트 숫자
        map.put(2L, "Seo");
    }

    public static void main(String[] args) {
        findAndPrint(1L);   // 값이 있는 경우
        findAndPrint(3L);   // 값이 없는 경우
    }

    // 이름이 있으면 이름을 대문자로 출력, 없으면 "UNKNOWN" 을 출력하라
    static void findAndPrint(Long id) {
        Optional<String> optName = findNameById(id);        // Optional로 한번 감싸서 반환
        String name = optName.orElse("UNKNOWN");
        System.out.println(id + " = " + name);

//        String name = findNameById(id).orElse("UNKNOWN");     // 이렇게 줄일수 있음 메서드 체이닝
//        System.out.println("name = " + name);

//            1 = Kim
//            3 = UNKNOWN
    }

    static Optional<String> findNameById(Long id) {
        String findName = map.get(id);
        Optional<String> optName = Optional.ofNullable(findName);
        return optName;
    }
}
//        Optional: 값을 하나 감싸는 컨테이너 객체
//        1. NullPointerException 예방
//        2. 해당 메서드가 비어있을 수 있음을 인지