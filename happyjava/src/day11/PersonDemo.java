package day11;
import java.util.*;

public class PersonDemo {
    public static void main(String[] args) {
        //Person을 여러명 저장하는 자료구조를 생각해보세요.

        Person person1 =
                new Person("123-111","kang","010-111-2222","강남구 역삼동");
        Person person2 =
                new Person("123-222","kim","010-111-3333","강남구 역삼동");
        Person person3 =
                new Person("123-333","hwang","010-111-4444","강남구 역삼동");
        Person person4 =
                new Person("123-444","lee","010-111-5555","강남구 역삼동");

        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);


        Set<Person> personSet = new HashSet<>();
        personSet.add(person1);
        personSet.add(person2);
        personSet.add(person3);
        personSet.add(person4);


        Map<String, Person> personMap = new HashMap<>();
        personMap.put(person1.getIdNumber(), person1);
        personMap.put(person2.getIdNumber(),person2);
        personMap.put(person3.getIdNumber(), person3);
        personMap.put(person4.getIdNumber(),person4);




        for(Person p:personList){
            if(p.getIdNumber().equals("123-333")){
                System.out.println(p);
            }
        }

        for(Person p:personSet){
            if(p.getIdNumber().equals("123-333")){
                System.out.println(p);
            }
        }

        Person findPerson=personMap.get("123-333");
        System.out.println(findPerson);




    }
}
