package happyjava.src.day17;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaExam1 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill", "Bob");

        List<String> nameList = Arrays.asList("kang","kim","hong");
        MyComparator myComparator = new MyComparator();
        names.sort(myComparator);
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(names);
        nameList.sort((o1,o2) -> o1.compareTo(o2));
        System.out.println(nameList);

        nameList.sort(String::compareTo); //String의 compareTo를 사용한다는 뜻



    }
}
