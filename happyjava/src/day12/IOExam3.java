package happyjava.src.day12;

import java.io.*;

public class IOExam3 {
    public static void main(String[] args)  {
        int s;
        int count=0;
        try (FileInputStream fileInputStream = new FileInputStream("happyjava/src/day12/FileIn.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("happyjava/src/day12/FileOut.txt"))
        {
            byte[] buffer = new byte[1024];
            while((s=fileInputStream.read(buffer))!=-1){ //EOF 파일이 끝나면 -1을 반환해줌
                fileOutputStream.write(buffer, 0, s); //버퍼의 0번 인덱스부터 s 바이트만큼 데이터를 씁니다.
                count++;

            }

            System.out.println(count);
        }catch (Exception e){

        }


    }
}
