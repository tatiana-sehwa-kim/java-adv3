package methodref;

import lambda.lambda5.mystream.MyStreamV3;

import java.util.List;

public class MethodRef5 {
    public static void main(String[] args) {

        List<Person> personList = List.of(
                new Person("Kim"),
                new Person("Park"),
                new Person("Lee")
        );

        //람다
        List<String> result1 = MyStreamV3.of(personList)
                .map(person -> person.introduce())        // 하면 String을 반환
                .map(str -> str.toUpperCase())             // String 받고 대문자로 변환
                .toList();
        System.out.println("result1 = " + result1);

        //메서드 참조 가독성 권장
        List<String> result2 = MyStreamV3.of(personList)
                .map(Person::introduce)
                .map(String::toUpperCase)
                .toList();
        System.out.println("result2 = " + result2);
    }
}
