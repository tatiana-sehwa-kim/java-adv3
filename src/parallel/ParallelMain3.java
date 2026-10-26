package parallel;

import java.util.concurrent.*;

import static util.MyLogger.log;

// 2에서는 직접 다 만들었는데 여기서는 만들어진거 쓰기
public class ParallelMain3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // 스레드 풀을 준비한다. = 자바 제공 인력풀
        ExecutorService es;    // 고정된 스레드 풀 2개
        es = Executors.newFixedThreadPool(2);

        long startTime = System.currentTimeMillis();

        // 1. Fork 작업을 분할한다.
        SumTask task1 = new SumTask(1, 4);
        SumTask task2 = new SumTask(5, 8);

        // 2. 분할한 작업을 처리한다.
        Future<Integer> future1 = es.submit(task1);
        Future<Integer> future2 = es.submit(task2);

        // 3. join - 처리한 결과를 합친다. get: 결과가 나올 때까지 대기한다.
        Integer result1 = future1.get();
        Integer result2 = future2.get();
        log("main 스레드 대기 완료");

        int sum = result1 + result2;
        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " + sum);

        es.close();

        // 큰 작업을 분할해서 멀티스레드에서 실행 후 합치는 것이 패턴 - 포크조인 패턴 Fork/Join 패턴
    }

    static class SumTask implements Callable<Integer> {  // 반환값이 있는경우 Runnable이 아닌 Callable, Integer 반환 call()
        int startValue;
        int endValue;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public Integer call() {
            log("작업 시작");   // static import MyLogger.log
            int sum = 0;
            for (int i = startValue; i <= endValue ; i++) {
                int calculated = HeavyJob.heavyTask(i);
                sum += calculated;
            }
            log("작업 완료 result = " + sum);
            return sum;
        }
    }
}
//        20:50:11.412 [pool-1-thread-1] 작업 시작      // 단어 pool 만 바뀐것. Thread pool에 있는 Thread가 대신 작업을 해주는것 뿐
//        20:50:11.412 [pool-1-thread-2] 작업 시작
//        20:50:11.416 [pool-1-thread-2] calculate 5 -> 50
//        20:50:11.416 [pool-1-thread-1] calculate 1 -> 10
//        20:50:12.417 [pool-1-thread-2] calculate 6 -> 60
//        20:50:12.419 [pool-1-thread-1] calculate 2 -> 20
//        20:50:13.418 [pool-1-thread-2] calculate 7 -> 70
//        20:50:13.419 [pool-1-thread-1] calculate 3 -> 30
//        20:50:14.419 [pool-1-thread-2] calculate 8 -> 80
//        20:50:14.421 [pool-1-thread-1] calculate 4 -> 40
//        20:50:15.420 [pool-1-thread-2] 작업 완료 result = 260
//        20:50:15.421 [pool-1-thread-1] 작업 완료 result = 100
//        20:50:15.421 [     main] main 스레드 대기 완료
//        20:50:15.424 [     main] time: 4031ms, sum: 360