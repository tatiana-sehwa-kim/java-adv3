package optional;

import java.util.HashMap;
import java.util.Map;

public class OptionalStartMain1 {

    private static final Map<Long, String> map = new HashMap<>();

    static {
        map.put(1L, "Kim");     // long 타입 8바이트 숫자
        map.put(2L, "Seo");
    }   // 클래스가 로딩될 때 이 코드 블록 안의 실행문들을 딱 한 번만 실행해서 map을 완성해 줘!라고 자바에게 맡기는 구역이 바로 static { } 블록

    public static void main(String[] args) {
        findAndPrint(1L);   // 값이 있는 경우     name = KIM
        findAndPrint(3L);   // 값이 없는 경우     NullPointerException
    }

    // 이름이 있으면 이름을 대문자로 출력, 없으면 "UNKNOWN" 을 출력하라
    static void findAndPrint(Long id) {
        String name = findNameById(id);
//        System.out.println("name = " + name.toUpperCase());
//        1. 값이 null일 경우 NullPointerException 유발

        // 2. if 문을 활용한 null 체크
        if (name != null) {
            System.out.println(id + " = "  + name);
        } else {
            System.out.println(id + " = UNKNOWN");
        }
//            1 = Kim
//            3 = UNKNOWN
    }

    // 위값을들 탐색하는 기능
    static String findNameById(Long id) {
        return map.get(id);
    }
}
