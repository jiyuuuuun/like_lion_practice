package com.example.springdatajpa3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    private final EntityManager em;

    @Override
    public List<User> findUserByName(String name) {
        CriteriaBuilder criteriaBuilder=em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class); //쿼리를 생성하는 객체
        Root<User> userRoot=criteriaQuery.from(User.class); //엔티티 지정
        criteriaQuery.select(userRoot).where(criteriaBuilder.equal(userRoot.get("name"), name));
        //Select u from User u where u.name=name
        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<User> findusersDynamically(String name, String email) {
        CriteriaBuilder criteriaBuilder=em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> userRoot=criteriaQuery.from(User.class);

        List<Predicate> predicates=new ArrayList<Predicate>();
        if(name!=null){
            predicates.add(criteriaBuilder.equal(userRoot.get("name"), name));
        }
        if(email!=null){
            predicates.add(criteriaBuilder.equal(userRoot.get("email"), email));
        }
        criteriaQuery.select(userRoot).where(criteriaBuilder.and(predicates.toArray(new Predicate[0]))); //0번째 인덱스부터 끝까지 배열로 변환
        return em.createQuery(criteriaQuery).getResultList();
    }
}
