package hello.core.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    //차후에 MemberRepository를 상속하는 클래스(또 다른 db)가 있을시에
    //들어오는 객체 (현재 들어오는 객체는 메모리 리포지토리) 를 바꾸어서 사용할 수 있다.

    private final MemberRepository memberRepository;
    //현재 MemberServiceImpl 은 interface인 MemberRepository도 의존하며, 실제 구현체인 MemoryMemberRepository도 의존하고 있다.
    //추상화에도 의존하고, 구체화에도 의존하고 있는것이다. -> DIP를 위반하고 있는것이다.

    @Autowired //의존 관계를 자동으로 설정해준다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //TEST 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
