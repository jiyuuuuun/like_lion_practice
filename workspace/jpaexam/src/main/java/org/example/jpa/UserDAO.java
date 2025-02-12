package org.example.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDAO {
    EntityManagerFactory entityManagerFactory;

    //엔티티매니저가 달라지면 다 다른 엔티티컨텍스트
    UserDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("UserPU");
    }
    public void createUser(User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    public void updateUser(User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
    public void deleteUser(User user) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.contains(user) ? user : em.merge(user));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    public User findUserById(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            return em.find(User.class, id);
        }finally {
            em.close();
        }
    }
}
