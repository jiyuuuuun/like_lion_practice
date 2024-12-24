package happyjava.src.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class IOExam4 {
    public static void main(String[] args) throws IOException {
        URL url=new URL("https://likelion.net/my/courses");
        InputStream inputStream=url.openStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String s=null;
        while((s=bufferedReader.readLine())!=null) {
            System.out.println(s);
        }



    }
}
