package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //final 변수의 생성자를 만들어줌

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository; //추상화로 의존1
    private final DiscountPolicy discountPolicy; // 추상화로 의존2

    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //setter로 주입
//    private MemberRepository memberRepository;
//    private DiscountPolicy discountPolicy;
//
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }
//
//
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);//멤버를 먼저 찾는다. (할인율을 위하여)
        int discountPrice = discountPolicy.discount(member, itemPrice);  // 멤버객체의 Grade를 기준으로 할인율을 정해준다.

        //order 측에서는 할인에 대해서는 관여x
        //order 측에서는 할인관련 변경이 있어도 전혀 변경되지 않는다. -> 단일 체계 원칙을 잘 지킨경우!

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
