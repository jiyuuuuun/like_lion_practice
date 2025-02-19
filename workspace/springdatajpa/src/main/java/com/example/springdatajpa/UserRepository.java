package com.example.springdatajpa;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
      List<User> findByUsername(String username);

      List<User> findByEmail(String email);

      List<User> findByNameContaining(String name); //select * from jpa_user where name like %name%

      List<User> findByNameAndEmail(String name,String email);

      List<Customer> findByEmailContaining(String email, Pageable pageable);

      //jpql vs sql --차이점
      //jpql --대상: 엔티티
      //sql --대상: 테이블
    @Query("SELECT u FROM User u where u.name= :name")
    List<User> selectUser(@Param("name")String name);
    @Query("select u from User u where u.name LIKE %:name%")
    List<User> selectUserLikeName(@Param("name") String name);

    @Transactional
    @Modifying //수정
    @Query("delete from User u where u.email=:email")
    void deleteUser(@Param("email")String email);

    @Transactional
    @Modifying
    @Query("update User u set u.email= :email where u.id=:id")
    void updateUser(@Param("id")Long id, @Param("email")String email);

    @Query(nativeQuery = true, value = "select * from jpa_user where name like %:name%") //nativeQuery = true->sql 사용
    List<User> findByHong(@Param("name")String name);

    @Query(nativeQuery = true,value = "SELECT * FROM jpa_user WHERE email like %?1%") //?사용
    List<User> selByEmail(String email);

    List<User> findByNameContaining(String name, Pageable pageable);




}
