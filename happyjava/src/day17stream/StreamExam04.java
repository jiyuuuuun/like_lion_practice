package happyjava.src.day17stream;

import java.util.Arrays;
import java.util.List;

public class StreamExam04 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //allMatch->and anyMatch->or
        System.out.println(numbers.stream().allMatch(n->n%2==0)); //다 짝수?
        System.out.println(numbers.stream().allMatch(n->n%2==1)); //다 홀수?

        System.out.println(numbers.stream().anyMatch((n->n%10==0)));
    }
}
