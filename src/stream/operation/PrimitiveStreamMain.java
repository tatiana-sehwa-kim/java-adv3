package stream.operation;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreamMain {
    public static void main(String[] args) {

        //            IntStream이란?: 순수 int 숫자들만 전문으로 다루는 고속 숫자 전용 스트림.
        //            리스트가 없는 이유: 리스트라는 상자에 담아둘 필요 없이, "1부터 100까지 숫자 레일 즉석 가동!"(range) 해서 계산만 쏙 뽑아먹고 끝내려고.
        //            용도: 복잡한 람다식 대신 .sum(), .average() 같은 수학 메서드를 한 줄로 편하게 쓰려고.
        //            복잡하게 리스트 만들지 않고 숫자 계산 편하게 하려고 자바가 따로 파둔 숫자 전용 치트키

        // 기본형 특화 스트림 생성(IntStream, LongStream, DoubleStream) :
        IntStream stream = IntStream.of(1, 2, 3, 4, 5);
        stream.forEach(i -> System.out.print(i + " "));     // 1 2 3 4 5
        System.out.println();

        // 범위 생성 메서드(IntStream, LongStream)
        IntStream range1 = IntStream.range(1, 6);   // [1,2,3,4,5]  마지막 값 미포함
        IntStream range2 = IntStream.rangeClosed(1, 5);     // [1,2,3,4,5]  마지막 값 포함
        
        // 1. 통계 관련 메서드(sum,average, min, max, count)
        int sum = IntStream.range(1, 6).sum();  // 1~5
        System.out.println("sum = " + sum);     // 15

        // average(): 평균값 계산
        double avg = IntStream.range(1, 6)
                .average()
                .getAsDouble();             // 옵셔널 더블 그리고 더블로 겟
        System.out.println("avg = " + avg); // 3.0

        // summaryStatistics(): 한 번 훑으면서 모든 통계를 계산해 장부에 적음
        // IntSummaryStatistics{count=5, sum=15, min=1, average=3.000000, max=5}한 줄만 쳐봐도 내부 정보가 이렇게 깔끔하게 요약되어 찍힙니다
        IntSummaryStatistics stats = IntStream.range(1, 6)
                .summaryStatistics();
        System.out.println("합계: " + stats.getSum());
        System.out.println("평균: " + stats.getAverage());
        System.out.println("최대값: " + stats.getMax());
        System.out.println("최솟값: " + stats.getMin());
        System.out.println("개수: " + stats.getCount());

        // 2. 타입 변환 메서드
        // IntStream -> LongStream
        LongStream longStream = IntStream.range(1, 5).asLongStream();
        // IntStream -> DoubleStream
        DoubleStream doubleStream = IntStream.range(1, 5).asDoubleStream();

        // IntStream -> Stream<Integer>
        Stream<Integer> boxedStream = IntStream.range(1, 5).boxed();

        // 3. 기본형 특화 매핑
        // int -> long 변환 매핑
        IntStream.range(1, 5)
                .mapToLong(i -> i * 10L);        // map을 Long으로반환

        // int -> double
        DoubleStream mappedDouble = IntStream.range(1, 5)       // double로 변환
                .mapToDouble(i -> i * 10.0);

        // int -> 객체 변환 매핑(Obj) map을 쓰면서 바로 바꿔버리는것
        Stream<String> mappedObj = IntStream.range(1, 5)
                .mapToObj(i -> "Number: " + i);

        // 4. 객체 스트림 -> 기본형 특화 스트림으로 매핑
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);   // integerStream 은 객체라서 sum() 같은게 안됨.
        IntStream intStream = integerStream.mapToInt(i -> i);       // 그래서 integerStream을 intStream 으로 변환
        intStream.sum();

        // 5. 객체 스트림 -> 기본형 특화 스트림으로 매핑 활용
        int result = Stream.of(1, 2, 3, 4, 5)       // Stream.of() 는 1~5라는 숫자가 흘러가는 일회용 파이프를 즉석에서 짠 것
                .mapToInt(i -> i)
                .sum();
        System.out.println("result = " + result);
        // mapToInt: 포장지를 뜯고 순수 숫자 레일(IntStream)로 갈아타서 .sum(), .average()를 쓰기 위해 타는 환승역이다.
    }
}

//    기본형 특화 스트림(IntStream, LongStream, DoubleStream) 을 이용하면 숫자 계산(합계, 평균, 최대·최 소 등)을 간편하게 처리하고,
//    박싱/언박싱 오버헤드를 줄여 성능상의 이점도 얻을 수 있다.
//    range(), rangeClosed() 같은 메서드를 사용하면 범위를 쉽게 다룰 수 있어 반복문 대신에 자주 쓰인다.
//    mapToXxx , boxed() 등의 메서드를 잘 활용하면 객체 스트림과 기본형 특화 스트림을 자유롭게 오가며 다양 한 작업을 할 수 있다.
//    summaryStatistics() 를 이용하면 합계, 평균, 최솟값, 최댓값 등 통계 정보를 한 번에 구할 수 있어 편리합 니다.
