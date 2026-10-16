package lambda.lambda5.mystream;

import lambda.lambda5.filter.GenericFilter;
import lambda.lambda5.map.GenericMapper;

import java.util.ArrayList;
import java.util.List;

public class Ex2_Student {
    public static void main(String[] args) {

        // 점수가 80점 이상인 학생의 이름을 추출해라.
        List<Student> students = List.of(
                new Student("Apple", 100),
                new Student("Banana", 80),
                new Student("Berry", 50),
                new Student("Tomato", 40)
        );

        List<String> directResult = direct(students);
        System.out.println("directResult = " + directResult);

        List<String> lambdaResult = lambda(students);
        System.out.println("lambdaResult = " + lambdaResult);
    }

    private static List<String> direct(List<Student> students) {   // 명령형 프로그래밍
        ArrayList<String> Students80 = new ArrayList<>();
        for (Student student : students) {
            if (student.getScore() >= 80) {
                Students80.add(student.getName());
            }
        }
        return Students80;
    }

    private static List<String> lambda(List<Student> students) {  // 선언적 프로그래밍
        List<Student> filtered = GenericFilter.filter(students, student -> student.getScore() >= 80);
        List<String> mapped = GenericMapper.map(filtered, s -> s.getName());
        return mapped;
    }

}
