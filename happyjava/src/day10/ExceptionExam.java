package happyjava.src.day10;

//예외 처리하는 두가지 버전
//1. try-catch-finally
//2. throws Exception
public class ExceptionExam {
    //1. try-catch-finally
    // 예외가 발생 했지만 메서드 내에서 처리한 경우
    public static void method(){
        try {
        }catch (Exception e){
            System.out.println(e);
        }

    }
    //2. throws Exception
    // 예외가 발생 할 때 메서드를 호출 한 쪽이 예외 처리를 맡기는 경우 - checked Excepiton 발생 한 경우
    public static void methodB()throws Exception{


    }
    // 예외가 발생 할 떄 이 메서드를 호출한 쪽에 예외 처리를 맡기는 경우 - unchecked Exception이 발생 한 경우
    public static void methodC()throws RuntimeException{

    }

    public static void main(String[] args) {

        method();

        try {
            methodB();
        }catch( Exception e){
            System.out.println(e);
        }

        methodC();

    }
}
