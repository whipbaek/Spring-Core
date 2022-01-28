package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; //무조건 1000원 할인!

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){ //enum은 == 사용가능, VIP이면 1000원 할인
            return discountFixAmount;
        } else { //VIP가 아니라면 0원 할인
            return 0;
        }
    }
}
