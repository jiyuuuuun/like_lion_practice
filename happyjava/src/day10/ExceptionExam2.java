package happyjava.src.day10;

public class ExceptionExam2 {

    public static void 심부름() {
        System.out.println("심부름 시작!");
        int i=0;
        try {
            System.out.println(10/i);
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("심부름 끝!");
    }

    public static void 심부름2() throws Exception {
        System.out.println("심부름 시작!");
        int i=0;
        System.out.println(10/i);
        System.out.println("심부름 끝!");
    }

    public static void main(String[] args) {
        심부름();

        try {
            심부름2();
        }catch (Exception e){
            System.out.println("동생한테 시켜");
        }
    }
}
