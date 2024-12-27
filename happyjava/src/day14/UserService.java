package happyjava.src.day14;

import java.io.FileWriter;
import java.io.IOException;

public class UserService {

    public static void saveUserTOFile(Person person){
        try(FileWriter fileWriter=new FileWriter("person.txt")) {
            fileWriter.write("Person: "+person.getName());
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류 발생");
        }
    }
}
