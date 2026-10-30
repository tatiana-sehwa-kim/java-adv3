package functional;

import java.util.List;

public class ImmutableMain3 {
    public static void main(String[] args) {

        ImmutablePerson m1 = new ImmutablePerson("Kim", 10);
        ImmutablePerson m2 = new ImmutablePerson("Lee", 20);

        List<ImmutablePerson> originList = List.of(m1, m2);
        System.out.println("originList = " + originList);

        List<ImmutablePerson> resultlist = originList.stream()
                // setAge가 없으니 withAge로
                .map(p -> p.withAge(p.getAge() + 1))    // 새로운 객체를 받아서 저장
                .toList();

        System.out.println("=== 실행 후 ===");
        System.out.println("originList = " + originList);
        System.out.println("resultlist = " + resultlist);
    }
}
//    originList = [ImmutablePerson{name='Kim', age=10}, ImmutablePerson{name='Lee', age=20}]
//    === 실행 후 ===
//    originList = [ImmutablePerson{name='Kim', age=10}, ImmutablePerson{name='Lee', age=20}]
//    resultlist = [ImmutablePerson{name='Kim', age=11}, ImmutablePerson{name='Lee', age=21}]