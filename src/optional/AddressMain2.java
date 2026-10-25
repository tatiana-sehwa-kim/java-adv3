package optional;

import optional.model.Address;
import optional.model.User;

import java.util.Optional;

public class AddressMain2 {
    public static void main(String[] args) {

        User user1 = new User("user1", null);
        User user2 = new User("user2", new Address("hello street"));

        printStreet(user1);
        printStreet(user2);
    }

    private static void printStreet(User user) {
        getUserStreet(user).ifPresentOrElse(
                System.out::println,                // 값 있으면 이거,
                () -> System.out.println("Unknown") // 없으면 이거 출력
        );
    }

    static Optional<String> getUserStreet(User user) {
        return Optional.ofNullable(user)  // user가 null일수 있으므로 ofNullable 사용
                .map(User::getAddress)      // user.getAddress() 처리
                .map(Address::getStreet);   // address.getStreet() 처리. 최종적으로 street 반환
        // 여기서 map 체이닝 중간에 null이면 자동으로 Optional.empty()로 전환되어 반환한다.
    }
}
