package happyjava.src.day02;

public class OpExam {
    public static void main(String[] args) {
        for(int i=1;i<=100;i++) {
            String a = (i % 2 == 0) ? "짝수" : "홀수";
            System.out.println(a);
        }
    }
}
