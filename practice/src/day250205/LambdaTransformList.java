package practice.src.day250205;

import java.util.Arrays;
import java.util.List;

//주어진 `List<Integer>`의 각 요소를 제곱한 결과를 새 리스트에 저장하고 출력하라.
// `for` 루프와 람다식을 활용하여 각 요소를 변환하라.
public class LambdaTransformList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream().map(x -> x * x).forEach(System.out::println);


    }
}