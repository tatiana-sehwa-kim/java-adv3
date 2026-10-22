package stream.colletors;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors2Basic {
    public static void main(String[] args) {

        Map<String, Integer> map1 = Stream.of("Apple", "Banana", "Tomato")      // map: 중복X
                .collect(Collectors.toMap(
                        name -> name,       // Key
                        name -> name.length()   // Value
                ));
        System.out.println("map1 = " + map1);   // map1 = {Apple=5, Tomato=6, Banana=6}
/*
        // 키 중복 예외: 키밸류 같으면 오류뜸
        Map<String, Integer> map2 = Stream.of("Apple", "Banana", "Banana", "Tomato")
                .collect(Collectors.toMap(
                        name -> name,
                        name -> name.length()
                ));
        System.out.println("map2 = " + map2);
 */
        // 키 중복 대안(병합)       셋째줄
        Map<String, Integer> map3 = Stream.of("Apple", "Banana", "Banana", "Tomato")
                .collect(Collectors.toMap(
                        name -> name,       // KeyMapper
                        name -> name.length(),     // ValueMapper
                        (oldVal, newVal) -> oldVal + newVal // 중복될 경우 기존값 + 새값
                ));
        System.out.println("map3 = " + map3);   // map3 = {Apple=5, Tomato=6, Banana=12}

        // Map의 타입 지정          넷째줄
        Map<String, Integer> map4 = Stream.of("Apple", "Banana", "Banana", "Tomato")
                .collect(Collectors.toMap(
                        name -> name,       // KeyMapper
                        name -> name.length(),     // ValueMapper
                        (oldVal, newVal) -> oldVal + newVal, // "중복될 경우" 기존값 + 새값
                        LinkedHashMap::new      // 타입지정
                ));
        System.out.println("map4 = " + map4);
    }
}
