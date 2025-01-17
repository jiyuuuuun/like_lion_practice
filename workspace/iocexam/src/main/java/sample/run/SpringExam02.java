package sample.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.bean.Book;
import sample.bean.Game;
import sample.bean.MyBean;
import sample.config.GameConfig;

public class SpringExam02 {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(GameConfig.class);

        Game game=context.getBean("game", Game.class);

        game.play();

        Book book=context.getBean("bbb",Book.class);

        MyBean myBean=context.getBean(MyBean.class);
        myBean.setName("jiyun");
        System.out.println(myBean.getName());



    }
}
