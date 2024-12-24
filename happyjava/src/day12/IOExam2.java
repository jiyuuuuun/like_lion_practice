package happyjava.src.day12;

import java.io.*;

public class IOExam2 {
    public static void main(String[] args) throws IOException {
        //키보드로부터 5줄 입력 받아서 콘솔에 출력
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //FileWriter fileWriter=new FileWriter("happyjava/src/day12/FileOut.txt");
        //PrintWriter printWriter = new PrintWriter(fileWriter);
        PrintWriter printWriter = new PrintWriter("happyjava/src/day12/FileOut.txt");
        for (int i = 0; i < 5; i++) {
            String s=bufferedReader.readLine();
            //fileWriter.write(s);
            printWriter.println(s);
        }
        printWriter.close(); //close 시점에 파일에 글이 써짐
        //try-with-resource 사용하면 알아서 닫아줌
    }
}
