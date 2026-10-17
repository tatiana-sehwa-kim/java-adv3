package lambda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStreamV1 {

    private List<Integer> internalList;

    public MyStreamV1(List<Integer> internalList) {
        this.internalList = internalList;
    }

    public MyStreamV1 filter(Predicate<Integer> predicate) {
        List<Integer> filtered = new ArrayList<>();
        for (Integer element : internalList) {
            if (predicate.test(element)) {
                filtered.add(element);
            }
        }
        return new MyStreamV1(filtered);    // 담아서 반환. 뭘 바로바로 이어서 할수있게
    }

    public MyStreamV1 map(Function<Integer, Integer> mapper) {
        List<Integer> mapped = new ArrayList<>();
        for (Integer element : internalList) {
            mapped.add(mapper.apply(element));
        }
        return new MyStreamV1(mapped);      // 담아서 반환
    }

    public List<Integer> toList() {     // 내부의 데이터 리스트를 toList() 로 반환
        return internalList;
    }

//    새로 걸러낸 리스트(filtered)를 MyStreamV1이라는 상자(클래스) 안에 쏙 집어넣은 뒤, 그 상자 자체를 반환하고 있습니다.
//    왜 리스트를 그냥 안 주고 굳이 MyStreamV1으로 감싸서 리턴할까?
//    이유는 '메서드 체이닝(기차처럼 줄줄이 이어 붙이기)'을 가능하게 만들기 위해서입니다.
}
