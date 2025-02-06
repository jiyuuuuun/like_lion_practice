package happyjava.src.day17stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExam02 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Apple", "Cherry", "Date");

        //글자수가 5개 이상인 것만 필터링하고 중복 제거하고 새로운 리스트를 얻고 싶다면?
        //Stream 사용 X
        List<String> result1 = new ArrayList<>();

        for(String word : words) {
            if (word.length() >= 5)
                if(!result1.contains(word))
                    result1.add(word);
        }
        System.out.println(result1);

        //Stream 사용
        List<String> result2 = words.stream()
                .distinct() //중복제거
                .filter(s -> s.length() >= 5)
                .collect(Collectors.toList()); //가변 리스트 생성
        System.out.println(result2);

        List<String> result3 = words.stream()
                .distinct()
                .filter(s -> s.length() >= 5)
                .toList(); //불변 리스트 생성
    }
}

