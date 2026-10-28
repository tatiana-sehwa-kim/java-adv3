package parallel;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ParallelMain7 {
    public static void main(String[] args) throws InterruptedException {

        // 요청 풀 추가
        ExecutorService requestPool = Executors.newFixedThreadPool(100);    // 요청풀

        // logic 처리 전용 스레드 풀 추가 )400개 정도 할수 있는 고정 스레드 풀 만들기_
        ExecutorService logicPool = Executors.newFixedThreadPool(400);


        int nThreads = 3;   //1, 2, 3, 10, 20
        for (int i = 1; i < nThreads; i++) {    //  고객 요청이 3개 동시에 오면 루프를 3번 돈다고 치고(fori로직이 세번 돈다)
            String requestName = "request" + i;     // 요청의 이름
            requestPool.submit(() -> logic(requestName, logicPool));
            Thread.sleep(100);  // 스레드 순서를 확인하기 위해 약간 대기
        }
        requestPool.close();
        logicPool.close();
    }

    private static void logic(String requestName, ExecutorService es) {
        log("[" + requestName + "] START");
        long startTime = System.currentTimeMillis();

        // 1부터 4까지의 작업을 각각 스레드 풀에 제출(수정)
        List<Future<Integer>> futures = IntStream.range(1, 4)
                .mapToObj(i -> es.submit(() -> HeavyJob.heavyTask(i, requestName)))
                .toList();

        int sum = futures.stream()
                .mapToInt(f -> {    // 람다 사용하는 대부분의 기능들이 체크예외를 던질수없게 설계되어 잡아서 처리하거나 해야함
                    try {
                        return f.get();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }).sum();

        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " + sum);
    }
}

//        22:53:50.669 [pool-1-thread-1] [request1] START
//        22:53:50.678 [pool-2-thread-3] [request1] 3 -> 30
//        22:53:50.678 [pool-2-thread-2] [request1] 2 -> 20
//        22:53:50.678 [pool-2-thread-1] [request1] 1 -> 10
//        22:53:50.755 [pool-1-thread-2] [request2] START
//        22:53:50.755 [pool-2-thread-4] [request2] 1 -> 10
//        22:53:50.756 [pool-2-thread-5] [request2] 2 -> 20
//        22:53:50.756 [pool-2-thread-6] [request2] 3 -> 30
//        22:53:51.684 [pool-1-thread-1] time: 1010ms, sum: 60
//        22:53:51.757 [pool-1-thread-2] time: 1002ms, sum: 60