package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }


    @Test

    void join(){
        //given : ~~환경이 주어졌을때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when : 이렇게 했을때
        memberService.join(member); //join 했을때
        Member findMember = memberService.findMember(1L);

        //then : 이렇게 된다.
        Assertions.assertThat(member).isEqualTo(findMember); //똑같은지 검증

        //Assertions 는 org.assertj.core.api를 사용해야한다.
        //test code로 진행시에는 초록불 or 빨간불로 인식하기도 편하고, 오류났을때 찾기도 더욱 간편하다.
    }
}
