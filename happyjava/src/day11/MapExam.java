package happyjava.src.day11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(11,"Kang");
        map.put(22, "Kim");
        map.put(33, "Hwang");

        System.out.println(map);

        String value=map.get(33);
        System.out.println(value);

        Set<Integer> key=map.keySet();

        Iterator<Integer> iterator= key.iterator();
        while(iterator.hasNext()){
            Integer k2=iterator.next();
            System.out.println(k2);
            String value2= map.get(k2);
            System.out.println(value2);
        }
    }

}
