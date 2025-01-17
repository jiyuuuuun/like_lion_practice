package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import sample.bean.Book;
import sample.bean.MyBean;


public class MyBeanConfig {
    //스프링 공장에게 어떤 빈을 관리하게 할것인지 알려줘야 함
    //XML
    //<bean id="myBean" class = "sample.been.MyBeen"/>
    //기본 설정이 싱글턴
    //아이디가 다르면 다른 객체 생성
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
    @Bean
    public MyBean myBean2() {
        return new MyBean();
    }

    @Bean
    @Scope("prototype") // 매번 다른 객체가 생성
    public MyBean myBean3() {
        return new MyBean();
    }

    @Bean
    public Book book() {
        return new Book();
    }

}
