package lambda.lambda5.mystream;

import java.util.List;

public class MyStreamLoopMain {
    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student("Apple", 100),
                new Student("Banana", 80),
                new Student("Berry", 50),
                new Student("Tomato", 40)
        );

        List<String> result = MyStreamV3.of(students)
                .filter(s -> s.getScore() >= 80)
                .map(s -> s.getName())
                .toList();

        // 일반적으로 for로 해서 돌리는것이 외부반복
        for (String s : result) {
            System.out.println("name: " + s);
        }

        // 추가(print 까지 스트림으로 만드는 forEach) MyStreamV3 에 추가하엿음
        MyStreamV3.of(students)     // 프린트만 할꺼니까 List에 담을 필요도 없다
                .filter(s -> s.getScore() >= 80)
                .map(s -> s.getName())
                .forEach(name -> System.out.println("name: " + name));      // forEach로 내부 반복
    }
}

//    name: Apple
//    name: Banana
//    name: Apple
//    name: Banana