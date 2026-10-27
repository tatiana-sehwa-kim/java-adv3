package parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ParallelMain4 {
    public static void main(String[] args) {    // HeavyJob의 1~8 단일 작업
        int processorCount = Runtime.getRuntime().availableProcessors();    // 코어, 공용풀 개수 뽑아보기
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        log("processorCount = " + processorCount + ", commonPool = " + commonPool.getParallelism());

        long startTime = System.currentTimeMillis();

        int sum = IntStream.rangeClosed(1, 8)
                .parallel()     // 추가 : 내부적으로 최적화 자동 분할하여 병렬 처리
                .map(HeavyJob::heavyTask)
                .reduce(0, Integer::sum);  // sum();

        long endTime = System.currentTimeMillis();

        log("time: " + (endTime - startTime) + "ms, sum: " + sum);

    }
}
//        20:22:39.502 [     main] processorCount = 6, commonPool = 5
//        20:22:39.507 [     main] calculate 6 -> 60
//        20:22:39.507 [ForkJoinPool.commonPool-worker-1] calculate 3 -> 30     공용풀의 스레드가 실행
//        20:22:39.507 [ForkJoinPool.commonPool-worker-3] calculate 4 -> 40     여러 스레드가 병렬로 업무 처리
//        20:22:39.507 [ForkJoinPool.commonPool-worker-2] calculate 2 -> 20
//        20:22:39.507 [ForkJoinPool.commonPool-worker-4] calculate 8 -> 80
//        20:22:39.507 [ForkJoinPool.commonPool-worker-5] calculate 5 -> 50
//        20:22:40.508 [ForkJoinPool.commonPool-worker-1] calculate 1 -> 10
//        20:22:40.508 [     main] calculate 7 -> 70
//        20:22:41.511 [     main] time: 2005ms, sum: 360