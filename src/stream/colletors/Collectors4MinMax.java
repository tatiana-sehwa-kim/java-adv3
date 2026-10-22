package stream.colletors;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collectors4MinMax {
    public static void main(String[] args) {

        // 다운스트림 컬렉터에서 유용하게 사용 (다음진도)
        Integer max1 = Stream.of(1, 2, 3)
                .collect(Collectors.maxBy(
                        (i1, i2) -> i1.compareTo(i2)
                )).get();
        System.out.println("max1 = " + max1);       // max1 = 3

        Integer max2 = Stream.of(1, 2, 3)
                .max((i1, i2) -> i1.compareTo(i2)).get();
        System.out.println("max2 = " + max2);       // max2 = 3

        Integer max3 = Stream.of(1, 2, 3)
                .max(Integer::compareTo).get();     // 메서드 참조
        System.out.println("max3 = " + max3);       // max3 = 3

        // 기본형 특화 스트림 사용
        int max4 = IntStream.of(1, 2, 3)
                .max().getAsInt();
        System.out.println("max4 = " + max4);       // max4 = 3
    }
}
