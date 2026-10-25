package defaultmethod.ex1;

import java.util.List;

public class NotifierMainV1 {
    public static void main(String[] args) {

        List<Notifier> notifiers = List.of(new EmailNotifier(), new SMSNotifier(), new AppPushNotifier());
        notifiers.stream().forEach(n -> n.notify("서비스 가입을 환영합니다."));    // 컬렉션도 내부 루프 지원 forEach


    }
}
