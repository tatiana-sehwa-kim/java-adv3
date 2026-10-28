package parallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ParallelMain5 {
    public static void main(String[] args) throws InterruptedException {

        // 병렬 수준 3으로 제한
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "3");    // 공용풀

        // 요청 풀 추가
        ExecutorService requestPool = Executors.newFixedThreadPool(100);    // 요청풀
        int nThreads = 3;   //1, 2, 3, 10, 20
        for (int i = 1; i < nThreads; i++) {    //  고객 요청이 3개 동시에 오면 루프를 3번 돈다고 치고(fori로직이 세번 돈다)
            String requestName = "request" + i;     // 요청의 이름
            requestPool.submit(() -> logic(requestName));
            Thread.sleep(100);  // 스레드 순서를 확인하기 위해 약간 대기
        }
        requestPool.close();
    }

    private static void logic(String requestName) {
        log("[" + requestName + "] START");
        long startTime = System.currentTimeMillis();

        int sum = IntStream.rangeClosed(1, 4)
                .parallel()         // 병렬로 처리
                .map(i -> HeavyJob.heavyTask(i, requestName))
                .reduce(0, (a, b) -> a + b);

        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " + sum);
    }
}

//    핵심 문제점 : 공용 풀은 반드시 CPU 바운드(계산 집약적인) 작업에만 사용해야 한다!
//    - 공용 풀 병목 현상: 모든 병렬 스트림이 동일한 공용 풀을 공유하므로, 요청이 많아질수록 병목 현상이 발생한다.
//    - 자원 경쟁: 여러 요청이 제한된 스레드 풀을 두고 경쟁하면서 요청의 성능이 저하된다.
//    - 예측 불가능한 성능: 같은 작업이라도 동시에 실행되는 다른 작업의 수에 따라 처리 시간이 크게 달라진다.

//    그렇다면 여러 작업을 병렬로 처리해야 하는데, I/O 바운드 작업이 많을 때는 어떻게 하면 좋을까?
//    이때는 스레드를 직 접 사용하거나, ExecutorService 등을 통해 별도의 스레드 풀을 사용해야 한다. -> 병렬스트림 주의점 2

