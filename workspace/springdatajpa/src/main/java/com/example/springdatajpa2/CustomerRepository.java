package com.example.springdatajpa2;

import com.example.springdatajpa.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    //이름으로 조회
    List<Customer> findByName(String name);

    //이메일로 조회
    List<Customer> findByEmail(String email);

    //이메일에 특정 문자열을 포함하고 있는 고객 조회
    List<Customer> findByEmailContaining(String email);
    List<Customer> findByEmailContaining(String email, Pageable pageable);

    //각 고객과 고객의 주문수를 알고 싶어요.
    @Query("SELECT c, count(o) FROM Customer c LEFT JOIN c.orders o GROUP BY c")
    List<Object[]> findCustomerAndOrderCount();


//    SELECT c.*, COUNT(o.id) AS order_count
//    FROM jpa_customer c
//    LEFT JOIN jpa_order o ON c.id = o.customer_id
//    GROUP BY c.id;

    //고객의 세부 정보와 그 고객의 가장 최근 주문 조회를 알고 싶어요.
    @Query("SELECT c, o FROM Customer c JOIN c.orders o WHERE o.date = (SELECT MAX(o2.date) FROM Order o2 WHERE o2.customer = c)")
    List<Object[]> findCustomerAndOrdersRecent();

//    SELECT c.*, o.*
//    FROM jpa_customer c
//    JOIN jpa_order o ON c.id = o.customer_id
//    WHERE o.date = (
//    SELECT MAX(o2.date)
//    FROM jpa_order o2
//    WHERE o2.customer_id = c.id
//    );

    //평균나이보다 많은 고객을 조회하고 싶어요.
    @Query("SELECT c FROM Customer c WHERE c.age > (SELECT avg(c2.age) FROM Customer c2)")
    List<User> findCustomerOlderThanAvg();

//    SELECT * FROM jpa_customer c
//    WHERE c.age > (SELECT AVG(c2.age) FROM jpa_customer c2);

}
