package happyjava.src.day11;

import java.util.*;

public class IteratorExam {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        for(int i=0;i< list.size();i++){
            System.out.println(list.get(i));

        }

        System.out.println("====================");

        Iterator<String> itar =list.iterator();
        while(itar.hasNext()){
            System.out.println(itar.next());

        }
        System.out.println("====================");

        for(String s:list){
            System.out.println(s);
        }

        System.out.println("=========set========");
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");

        //set은 순서가 없는 자료구조 이므로 인덱스가 존재하지 않는다
        Iterator<String> iterator= set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (String setItem : set) { //for-each java 5에서 추가 됨
            System.out.println(setItem);
        }

    }



}
