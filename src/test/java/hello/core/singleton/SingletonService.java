package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService(); //static으로 선언되어서 단 하나만 존재하게 된다. (jvm이 뜰 때 바로 생성)

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() { //private 생성자로 외부의 생성을 막는다.
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
