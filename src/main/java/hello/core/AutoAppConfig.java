package hello.core;


import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core",
//        basePackages = "hello.core.member"; 이러면 멤버속에 있는 것들만 빈으로 등록된다.
//        basePackageClasses = AutoAppConfig.class,  AutoAppConfig 파일의 package(hello.core)에서 탐색을 시작한다.
//        아무것도 지정하지 않으면 @ComponentScan 의 클래스의 패키지(hello.core)부터 탐색을 시작한다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)

)
public class AutoAppConfig {
}
