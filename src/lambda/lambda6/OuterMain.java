package lambda.lambda6;

public class OuterMain {

    private String message = "외부 클래스";

    public void execute() {
        // 1. 익명 클래스 예시
        Runnable anonymous = new Runnable() {

            private String message = "익명 클래스";

            @Override
            public void run() {
                // 익명 클래스에서의 this는 익명 클래스의 인스턴스를 가리킴
                System.out.println("[익명 클래스] this = " + this);
                System.out.println("[익명 클래스] this.class = " + this.getClass());
                System.out.println("[익명 클래스] this.message = " + this.message);
            }
        };

        // 2. 람다 예시
        Runnable lambda = () -> {
            // 람다에서의 this는 람다가 선언된 클래스의 인스턴스(즉, 외부 클래스)를 가리킴
            System.out.println("[람다]this = " + this);
            System.out.println("[람다]this.class = " + this.getClass());
            System.out.println("[람다]this.message = " + this.message);
        };

        anonymous.run();
        System.out.println("-------------------------------------");
        lambda.run();
    }

    public static void main(String[] args) {
        OuterMain outer = new OuterMain();
        System.out.println("[외부 클래스]: " + outer);
        System.out.println("-------------------------------------");
        outer.execute();
    }
}

//    [외부 클래스]: lambda.lambda6.OuterMain@f6f4d33
//    -------------------------------------
//    [익명 클래스] this = lambda.lambda6.OuterMain$1@4f023edb
//    [익명 클래스] this.class = class lambda.lambda6.OuterMain$1
//    [익명 클래스] this.message = 익명 클래스
//    -------------------------------------
//    [람다]this = lambda.lambda6.OuterMain@f6f4d33   외부 클래스랑 똑같은 값 나옴
//    [람다]this.class = class lambda.lambda6.OuterMain   외부 클래스 나옴
//    [람다]this.message = 외부 클래스

//    람다의 this라는 스코프는 그냥 외부 클래스 나를 만든 인스턴스의 클래스를 가리킨다고 보면 된다.