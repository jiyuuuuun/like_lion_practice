package happyjava.src.day17;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaExam5 {
    public static void main(String[] args) {

        //메서드 참조 ::
        //1. 정적 메서드 참조
        BiFunction<Integer, Integer, Integer> add = (a, b) -> Math.max(a,b);
        BiFunction<Integer, Integer, Integer> add2 = Math::max;
        System.out.println(add.apply(1, 2));
        System.out.println(add2.apply(1, 2));

        //2.인스턴트 메서드 참조
        String str="hello World";
        Supplier<Integer> len = () -> str.length();
        Supplier<Integer> len2 = str::length;
        System.out.println(len.get());
        System.out.println(len2.get());

        //3.임의 객체의 인스턴스 메서드 참조
        List<String> words = Arrays.asList("hello", "world");
        List<Integer> lengths=new ArrayList<>();

        Function<String,Integer> lengthF=String::length;

        for(String word:words){
            lengths.add(lengthF.apply(word));
        }
        System.out.println(lengths);

        //4.생성자 참조
        Supplier<List<String>> listSupplier = ArrayList::new;

        List<String> list=listSupplier.get();
        list.add("hello");
        list.add("world");
        System.out.println(list);

    }
}
