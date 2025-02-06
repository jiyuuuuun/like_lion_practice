package happyjava.src.day17stream;

import java.util.Arrays;
import java.util.List;

public class StreamExam06 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum=numbers.stream().reduce(0, (a, b) -> a + b); //초기값,연산
        System.out.println(sum);
    }
}
