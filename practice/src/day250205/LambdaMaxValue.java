package practice.src.day250205;

import java.util.Arrays;

//주어진 정수 배열에서 최대값을 찾아 출력하라.
//람다식을 사용하여 자바의 Comparator 인터페이스와 함께 Arrays.sort()를 활용하라.
public class LambdaMaxValue {
    public static void main(String[] args) {
        Integer[] numbers = {4, 2, 7, 1, 3};
        // 람다식을 사용하여 배열을 정렬하라
        Arrays.stream(numbers).max(Integer::compare).ifPresent(System.out::println);//Optional이 값을 가지고 있을 때만 특정 동작을 수행
        int max=Arrays.stream(numbers).max(Integer::compare).orElse(0);
        System.out.println(max);
    }
}