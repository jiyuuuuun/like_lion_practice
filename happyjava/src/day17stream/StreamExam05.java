package happyjava.src.day17stream;

import java.util.Arrays;
import java.util.List;

public class StreamExam05 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        long count=numbers.stream().count();
        System.out.println(count);
        System.out.println(numbers.stream().max(Integer::compare).orElse(0));
        double avr=numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println(avr);
    }
}
