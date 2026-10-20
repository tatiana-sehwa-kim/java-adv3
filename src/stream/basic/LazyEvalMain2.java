package stream.basic;

import lambda.lambda5.mystream.MyStreamV3;

import java.util.List;

public class LazyEvalMain2 {
    public static void main(String[] args) {

        List<Integer> data = List.of(1, 2, 3, 4, 5, 6);
        ex1(data);
        ex2(data);
    }

    private static void ex1(List<Integer> data) {
        System.out.println("== MyStreamV3 시작 ==");
        MyStreamV3.of(data)                         // 결과를 안받고, toList() 지우고
                .filter(i -> {
                    boolean isEven = i % 2 == 0;
                    System.out.println("filter() 실행: " + i + "(" + isEven + ")");
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.println("map() 실행" + i + " -> " + mapped);
                    return mapped;
                });
        System.out.println("== MyStreamV3 종료 ==");
    }

    private static void ex2(List<Integer> data) {
        System.out.println("== Stream API 시작 ==");
        data.stream()
                .filter(i -> {
                    boolean isEven = i % 2 == 0;
                    System.out.println("filter() 실행: " + i + "(" + isEven + ")");
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.println("map() 실행" + i + " -> " + mapped);
                    return mapped;
                });                                   // 최종연산 toList() 가 없음. 그럼 앞의값이 필요가없죠
        System.out.println("== Stream API 종료 ==");
    }
}

//    MyStreamV3는 만든것 (lamda5.mystream), 자바 Stream API는 인텔리제이 기본제공

//    == MyStreamV3 시작 ==             == Stream API 시작 ==
//    filter() 실행: 1(false)           == Stream API 종료 ==
//    filter() 실행: 2(true)
//    filter() 실행: 3(false)
//    filter() 실행: 4(true)
//    filter() 실행: 5(false)
//    filter() 실행: 6(true)
//    map() 실행2 -> 20
//    map() 실행4 -> 40
//    map() 실행6 -> 60
//    == MyStreamV3 종료 ==

//    즉시연산: 최종 연산과는 상관없이 필터 맵 실행    스트림 API 의 지연 연산: 실행은 최종연산이 호출되기 전까지는 진행되지 않는다
//            필요없는 로그가 남음                                       꼭 필요할때만 연산을 수행하도록 최대한 미룬다.