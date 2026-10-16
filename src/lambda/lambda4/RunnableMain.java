package lambda.lambda4;

public class RunnableMain {
    public static void main(String[] args) {    // Runnable : 매개변수와 반환값이 모두 없는 실행 작업을 나타낸다(주로 스레드 실행).

        //익명 클래스
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Runnable");
            }
        };
        runnable1.run();

        //람다
        Runnable runnable2 = () -> System.out.println("Hello Runnable");
        runnable2.run();
    }
}
