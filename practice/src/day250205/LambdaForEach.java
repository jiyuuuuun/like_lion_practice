package practice.src.day250205;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//주어진 List<Integer>의 각 요소에 10을 더한 결과를 새 리스트에 저장하고 출력하라.
// 람다식을 사용하여 List의 forEach() 메서드를 활용하라.
public class LambdaForEach {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> new_nums=numbers.stream().map(x->x+10).collect(Collectors.toList());
        System.out.println(new_nums);
    }
}