package lambda.ex1;

import lambda.Procedure;

public class M1After {

    static void greet(Procedure procedure) {
        System.out.println("=== 시작 ===");   // 안 변하는 부분
        procedure.run();
        System.out.println("=== 끝 ===");    // 안 변하는 부분
    }

    public static void main(String[] args) {

        greet(() -> {
            System.out.println("Good Morning!");
        });
        greet(() -> {
            System.out.println("Good Afternoon!");
        });
        greet(() -> {
            System.out.println("Good Evening!");
        });

    }
}
