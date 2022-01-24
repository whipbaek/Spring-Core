package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);//멤버를 먼저 찾는다. (할인율을 위하여)
        int discountPrice = discountPolicy.discount(member, itemPrice);  // 멤버객체의 Grade를 기준으로 할인율을 정해준다.

        //order 측에서는 할인에 대해서는 관여x
        //order 측에서는 할인관련 변경이 있어도 전혀 변경되지 않는다. -> 단일 체계 원칙을 잘 지킨경우!

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
