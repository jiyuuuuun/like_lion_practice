package practice.src.day250205;

import java.util.Arrays;
import java.util.List;

//주어진 List<String>을 문자열 길이에 따라 정렬하되,
// 람다식을 사용하여 Collections.sort() 메서드를 활용하라.
public class LambdaSorting {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Date");
        // 람다식을 사용하여 리스트를 길이에 따라 정렬하라
        // 결과 출력
        System.out.println(words);
    }
}