package lambda.start;

public class Ex0RefMain {

    public static void hello(String str) {
        System.out.println("프로그램 시작");  // 변하지 않는 부분

        // 변하는 부분 시작
        System.out.println(str);
        // 변하는 부분 종료

        System.out.println("프로그램 종료");  // 변하지 않는 부분
    }

    public static void main(String[] args) {
        hello("hello Java");
        hello("Hello Spring");
    }
}

//변하는 부분과 변하지 않는 부분을 잘 분리하는것
// 값 매개변수화: 변하는 부분을 외부에서 값을 받도록