package parallel;

import util.MyLogger;

import static util.MyLogger.*;
import static util.MyLogger.log;

public class ParallelMain2 {
    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();

        // 1. Fork 작업을 분할한다.
        SumTask task1 = new SumTask(1, 4);
        SumTask task2 = new SumTask(5, 8);

        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "Thread-2");

        // 2. 분할한 작업을 처리한다.
        thread1.start();
        thread2.start();

        // 3. join - 처리한 결과를 합친다.
        thread1.join();     // 멀티스레드니까 끝날때까지 기다려야 그 결과를 받을수 있다.
        thread2.join();
        log("main 스레드 대기 완료");

        int sum = task1.result + task2.result;

        long endTime = System.currentTimeMillis();
        log("time: " + (endTime - startTime) + "ms, sum: " + sum);
    }

    static class SumTask implements Runnable {  // 멀티스레드를 사용하기 위해 직접 구현
        int startValue;
        int endValue;
        int result = 0;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");   // static import MyLogger.log
            int sum = 0;
            for (int i = startValue; i <= endValue ; i++) {
                int calculated = HeavyJob.heavyTask(i);
                sum += calculated;
            }
            result = sum;
            log("작업 완료 result = " + result);
        }
    }
}

//        19:30:06.060 [ Thread-2] 작업 시작
//        19:30:06.060 [ thread-1] 작업 시작
//        19:30:06.066 [ Thread-2] calculate 5 -> 50
//        19:30:06.067 [ thread-1] calculate 1 -> 10
//        19:30:07.068 [ thread-1] calculate 2 -> 20
//        19:30:07.068 [ Thread-2] calculate 6 -> 60
//        19:30:08.068 [ thread-1] calculate 3 -> 30
//        19:30:08.068 [ Thread-2] calculate 7 -> 70
//        19:30:09.069 [ Thread-2] calculate 8 -> 80
//        19:30:09.069 [ thread-1] calculate 4 -> 40
//        19:30:10.071 [ Thread-2] 작업 완료 result = 260
//        19:30:10.071 [ thread-1] 작업 완료 result = 100
//        19:30:10.071 [     main] main 스레드 대기 완료
//        19:30:10.077 [     main] time: 4032ms, sum: 360