package happyjava.src.day10;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateExam {
    public static void main(String[] args) {
        Date myBirthday = new Date(2001, 10, 21);
        System.out.println(myBirthday);

        Date now = new Date();
        System.out.println(now.before(myBirthday));

        System.out.println(now.getDate());

        //1. 달력이 교체 되었을 때 Calendar 클래스만 바꾸면 됨
        Calendar calendar=Calendar.getInstance(); //Calenar는 추상 클래스이므로 객체 생성 불가
        //2. 달력이 교체 되었을 때 다 고쳐야항
        Calendar calendar2=new GregorianCalendar(); //자식으로 생성

        System.out.println(calendar2);

        System.out.println(calendar2.getFirstDayOfWeek());

        System.out.println(calendar2.get(Calendar.YEAR));

        System.out.println((calendar2.get(Calendar.MONTH)) + 1); //0월~11월 +1월해줘야함

        calendar2.set(2001,9,21);//2001년 10월 21일 set.
        System.out.println((calendar2.get(Calendar.MONTH))+1);

        System.out.println(calendar2.getActualMaximum(Calendar.DATE)); //10월의 마지막 날
        System.out.println(calendar2.get(Calendar.DAY_OF_WEEK));//요일 일 1 ~
    }
}
