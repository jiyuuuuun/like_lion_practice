package happyjava.src.day14;

//전기차가 차를 상속 받게 되면서 부모가 가지고 있는 메서드가 대체될 수 없는 문제가 생김
//이럴 경우에는 상속관계를 갖게 하는것이 바람직하지 않다

//추상 클래스->다른 구현부 들도 가지고 있음

abstract class Vehicle{
    //차와 전기차가 가져야 하는 일반적인 속성이나 기능들을 구현
    public abstract void drive();
}
class Car extends Vehicle{
    private int fuel;

    Car(int fuel) {
        this.fuel=fuel;
    }

    public void drive(){
        if(fuel>0){ //연료가 0이상일때만 운행 가능
            fuel--; //운행시 연료 감소
            System.out.println("자동차가 운행 합니다. 남은 연료양: " + fuel);
        }else{
            System.out.println("운행할 수 없습니다. 연료가 없어요 ㅠㅡㅠ");
        }
    }

}

class ElectricCar extends Vehicle{
    private int battery;
    public ElectricCar(int battery){
        this.battery=battery;

    }
    @Override
    public void drive(){
        if(battery>0){ //연료가 0이상일때만 운행 가능
            battery--; //운행시 연료 감소
            System.out.println("자동차가 운행 합니다. 남은 배터리양: " + battery);
        }else{
            System.out.println("운행할 수 없습니다. 배터리가 없어요 ㅠㅡㅠ");
        }
    }
}
public class LSPExam2 {
    public static void main(String[] args) {
        Vehicle car = new Car(100);
        car.drive();

        Vehicle electricCar = new ElectricCar(100);
        electricCar.drive();

    }

}
