package day04;

public class AmbiguityExample {
    public static void print(int number) {
        System.out.println("Single int parameter");
    }

    public static void print(int... numbers) {
        System.out.println("Varargs: Multiple int parameters");
    }

    public static void main(String[] args) {
        print(10);      // 단일 int 전달
        print(10, 20);  // 두 개 이상의 int 전달
    }
}