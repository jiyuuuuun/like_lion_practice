package practice.src.day250205;

import java.util.Arrays;
import java.util.List;

//주어진 `List<Integer>`의 모든 요소가 짝수인지 확인하라.
// 람다식을 활용하여 조건 검사를 수행하고 결과를 출력하라.
public class LambdaCheckAll {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
        // 람다식을 사용하여 모든 요소 검사
        boolean allMatchStream=numbers.stream().allMatch(number -> number % 2 == 0);
        System.out.println(allMatchStream);
    }
}