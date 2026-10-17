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

//    내부 반복 vs 외부 반복
//    외부 반복: 기존의 for , while 루프처럼, 개발자가 반복 제어를 직접 담당하며 명령형 스타일이다. 중간 에 break , continue 등이 들어가는 로직을 구현하기 쉽다.
//    내부 반복: 스트림의 forEach 처럼, 반복 제어를 스트림에 맡기고 개발자는 "어떤 작업을 할지
//            ( Consumer )"만 정의하면 된다. 이는 선언형 프로그래밍 스타일로써 코드가 짧고 의도가 명확하다.