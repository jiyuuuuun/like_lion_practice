package happyjava.src.day17;

import java.util.Arrays;
import java.util.List;

public class LambdaExam2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill", "Bob");

        names.forEach(name -> System.out.println(name));
        names.forEach(System.out::println); //매개변수가 한개일 때 사용
    }
}
