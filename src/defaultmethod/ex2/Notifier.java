package defaultmethod.ex2;

import java.time.LocalDateTime;

public interface Notifier {
    // 알림을 보내는 기능
    void notify(String message);

    // 신규 기능 추가
    default void scheduleNotification(String message, LocalDateTime scheduleTime){
        System.out.println("[기본 스케줄링] message: " + message + ", time: " + scheduleTime);
    };
}

//    scheduleNotification() 메서드가 Notifier 인터페이스에 새로 추가됨에 따라, 기존에 존재하던 SMSNotifier , AppPushNotifier 구현 클래스들이
//    강제로 이 메서드를 구현하도록 요구된다.규모가 작은 예제에서는 그럼 나머지 두 클래스도 재정의하면 된다고 생각할 수 있다.
//    하지만 실무 환경에서 해당 인터페이스를 구현한 클래스가 수십~수백 개라고 한다면, 이 전부를 수정해서 새 메서 드를 재정의해야 한다.
//    심지어 우리가 만들지 않은, 외부 라이브러리에서 Notifier 를 구현한 클래스가 있다면 그것까지 전부 깨질 수 있어, 호환성을 깨뜨리는 매우 심각한 문제가 된다

//    자바 8부터 이러한 하위 호환성 문제를 해결하기 위해 디폴트 메서드가 추가되었다. 인터페이스에 메서드를 새로 추가 하면서, 기본 구현을 제공할 수 있는 기능이다.
//    예를 들어, Notifier 인터페이스에 scheduleNotification() 메서드를 default 키워드로 작성하고 기본 구현을 넣어두면, 구현 클래스들은 이 메서드를 굳이 재정의하지 않아도 된 다.
