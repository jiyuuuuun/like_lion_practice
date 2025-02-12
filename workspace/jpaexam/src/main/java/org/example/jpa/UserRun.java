package org.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UserRun {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserPU");
        EntityManager entityManager = emf.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        //Entity
        User user = new User();
        //user.setId(2L);
        user.setName("jiyun");
        user.setEmail("jiyun@exam.com");
        //엔티티가 생성 - 아직 영속성 컨텍스트와는 관계없는 상태(비영속상태)

        //영속성 컨텍스트가 관리하도록 함.
        entityManager.persist(user);
        //JPA나 Hibernate 같은 ORM(Object-Relational Mapping) 도구는 객체를 DB에 저장할 때, 객체의 ID 값을 사용해서 객체와 DB의 데이터를 연결
        //Identity 특징:ID를 미리 알 수 없어서 JPA에서는 persist()를 호출하면 즉시 INSERT 실행됨
        //왜 미리 알아야하나? 이 객체가 새로 생긴것인지 원래 있던 객체인지 알아야 insert,update 중 선택함

        //조회  select
        //영속성 컨텍스트를 통해서 조회를 한다.
        User user2 = entityManager.find(User.class, 6L);
        User user3 = entityManager.find(User.class, 6L);

        //같은 컨텍스트에서 받아왔으므로 같은 주소
        if(user2 == user3)
            System.out.println("user==user2");
        else
            System.out.println("user != user2");

        //수정 (update)
        User user4 = entityManager.find(User.class, 1L);
        user4.setName("kang");   //DB에 바로 접근해서 일하지 않아요.
        //트랜잭션이 종료될때 까지는 영속성 컨텍스트에서만 관리해요.


        //중간에 다른일들을 수행
        User user5 = entityManager.find(User.class,1L);
        user5.setName("carami"); //여기까지 수정하면 Select 한번만 실행, 스냅샵으로 비교했을 때 바뀌지 않아 수정(update)안됨

        //삭제
        User user6 = entityManager.find(User.class,1L);
        entityManager.remove(user6);

        System.out.println("실행전");
        transaction.commit();//영속성 컨텍스트틀 분석해서 알맞는 동작을 한다.
        // insert는 미리 실행되었지만 커밋을 해야 데이터베이스에 적용 됨
        System.out.println("실행후");
    }

    }

