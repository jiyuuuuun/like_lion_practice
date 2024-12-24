package happyjava.src.day12;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInputExam {
    public static void main(String[] args) {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("data.txt"));) {

            if(dataInputStream.readBoolean()){
                System.out.println("true인가요?");
            }
            byte b= dataInputStream.readByte();

            double d=dataInputStream.readDouble();

            System.out.println(b);
            System.out.println(d);

            //입력한 순서대로 출력해야함

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
