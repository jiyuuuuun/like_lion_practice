package com.example.restexam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter@Setter
@NoArgsConstructor
public class Todo {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String todo;  // 할 일 내용
    private boolean done; // 완료 여부
}