package lambda.start;

import lambda.Procedure;

import java.util.Random;

public class Ex1RefMain {
    public static void hello(Procedure procedure) {
        long startNs = System.nanoTime();   // 변하지 않는 부분

        //코드 조각 시작
        procedure.run();
        //코드 조각 종료

        long endNs = System.nanoTime();     // 변하지 않는 부분
        System.out.println("실행 시간: " + (endNs - startNs) + "ns");
    }

    static class Dice implements Procedure {
        @Override
        public void run() {
            int randomValue = new Random().nextInt(6) + 1;
            System.out.println("주사위 = " + randomValue);
        }
    }

    static class Sum implements Procedure {
        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println("i = " + i);
            }
        }

        public static void main(String[] args) {
            Procedure dice = new Dice();
            hello(dice);

            Procedure sum = new Sum();
            hello(sum);
        }
    }
}
