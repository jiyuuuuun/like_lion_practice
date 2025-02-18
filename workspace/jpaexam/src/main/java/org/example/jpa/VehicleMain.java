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
                log.info(((Truck) vehicle).getPayloadCapacity()+"");
            }

            log.info("Vehicle id:{}",vehicle.getId());
            log.info("{}", ((Car) vehicle).getManufacturer());

            //jpql
            List<Vehicle> vehicles = em.createQuery("select v from Vehicle v",Vehicle.class).getResultList();
            for(Vehicle vehicle1: vehicles){
                if(vehicle1 instanceof Car){
                    Car car = (Car)vehicle1;
                    log.info(car.getManufacturer() +":::"+car.getSeatCount());
                }else {
                    Truck truck = (Truck) vehicle1;
                    log.info(truck.getManufacturer() +":::"+truck.getPayloadCapacity());
                    log.info(truck.getPayloadCapacity()+"");
                }
            }
            List<Object[]> results = em.createQuery("SELECT v.id, v.manufacturer, TYPE(v) FROM Vehicle v")
                    .getResultList();
            for (Object[] result : results) {
                System.out.println("ID: " + result[0] + ", Manufacturer: " + result[1] + ", Type: " + result[2]);
            }
        }finally {
            em.close();
        }
    }
}
