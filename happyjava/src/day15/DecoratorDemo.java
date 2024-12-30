package happyjava.src.day15;
//커피주문
//에스프레소 + 물 = 아메리카노..
//에스프레소 + 우유
//에스프레소 + 우유 + 시럽
//에스프레소 + 우유 + 시럽 + 생크림

//모든 커피의 기본이 되는 공통 인터페이스 (컴포넌트 인터페이스)
interface Coffee{
    String getDescription(); //커피설명
    int getCost(); //가격
}

// 가장 기본적인 커피 (에스프레소) 구현 -  (기본 컴포넌트)
class Espresso implements  Coffee{
    @Override
    public String getDescription() {
        return "에스프레소";
    }

    @Override
    public int getCost() {
        return 3000;
    }
}

//장식이 되는 클래스를 구현
//표준 - 데코레이터 추상
abstract class CoffeeDecorator implements Coffee{
    protected Coffee decoratorCoffee;
    public CoffeeDecorator(Coffee coffee){
        this.decoratorCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratorCoffee.getDescription();
    }

    @Override
    public int getCost() {
        return decoratorCoffee.getCost();
    }
}

//구체적인 장식 클래스 구현 -- 추가할 옵션 클래스를 구현해서 커피 기능을 확장함.
//우유 추가
class MilkDecorator extends CoffeeDecorator{

    protected Coffee decoratorCoffee;
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getDescription() {
        return super.getDescription()+"우유";
    }

    @Override
    public int getCost() {
        return super.getCost()+500;
    }
}
//시럽 추가
class SyrupDecorator extends CoffeeDecorator{

    protected Coffee decoratorCoffee;
    public SyrupDecorator(Coffee coffee) {
        super(coffee);
    }
    @Override
    public String getDescription() {
        return super.getDescription()+"시럽";
    }

    @Override
    public int getCost() {
        return super.getCost()+500;
    }
}


public class DecoratorDemo {
    public static void main(String[] args) {
        //기본커피
        Coffee espresso = new Espresso();
        System.out.println(espresso.getDescription() + " 가격 : "+ espresso.getCost() + "원");

        Coffee milkCoffee = new MilkDecorator(espresso);
        System.out.println(milkCoffee.getDescription()+ " 가격 : "+milkCoffee.getCost() + "원");

        Coffee SyrupMilkCoffee = new SyrupDecorator(milkCoffee);
        System.out.println(SyrupMilkCoffee.getDescription()+ " 가격 : "+SyrupMilkCoffee.getCost() + "원");

    }
}