package happyjava.src.day12;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutputExam {
    public static void main(String[] args) {
        //기본 데이터 타입으로 파일에 쓰고 싶다
        //파일에 저장하긴하지만 사람이 읽을 수 있는것이 아니라 시스템이 바로 읽을 목적으로 사용

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("data.txt")))
        {   dataOutputStream.writeBoolean(true);
            dataOutputStream.writeByte(Byte.MIN_VALUE);
            dataOutputStream.writeDouble(1.2);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
