package functional;

public class ImmutableMain1 {
    public static void main(String[] args) {

        MutablePerson m1 = new MutablePerson("Kim", 10);
        MutablePerson m2 = m1;
        m2.setAge(11);
        System.out.println("m1 = " + m1);       // 덮여서 기존값을 알수없다
        System.out.println("m2 = " + m2);

//        m1 = MutablePerson{name='Kim', age=11}
//        m2 = MutablePerson{name='Kim', age=11}

        ImmutablePerson i1 = new ImmutablePerson("Lee", 20);
        ImmutablePerson i2 = i1.withAge(21);    // i2는 새로운 객체
        System.out.println("i1 = " + i1);       // 기존 값 유지
        System.out.println("i2 = " + i2);

//        i1 = ImmutablePerson{name='Lee', age=20}
//        i2 = ImmutablePerson{name='Lee', age=21}
    }
}
