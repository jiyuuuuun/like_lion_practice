package practice.src.day250205;

//주어진 정수 배열에서 최대값을 찾아 출력하라.
//람다식을 사용하여 자바의 Comparator 인터페이스와 함께 Arrays.sort()를 활용하라.
public class LambdaMaxValue {
    public static void main(String[] args) {
        Integer[] numbers = {4, 2, 7, 1, 3};
        // 람다식을 사용하여 배열을 정렬하라
        // 최대값 출력
        System.out.println("최대값은: " + numbers[0]);
    }
}