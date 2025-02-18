package org.example.jpa;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class VehicleMain {
    public static void main(String[] args) {
        EntityManager em=JPAUtil.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        try {
//            Car car=new Car();
//            car.setManufacturer("Honda");
//            em.persist(car);
//
//            em.getTransaction().commit();

            Vehicle vehicle=em.find(Vehicle.class, 2L);

            if (vehicle instanceof Car){
                log.info(vehicle.getManufacturer());
                log.info(((Car) vehicle).getSeatCount()+"");
            }if(vehicle instanceof Truck){
                log.info(vehicle.getManufacturer());
                log.info(((Truck) vehicle).getPassengerCapacity()+"");
            }

            log.info("Vehicle id:{}",vehicle.getId());
            log.info("{}", ((Car) vehicle).getManufacturer());

            //jpql
            List<Vehicle> vehicles=em.createQuery("select v from Vehicle v", Vehicle.class).getResultList();
            for (Vehicle v : vehicles) {
                if(v instanceof Car) {
                    Car car=(Car)v;
                    log.info("Car SeatCount:{}",car.getSeatCount());
                }else{
                    Truck truck=(Truck)v;
                    log.info("Truck Manufacturer:{}",truck.getManufacturer());
                }
            }
        }finally {
            em.close();
        }
    }
}
