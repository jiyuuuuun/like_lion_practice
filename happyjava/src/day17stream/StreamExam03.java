package happyjava.src.day17stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExam03 {
    public static void main(String[] args) {

        List<String> words = Arrays.asList("Apple", "Banana", "Cherry", "Apple", "Cherry", "Date");
        //각 요소를 소문자로 바꿔서 출력
        words.stream()
                .map(word -> word.toLowerCase())
                .forEach(word -> System.out.println(word));

        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("Apple", "Banana"),
                Arrays.asList("Cherry", "Date")
        );

        System.out.println(nestedList);
        List<String> flatList=nestedList.stream()
                .flatMap(Collection::stream) //리스트 평탄화
                .sorted(Comparator.reverseOrder()) //내림차순, 기본은 오름차순
                .collect(Collectors.toList());
        System.out.println(flatList);

        int[] arr={3,5,6,89,45,12,43,54};
        //위 배열을 오름차순으로 정렬해서 출력
        Arrays.stream(arr)
                .sorted() //오름차순 정렬 , IntStream 에서 기본형 int 만 지원
                .forEach(System.out::println);

        //내림차순으로 정렬해서 출력
        Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder()) //Integer
                .collect(Collectors.toList());


        int[] intArr={2,4,5,7,55,77};
        //각 요소에 3을 더해서 출력
        Arrays.stream(intArr)
                .map(x->x+3)
                .forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        //forEach 사용 예시
        numbers.stream()
                .forEach(n->System.out.println("Number : "+n));

        //peek 사용 예시
        List<Integer> doubleNumbers = numbers.stream()
                .peek(n-> System.out.println(n))
                .collect(Collectors.toList());
        System.out.println(doubleNumbers);


    }
}
