package stream.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MapVsFlatMapMain {     // FlatMap : 이중 구조 평탄화
    public static void main(String[] args) {

        List<List<Integer>> outerList = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6)
        );
        System.out.println("outerList = " + outerList);

        // for 로 평탄화
        List<Integer> forResult = new ArrayList<>();
        for (List<Integer> list : outerList) {
            for (Integer i : list) {
                forResult.add(i);
            }
        }
        System.out.println("forResult = " + forResult);

        // map  스트림 안에 스트림 3개의 구조
        List<Stream<Integer>> mapResult = outerList.stream()
                .map(list -> list.stream())
                .toList();
        System.out.println("mapResult = " + mapResult);

        // flatMap  평탄화 flatten
        List<Integer> flatMapResult = outerList.stream()
                .flatMap(list -> list.stream())
                .toList();
        System.out.println("flatMapResult = " + flatMapResult);
    }
}
//    outerList = [[1, 2], [3, 4], [5, 6]]
//    forResult = [1, 2, 3, 4, 5, 6]
//    mapResult = [java.util.stream.ReferencePipeline$Head@3a71f4dd,
//                    java.util.stream.ReferencePipeline$Head@7adf9f5f,
//                    java.util.stream.ReferencePipeline$Head@85ede7b]
//    flatMapResult = [1, 2, 3, 4, 5, 6]