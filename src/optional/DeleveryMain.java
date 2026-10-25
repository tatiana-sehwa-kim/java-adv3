package optional;

import optional.model.Delevery;
import optional.model.Order;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DeleveryMain {
    static Map<Long, Order> orderRepository = new HashMap<>();

    static {
        orderRepository.put(1L, new Order(1L, new Delevery("배송완료", false)));
        orderRepository.put(2L, new Order(2L, new Delevery("배송중", false)));
        orderRepository.put(3L, new Order(3L, new Delevery("배송중", true))); // 배송중 취소
        orderRepository.put(4L, new Order(4L, null)); // 주문은 했는데 아직 배송정보가 없는것
    }

    public static void main(String[] args) {
        System.out.println("1 = " + getDeliveryStatus(1L));
        System.out.println("2 = " + getDeliveryStatus(2L));
        System.out.println("3 = " + getDeliveryStatus(3L));
        System.out.println("4 = " + getDeliveryStatus(4L));

        // 배송상태 촐력 미션
    }

    private static String getDeliveryStatus(long orderId) {
        return findOrder(orderId)
                .map(Order::getDelivery)
                .filter(delivery -> !delivery.isCanceled())     // 캔슬이 되었는지 아닌지 - 내가 빠트린 부분
                .map(Delevery::getStatus)
                .orElse("배송정보가 없습니다.");
    }

    static Optional<Order> findOrder(Long orderId) {
        return Optional.ofNullable(orderRepository.get(orderId));   // orderRepository에서 id를 찾아서 Optional 포장한 것
    }
}
//    1 = 배송완료
//    2 = 배송중
//    3 = 배송정보가 없습니다.
//    4 = 배송정보가 없습니다.