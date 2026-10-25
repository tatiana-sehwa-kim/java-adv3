package defaultmethod.ex2;

import java.time.LocalDateTime;
import java.util.List;

public class NotifierMainV2 {
    public static void main(String[] args) {

        List<Notifier> notifiers = List.of(new EmailNotifier(), new SMSNotifier(), new AppPushNotifier());
        notifiers.stream().forEach(n -> n.notify("서비스 가입을 환영합니다."));    // 컬렉션도 내부 루프 지원 forEach
        
        // 스케줄 기능 추가
        LocalDateTime plus1Days = LocalDateTime.now().plusDays(1);// 하루후에 보내기
        notifiers.forEach(n -> {
            n.scheduleNotification("hello!", plus1Days);
        });
    }
}
