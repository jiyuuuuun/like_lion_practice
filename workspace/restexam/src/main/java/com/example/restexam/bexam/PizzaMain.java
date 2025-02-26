package com.example.restexam.bexam;

public class PizzaMain {
    public static void main(String[] args) {
        Pizza pizza = new Pizza("L",true,true,true);
        System.out.println(pizza);

        Pizza pizza2 = Pizza.builder()
                .size("s")
                .cheese(true)
                .pepperoni(true)
                .mushroom(false)
                .build();
        System.out.println(pizza2);

        Pizza pizza3 = Pizza.builder()
                .size("m").build();
        System.out.println(pizza3);
    }
}
