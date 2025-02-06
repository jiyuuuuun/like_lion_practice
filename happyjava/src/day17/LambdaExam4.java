package happyjava.src.day17;

import java.util.function.*;

public class LambdaExam4 {
    public static void main(String[] args) {

        //predicate - 입력을 받아서 결과로 boolean을 리턴하는 메서드를 가지는 메서드
        //조건을 테스트 할 때 사용
        //입력한 값이 음수인지 양수인지 체크하는 메서드를 구현
        Predicate<Integer> isEven = i -> i % 2 == 0;
        System.out.println(isEven.test(2));

        //Consumer
        //입력을 받아서 반환값이 없는 연산을 수행 할 때
        Consumer<String> consumer = s-> System.out.println(s);
        consumer.accept("Hello");

        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("HelloWorld");

        //Function
        //입력을 받아서 연산해서 출력하는
        Function<String, Integer> function = s-> s.length();
        System.out.println(function.apply("Hello"));

        Function<String,Integer> function1 = String::length;
        System.out.println(function1.apply("HelloWorld"));

        //Supplier
        //입력없이 값을 반환
        Supplier<Double> randomDouble = () -> Math.random();
        Supplier<Double> randomDouble1 = Math::random;

        System.out.println(randomDouble.get());
        System.out.println(randomDouble1.get());

        IntSupplier intSupplier = ()->(int)(Math.random()*6)+1;
        System.out.println(intSupplier.getAsInt());

        //BiFunction
        //값을 두개 입력 받고, 하나의 결과값을 반환
        BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> x + y;
        System.out.println(biFunction.apply(1, 2));

        //Consumer 의 andThen 메서드
        Consumer<String> conA = s -> System.out.println(s + "aaaa");
        Consumer<String> conB = s -> System.out.println(s + "bbbb");
        conA.accept("jiyun");
        conB.accept("jiyun");
        Consumer<String> conAB = conA.andThen(conB);
        conAB.accept("hello");

    }
}
