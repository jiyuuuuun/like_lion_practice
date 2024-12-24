package happyjava.src.day12;

import java.io.*;

public class IOExam {
    public static void main(String[] args) throws IOException {
        //키보드로부터 한줄씩 입력 받아서 출력하고 싶다
        //키보드 -> System.in ---InputStream
        //한줄씩 입력 받음 ---BufferedReader

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader는 생성자로 Reader 받음
        //하지만 System.in은 InputStream 이므로
        //InputStreamReader를 사용해서 연결 해줌

        System.out.println("입력");
        String string = bufferedReader.readLine();
        System.out.println(string);




        //파일로부터 한줄 씩 입력 받고 싶어요
        //파일로부터 -FileInputStream --파일 이름
        FileInputStream fileInputStream=new FileInputStream("happyjava/src/day11/Book.java");
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(fileInputStream));
        String s = bufferedReader1.readLine();
        System.out.println(s);

    }
}
