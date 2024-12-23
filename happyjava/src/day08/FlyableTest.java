package day08;

public class FlyableTest {
    public static void main(String[] args) {
        //Interface는 객체 생성이 불가능하다
        //타입으로 생성 가능

        Flyable flyable = new 나비();
        Flyable flyable2 = new 드론();
        Flyable flyable3 = new 비행기();

        flyable.fly();
        flyable2.fly();
        flyable3.fly();
        //인터페이스로 fly() 기능이 표준화 도이었기 때문에 나비,드론,비행기 다 같은 방식으로 날게 할 수 있다

    }
}
