package happyjava.src.day17;

public class MyFunctionalInterfaceTest {
    public static void main(String[] args) {

        MyFunctionalInterface myFunctionalInterface = new MyFunctionalInterface() {
            @Override
            public int myMethod(int x, int y) {
                return x + y;
            }
        };

        System.out.println(myFunctionalInterface.myMethod(1, 2));

        myFunctionalInterface = (int x, int y) -> x + y;
        System.out.println(myFunctionalInterface.myMethod(1, 4));

    }
}
