package stream.basic;

import lambda.lambda5.mystream.MyStreamV3;

import java.util.List;

public class LazyEvalMain3 {
    public static void main(String[] args) {

        List<Integer> data = List.of(1, 2, 3, 4, 5, 6);
        ex1(data);
        ex2(data);
    }

    private static void ex1(List<Integer> data) {
        System.out.println("== MyStreamV3 시작 ==");
        Integer result = MyStreamV3.of(data)
                .filter(i -> {
                    boolean isEven = i % 2 == 0;
                    System.out.println("filter() 실행: " + i + "(" + isEven + ")");
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.println("map() 실행" + i + " -> " + mapped);
                    return mapped;
                })
                .getFirst();            // MyStreamV3 추가
        System.out.println("result = " + result);
        System.out.println("== MyStreamV3 종료 ==");
    }

    private static void ex2(List<Integer> data) {
        System.out.println("== Stream API 시작 ==");
        Integer result = data.stream()
                .filter(i -> {
                    boolean isEven = i % 2 == 0;
                    System.out.println("filter() 실행: " + i + "(" + isEven + ")");
                    return isEven;
                })
                .map(i -> {
                    int mapped = i * 10;
                    System.out.println("map() 실행" + i + " -> " + mapped);
                    return mapped;
                })
                .findFirst().get();           // 자바 기본 제공 기능 첫번째값 findFirst().get();
        System.out.println("result = " + result);
        System.out.println("== Stream API 종료 ==");
    }
}

//    == MyStreamV3 시작 ==             == Stream API 시작 ==
//    filter() 실행: 1(false)           filter() 실행: 1(false)
//    filter() 실행: 2(true)            filter() 실행: 2(true)
//    filter() 실행: 3(false)           map() 실행2 -> 20
//    filter() 실행: 4(true)            result = 20
//    filter() 실행: 5(false)           == Stream API 종료 ==
//    filter() 실행: 6(true)
//    map() 실행2 -> 20
//    map() 실행4 -> 40
//    map() 실행6 -> 60
//    result = 20
//    == MyStreamV3 종료 ==

//    모든 요소 실행 후 첫번째값(0) 꺼냄    첫번째값 나오자마자 종료(효율적)
//
//    단축 평가: 조건을 만족하는 결과를 찾으면 연산을 진행하지 않음-
//             지연 연산과 파이프라인 방식 때문에 가능