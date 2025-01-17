package sample.run;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sample.bean.Book;
import sample.bean.MyBean;
import sample.config.MyBeanConfig;

public class SpringExam01 {
    public static void main(String[] args) {
        //직접 사용하는 경우
        MyBean bean = new MyBean();
        bean.setName("abd");

        System.out.println(bean.getName());

        //spring ioc container 이용
        //빈 등록 1.XML 2.자바 컨피그 이용 3.에노테이션

        //스프링이 제공하는 공장을 통해서 사용
        //1.BeanFactory --단순한 일만 한다 AOP 같은 기술은 사용할 수 없다

        ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanConfig.class);

        MyBean bean1 = (MyBean) context.getBean("myBean"); //lookup 방식

        MyBean bean2 = context.getBean("myBean",MyBean.class); //lookup 방식+형변환 안해도 됨

        if(bean1==bean2) {
            System.out.println("같은 인스턴스 입니다");
        }else{
            System.out.println("다른 인스턴스 입니다");
        }

        MyBean bean3 = context.getBean("myBean2",MyBean.class);
        if(bean3==bean2) {
            System.out.println("같은 인스턴스 입니다");
        }else{
            System.out.println("다른 인스턴스 입니다");
        }

        MyBean bean4 = (MyBean) context.getBean("myBean3",MyBean.class);
        MyBean bean5 = (MyBean) context.getBean("myBean3",MyBean.class);

        if(bean4==bean5) {
            System.out.println("bean4 == bean5 같은 인스턴스");
        }else {
            System.out.println("bean4 != bean5 다른 인스턴스");
        }

        //id 없이 타입만 가지고 룩업 해줌
        //이 타입의 빈이 하나만 있어야함
        Book book = context.getBean(Book.class);
        System.out.println(book);



    }
}
