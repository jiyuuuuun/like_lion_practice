package org.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) //각각 테이블 생성
@Getter@Setter
public class Vehicle2 {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
}
@Entity
@Getter@Setter
class Car2 extends Vehicle2 {
    private int seatCount;
}
@Entity
@Getter@Setter
class Truck2 extends Vehicle2 {
    private double payloadCapacity;
}
