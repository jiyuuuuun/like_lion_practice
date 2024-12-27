package happyjava.src.day13;

public class ExampleThread extends Thread {
    @Override
    public void run() {
        System.out.println("새로운 thread 시작.");
        for (int i = 0; i < 5; i++) {
            System.out.println("스레드 실행 중: " + i);
        }
        System.out.println("새로운 thread 끝.");
    }

    public static void main(String[] args) {
        System.out.println("main thread 시작.");
        ExampleThread thread = new ExampleThread();
        thread.start();
        System.out.println("main thread 끝.");
    }
}
