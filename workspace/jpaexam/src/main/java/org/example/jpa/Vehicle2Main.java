package org.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Vehicle2Main {
    public static void main(String[] args) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
//            Car2 car=new Car2();
//            car.setManufacturer("Honda");
//            car.setSeatCount(4);
//
//            Truck2 truck=new Truck2();
//            truck.setManufacturer("Honda");
//            truck.setPayloadCapacity(20);
//
//            em.persist(truck);
//            em.persist(car);
//            em.getTransaction().commit();

            Vehicle2 vehicle2=em.find(Vehicle2.class, 2L);
            if(vehicle2 instanceof Car2){
                log.info(((Car2) vehicle2).getSeatCount()+"");

            }if(vehicle2 instanceof Truck2){
                log.info(((Truck2) vehicle2).getPayloadCapacity()+"");
            }

        }finally {
            em.close();
        }
    }
}
