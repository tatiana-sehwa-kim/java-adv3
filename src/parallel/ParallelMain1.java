package parallel;

import java.util.stream.IntStream;

import static util.MyLogger.*;

public class ParallelMain1 {
    public static void main(String[] args) {    // HeavyJob의 1~8 단일 작업

        long startTime = System.currentTimeMillis();

        int sum = IntStream.rangeClosed(1, 8)
                .map(HeavyJob::heavyTask)
                .reduce(0, Integer::sum);  // sum();

        long endTime = System.currentTimeMillis();

        log("time: " + (endTime - startTime) + "ms, sum: " + sum);

    }
}
//        15:27:03.155 [     main] calculate 1 -> 10
//        15:27:04.162 [     main] calculate 2 -> 20
//        15:27:05.164 [     main] calculate 3 -> 30
//        15:27:06.170 [     main] calculate 4 -> 40
//        15:27:07.175 [     main] calculate 5 -> 50
//        15:27:08.181 [     main] calculate 6 -> 60
//        15:27:09.186 [     main] calculate 7 -> 70
//        15:27:10.192 [     main] calculate 8 -> 80
//        15:27:11.201 [     main] time: 8067ms, sum: 360
//
//        8초는 너무 오래 걸린다. 스레드를 사용해서 실행 시간을 단축해보자.