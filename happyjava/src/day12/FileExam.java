package happyjava.src.day12;

import java.io.File;
import java.io.IOException;

public class FileExam {
    public static void main(String[] args) {
        File file = new File("data.txt");

        Boolean b = file.isFile(); //파일이 있니?
        System.out.println(b);

        if(file.exists()){ //파일이 없나?
            try {
                file.createNewFile(); //새로운 파일을 만든다
                System.out.println("새로운 파일이 생성되었습니다" + file.getAbsolutePath());
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        //파일 정보 확인
        System.out.println("파일 이름: " + file.getName());
        System.out.println("파일 크기: " + file.length());
        System.out.println("읽기 가능: " + file.canRead());
        System.out.println("쓰기 가능: " + file.canWrite());
        System.out.println("디렉토리 유무: "+file.isDirectory());

        System.out.println(System.getProperty("user.dir")); //현재 경로

        File dir = new File("."); //. 현재 디렉토리

        System.out.println("디렉토리 유무: "+dir.isDirectory());
        String[] files=dir.list();

        for (String s : files) {
            System.out.println(s);
        }

    }
}
