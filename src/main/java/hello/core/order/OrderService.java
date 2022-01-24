package hello.core.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
    //회원 조회, 할인율 적용 시스템 모두를 거치고 최종 주문정보를 반환한다.
}
