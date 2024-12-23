package day11;

import java.util.HashSet;
import java.util.Set;

public class SetExam {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("e");

        System.out.println(set);

        if(set.contains("a")){ //데이터가 있는지 확인
            System.out.println("true");
        }

        Set<Pen> pen=new HashSet<>();
        pen.add(new Pen("red"));
        pen.add(new Pen("black"));
        pen.add(new Pen("blue"));

        System.out.println(pen);



        //주소가 달라 다른 객체로 인식
        //Pen의 equals 오버라이딩 해줌
        //Hash가 붙어있는 객체는 hash코드 값을 인식함
        if(pen.contains(new Pen("red"))){
            System.out.println("있어요");
        }else {
            System.out.println("없어요");
        }


    }
}
