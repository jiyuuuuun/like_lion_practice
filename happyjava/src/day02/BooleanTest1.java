package day02;

public class BooleanTest1 {
    public static void main(String[] args) {
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        boolean flag4 = false;
        boolean flag5 = false;

        flag1 = 10 > 5;       // true
        flag2 = 10 < 5;       // false
        flag3 = 10 >= 10;     // true
        flag4 = 10 <= 10;     // true
        flag5 = 10 == 10;     // true

        System.out.println(flag1);  // true
        System.out.println(flag2);  // false
        System.out.println(flag3);  // true
        System.out.println(flag4);  // true
        System.out.println(flag5);  // true

    }
}
