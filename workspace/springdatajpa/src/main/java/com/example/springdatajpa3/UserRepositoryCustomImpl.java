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
    private final EntityManager entityManager;

    @Override
    public List<User> findUserByName(String name) {
        // CriteriaBuilder: Criteria 쿼리를 만들기 위한 팩토리 객체. 다양한 조건과 표현식을 생성할 수 있음.
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        // CriteriaQuery: 반환할 결과 타입(User)을 지정하며, 쿼리 구조(SELECT, WHERE 등)를 정의함.
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);

        // Root: 쿼리의 FROM 절에 해당하는 부분. 여기서는 User 엔티티가 기준이 됨.
        Root<User> user = query.from(User.class);

        // SELECT 절에서 user를 선택하고, WHERE 조건으로 name 필드가 포함된 값을 찾도록 지정.
        // criteriaBuilder.like()를 사용해서 SQL의 LIKE 연산자와 동일한 효과를 냄.
        query.select(user)
                .where(criteriaBuilder.like(user.get("name"), "%" + name + "%"));

        // 완성된 CriteriaQuery를 기반으로 실제 쿼리를 실행해 결과를 가져옴.
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<User> findusersDynamically(String name, String email) {
        // CriteriaBuilder를 사용하여 쿼리 생성 준비.
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> user = query.from(User.class);

        // 동적으로 WHERE 조건을 추가하기 위해 Predicate 리스트를 생성.
        List<Predicate> predicates = new ArrayList<>();

        // name 파라미터가 null이 아니라면, name 조건을 추가.
        if(name != null) {
            predicates.add(cb.equal(user.get("name"), name));
        }
        // email 파라미터가 null이 아니라면, email 조건을 추가.
        if(email != null) {
            predicates.add(cb.equal(user.get("email"), email));
        }

        // 리스트에 담긴 모든 조건들을 AND 연산자로 결합하여 WHERE 절에 설정.
        query.select(user)
                .where(cb.and(predicates.toArray(new Predicate[0])));

        // 위 주석처럼 사용자가 입력한 값에 따라 조건이 동적으로 생성됨.
        // 예시:
        // - name = null, email = null → 전체 User 조회 (WHERE 조건 없음)
        // - name != null, email = null → name 조건만 적용
        // - name = null, email != null → email 조건만 적용
        // - name != null, email != null → 두 조건 모두 적용

        // 실제 쿼리를 실행하고 결과 리스트를 반환.
        return entityManager.createQuery(query).getResultList();
    }
}
