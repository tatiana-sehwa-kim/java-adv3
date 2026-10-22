package stream.colletors;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.max;
import static java.util.stream.Collectors.*;

public class DownStreamMain2 {
    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student("Kim", 1, 85),
                new Student("Park", 1, 70),
                new Student("Lee", 2, 70),
                new Student("Han", 2, 90),
                new Student("Hoon", 3, 90),
                new Student("Ha", 3, 89)
        );

        // 1단계: 학년별로 학생들을 그룹화 해라.
        Map<Integer, List<Student>> collect1 = students.stream()
                .collect(Collectors.groupingBy(Student::getGrade));
        System.out.println("collect1 = " + collect1);

        // 2단계: 학년별로 가장 점수가 높은 학생을 구하고 reducing을 사용해라
        Map<Integer, Optional<Student>> collect2 = students.stream()        // 그룹별로 값이 없을수도 있기 때문에 Optional
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.reducing((s1, s2) -> s1.getScore() > s2.getScore() ? s1 : s2)
                ));
        System.out.println("collect2 = " + collect2);

        // 3단계: 학년별로 가장 점수가 높은 학생을 구해라. maxBy 사용 (a가 더크면 1 반환 b가 더크면 -1 반환)
        Map<Integer, Optional<Student>> collect3 = students.stream()
                .collect(groupingBy(
                        Student::getGrade,
//                        Collectors.maxBy((a, b) -> a.getScore() > b.getScore() ? 1 : -1)
//                        Collectors.maxBy(Comparator.comparingInt(student -> student.getScore())) // 람다
                        Collectors.maxBy(Comparator.comparingInt(Student::getScore)) // 람다 한번 더
                ));
        System.out.println("collect3 = " + collect3);

        // 4단계: 학년별로 가장 점수가 높은 학생의 이름을 구해라. (collectingAndThen + maxBy 사용)
        // 학년별 그룹 -> 그룹별 가장 점수가 높은 학생 -> 그룹별 최고점 학생 -> 그룹별 최고점 학생의 이름
        Map<Integer, String> collect4 = students.stream()
                .collect(groupingBy(
                        Student::getGrade,
                        collectingAndThen(          //  다운 스트림 컬렉터가 만든 결과를 한 번 더 후처리(And Then)할 수 있도록 해준다.
                                maxBy(Comparator.comparingInt(Student::getScore)),  // maxBy가 반환하는 것은 점수가 아니라 그 점수를 가진 학생 객체(Student)
                                sOpt -> sOpt.get().getName()        // Optional<Student> 상자를 .get() 강제로 뜯고 getName() 이름 호출
                        )
                ));
        System.out.println("collect4 = " + collect4);
    }
}
