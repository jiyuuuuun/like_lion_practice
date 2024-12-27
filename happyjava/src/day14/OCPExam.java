package happyjava.src.day14;

interface DiscountMethod{
    public double discount(int price);
}

class Student implements DiscountMethod {
    @Override
    public double discount(int price) {
        return price*0.9;

    }
}
class DefaultCs implements DiscountMethod {
    @Override
    public double discount(int price) {
        return price;

    }
}
class Junior implements DiscountMethod {
    @Override
    public double discount(int price) {
        return price*0.5;

    }
}
class DiscountProcessor{
    public static double process(DiscountMethod discountMethod,int price){
        double d=discountMethod.discount(price);
        return d;
    }
}


public class OCPExam {
    public static void main(String[] args) {
        double price=0;
        price=DiscountProcessor.process(new DefaultCs(),15000);
        System.out.println("가격: " + price);

        price=DiscountProcessor.process(new Junior(),15000);
        System.out.println("가격: " + price);

        price=DiscountProcessor.process(new Student(),15000);
        System.out.println("가격: " + price);
    }
}
