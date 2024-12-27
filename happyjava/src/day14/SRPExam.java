package happyjava.src.day14;

class Person{
    private String name;

    public Person(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
    //유저 정보 출력
    public void printPerson(){
        System.out.println("Person:: " + name);
    }
}

public class SRPExam {
    public static void main(String[] args) {
        Person person = new Person("지윤");
        person.printPerson();
        UserService.saveUserTOFile(person);
    }
}
