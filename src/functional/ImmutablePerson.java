package functional;

public class ImmutablePerson {
    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Getter만 제공, Setter 없음 (수정 불가능)
    // 변경이 필요한 경우, 기존 객체를 수정하지 않고 새 객체를 반환

    public ImmutablePerson withAge(int newAge) {
        return new ImmutablePerson(name, newAge);   // 기존 데이터 바꾸지 않고 새 객체
    }

    @Override
    public String toString() {
        return "ImmutablePerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
