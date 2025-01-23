package com.example.springmvc.domain;


public class Item {
    private String name; // 아이템의 이름을 저장하는 변수
    private double price; // 아이템의 가격을 저장하는 변수

    // 생성자: name과 price를 초기화
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // name 변수의 값을 반환하는 메서드
    public String getName() {
        return name;
    }

    // price 변수의 값을 반환하는 메서드
    public double getPrice() {
        return price;
    }
}
