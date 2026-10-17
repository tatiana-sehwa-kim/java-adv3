package lambda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

// static factory 정적 팩토리 추가
public class MyStreamV2 {

    private List<Integer> internalList;

    private MyStreamV2(List<Integer> internalList) {    // private로 막아버림. 이제 MyStreamV2 를 생성하려면 of() 메서드를 사용해야 한다.
        this.internalList = internalList;
    }
    
    // static factory
    public static MyStreamV2 of(List<Integer> internalList) {   // 정적 팩토리 추가
        return new MyStreamV2(internalList);
    }

    public MyStreamV2 filter(Predicate<Integer> predicate) {
        List<Integer> filtered = new ArrayList<>();
        for (Integer element : internalList) {
            if (predicate.test(element)) {
                filtered.add(element);
            }
        }
        return new MyStreamV2(filtered);
    }

    public MyStreamV2 map(Function<Integer, Integer> mapper) {
        List<Integer> mapped = new ArrayList<>();
        for (Integer element : internalList) {
            mapped.add(mapper.apply(element));
        }
        return new MyStreamV2(mapped);
    }

    public List<Integer> toList() {
        return internalList;
    }

}

//    객체를 생성해주는 정적 메서드를 스태틱 팩토리라고 한다.
//    생성자에 이름을 붙이지 못하는 한계를 보완하며, 객체 캐싱 또는 하위 타입 객체 반환 같은 유연한 로직을 적용할 수 있다.