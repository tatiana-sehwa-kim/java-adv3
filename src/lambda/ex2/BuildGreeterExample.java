package lambda.ex2;

public class BuildGreeterExample {

    // 고차 함수, greeting 문자열을 받아, "새로운 함수를" 반환
    public static StringFunction buildGreeter(String greeting) {
        // 코드 작성
        return name -> greeting + ", " + name;
    }

    public static void main(String[] args) {
        // 코드 작성
        String java = "java";
        System.out.println(buildGreeter("Hello").apply(java));

        String lambda = "Lambda";
        System.out.println(buildGreeter("Hi").apply(lambda));
    }
}
