package org.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//@Entity
@MappedSuperclass //@Entity 로 사용했을때 생성되는 불필요한 Vehicle3 클래스가 생성되지 않는다.
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //구체적인 테이블을 각각 만들어서 사용
@Getter@Setter
public class Vehicle3 {
    @Id@GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String manufacturer;
}
@Entity
@Getter@Setter
class Car3 extends Vehicle3 {
    private int seatCount;
}
@Entity
@Getter@Setter
class Truck3 extends Vehicle3 {
    private double payloadCapacity;
}
