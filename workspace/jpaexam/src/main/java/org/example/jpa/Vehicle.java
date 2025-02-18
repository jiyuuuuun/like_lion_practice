package org.example.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //부모 객체이며, 상속 전략을 무엇을 사용할건지 알려줘야함(테이블 하나)
@DiscriminatorColumn(name ="type", discriminatorType = DiscriminatorType.STRING) //자식 객체를 구별할 필드
@Getter@Setter
public class Vehicle {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
}
