package lambda.lambda4;

import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateMain {
    public static void main(String[] args) {

        Predicate<Integer> predicate1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer value) {
                return value % 2 == 0;
            }
        };
        System.out.println("predicate1.test(10) = " + predicate1.test(10));

        Predicate<Integer> predicate2 = value -> value % 2 == 0;
        System.out.println("predicate2.test(33) = " + predicate2.test(10));

        Function<Integer, Boolean> function = value -> value % 2 == 0;  // 펑션으로도 대체 가능 but true/false 명시적으로 드러내기 위함
        System.out.println("function.apply(10) = " + function.apply(10));   // 조건검사인걸 티내기 위해 Predicate를 쓴다. 가독성 + 유지보수성
    }
}
