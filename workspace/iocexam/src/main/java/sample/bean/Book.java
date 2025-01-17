package sample.bean;

import org.springframework.stereotype.Component;

@Component("bbb")//id는 bbb로 등록 아무것도 안쓰면 클래스이름의 첫 글자를 소문자로 바꾼 아이디로 설정 됨
public class Book {
    private String title;
    private int price;

    public Book() {
        System.out.println("Book 생성");
    }
}
