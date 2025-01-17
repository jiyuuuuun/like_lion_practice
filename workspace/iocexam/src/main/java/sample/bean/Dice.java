package sample.bean;

import org.springframework.stereotype.Component;

@Component //기본은 생성자 주입
public class Dice {
    private int face;
    public Dice() {
        System.out.println("Dice Constructor");
    }
    public Dice(int face) {
        this.face = face;
        System.out.println("Dice Constructor(int) 실행");
    }

    public int getNumber(){
        return (int)(Math.random()*face)+1;
    }
}
