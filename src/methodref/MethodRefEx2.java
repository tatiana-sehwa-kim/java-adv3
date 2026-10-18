package methodref;

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefEx2 {
    public static void main(String[] args) {

        //1. 정적 메서드 참조
        Function<String, String> staticMethod1 = name -> Person.greetingWithName(name);
        Function<String, String> staticMethod2 = Person::greetingWithName;  // 매개변수 생략 가능   // 클래스명::메서드

        System.out.println("staticMethod1: = " + staticMethod1.apply("Kim"));
        System.out.println("staticMethod2 = " + staticMethod2.apply("Kim"));

        //2. 특정 객체의 인스턴스 참조
        Person person = new Person("Kim");
        Function<Integer, String> instanceMethod1 = n -> person.introduceWithNumber(n);
        Function<Integer, String> instanceMethod2 = person::introduceWithNumber;                // 인스턴스명::메서드

        System.out.println("instanceMethod1 = " + instanceMethod1.apply(1));
        System.out.println("instanceMethod2 = " + instanceMethod2.apply(1));

        //3. 생성자 참조
        Function<String, Person> newPerson1 = name -> new Person(name);
        Function<String, Person> newPerson2 = Person::new;                      // 앞에 Person 형식에서 어떤 생성자인지 알수있다

        System.out.println("newPerson1 = " + newPerson1.apply("Kim"));
        System.out.println("newPerson2 = " + newPerson2.apply("Lee"));

    }
}

//    메서드 참조에서 매개변수를 생략하는 이유
//    함수형 인터페이스의 시그니처(매개변수와 반환 타입)가 이미 정해져 있고,
//    컴파일러가 그 시그니처를 바탕으로 메서드 참조와 연결해 주기 때문에 명시적으로 매개변수를 작성하지 않아도 자동으로 추론되어 호출된다.
