package parallel;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

import static util.MyLogger.log;

public class ParallelMain6 {
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

        // 1부터 4까지의 작업을 각각 스레드 풀에 제출
        Future<Integer> f1 = es.submit(() -> HeavyJob.heavyTask(1, requestName));
        Future<Integer> f2 = es.submit(() -> HeavyJob.heavyTask(2, requestName));
        Future<Integer> f3 = es.submit(() -> HeavyJob.heavyTask(3, requestName));
        Future<Integer> f4 = es.submit(() -> HeavyJob.heavyTask(4, requestName));

        int sum;
        try {
            Integer v1 = f1.get();
            Integer v2 = f2.get();
            Integer v3 = f3.get();
            Integer v4 = f4.get();
            sum = v1 + v2 + v3 + v4;
        } catch (Exception e) {     // 너무 상위 예외라 실무에선 비권장. 간단함을위해 상위예외
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " + sum);
    }
}
//    변경 사항
//
//    - 전용 로직 풀 추가
//        ExecutorService logicPool = Executors.newFixedThreadPool(400)
//        최대 400개의 스레드를 가진 별도의 풀을 생성해서 병렬 작업 처리에 사용한다.
//    - 병렬 스트림 대신 커스텀 스레드 풀 사용
//        병렬 스트림( parallel() )을 사용하지 않고, 직접 전용 스레드 풀에 작업을 제출한다. 각 작업이 별도의 Future 로 관리된다.
//    - 결과 취합 방식
//        Future.get() 을 사용하여 각 작업의 결과를 기다렸다가 취합한다.

//        실행 결과
//
//        - 일관된 처리 시간
//            모든 요청이 약 1초 내외로 처리되었다.
//            이전 예제에서 관찰된 요청별 처리 시간이 지연되는 문제가 해결되었다.
//        - 독립적인 스레드 할당
//            각 요청의 작업들이 전용 풀(pool-2-thread-N)에서 처리된다.
//            Fork/Join 공용 풀 스레드(ForkJoinPool.commonPool-worker-N)가 사용되지 않았다.
//        - 확장성 향상
//            400개의 스레드를 가진 풀을 사용함으로써, 동시에 여러 요청을 효율적으로 처리한다.
//            공용 풀 병목 현상이 발생하지 않았다.