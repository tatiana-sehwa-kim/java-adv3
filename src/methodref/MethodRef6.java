package methodref;

import java.util.function.BiFunction;

// 매개변수 추가
public class MethodRef6 {
    public static void main(String[] args) {
        //4. 임의 객체의 인스턴스 메서드 참조(특정 타입의)
        Person person = new Person("Kim");

        //람다
        BiFunction<Person, Integer, String> fun1 =
                (Person p, Integer number) -> p.introduceWithNumber(number);

        System.out.println("person.upperName = " + fun1.apply(person, 1));

        //메서드 참조, 타입이 첫 번째 매개변수가 됨, 그리고 첫 번째 매개변수의 메서드를 호출
        //나머지는 순서대로 매개변수에 전달
        BiFunction<Person, Integer, String> fun2 = Person::introduceWithNumber; // 매개변수를 다 알고있다.    타입::메서드명
        System.out.println("person.upperName = " + fun2.apply(person, 1));
    }
}

//        매개변수가 1개 더 추가되었을 때 자바가 처리하는 순서 규칙
//
//        첫 번째 매개변수(Person p):
//
//        → 메서드를 실행할 주어(호출 대상 객체)로 삼는다. (p.)
//
//        두 번째 매개변수부터(Integer number):
//
//        → 그 메서드의 괄호 안에 순서대로 집어넣는다. (introduceWithNumber(number))
