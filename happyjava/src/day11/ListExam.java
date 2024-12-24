package happyjava.src.day11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListExam {
    public static void main(String[] args) {
        List<String> fruits =new ArrayList<>();

        fruits.add("apple");
        fruits.add("banana");
        fruits.add("cherry");

        String firstFruis = fruits.get(0);
        System.out.println(firstFruis);

        System.out.println(fruits);

        fruits.set(1, "peach"); //교체

        System.out.println(fruits);

        fruits.add(1, "banana");//추가
        System.out.println(fruits);

        fruits.remove("apple");
        fruits.remove(2);
        System.out.println(fruits);

        List<Integer> integerList=new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        Collections.shuffle(integerList);
        System.out.println(integerList);

        Collections.sort(integerList);
        System.out.println(integerList);


    }
}
