package com.example.springdatajpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Slf4j
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
    @Bean
//  @Transactional
    public CommandLineRunner run(CustomerRepository repository,CustomerService service){
        return args -> {
//          repository.findAll().forEach(customer -> log.info(customer.getName()));
//            Customer customer = repository.findById(1L).get();  //이때 트랜잭션이 종료됨.
////            log.info(customer.getName());
////            customer.getOrders().forEach(order -> log.info(order.getProduct()));
//            List<Order> orders = customer.getOrders();  //레이지 로딩이 일어나는 시점.  // 트랜잭션안에 없는 상태.
//            orders.forEach(order -> log.info(order.getProduct()));
//            service.getCustomer(1L);

            //이름으로 조회하고 싶다.
            List<Customer> customer1 = repository.findByName("최지현");
            customer1.forEach(customer -> log.info("이름으로 조회 :: {} , {} ",customer.getName(), customer.getEmail()));

            //이메일로 조회
            repository.findByEmail("kim@example.com").
                    forEach(customer -> log.info("이메일로 조회 :: {} , {} ", customer.getName(),customer.getEmail()));

            //이메일에 특정 문자열을 포함 하고 있는 고객 조회
            log.info("이메일에 특정 문자열을 포함 하고 있는 고객 조회");
            repository.findByEmailContaining("exam")
                    .forEach(customer -> log.info("이메일로 조회 :: {} , {} ", customer.getName(),customer.getEmail()));

            //각 고객과 고객의 주문수를 알고 싶어요.
//            @Query("SELECT c, count(o) FROM Customer c LEFT JOIN c.orders o GROUP BY c")
            log.info("각 고객과 고객의 주문수를 알고 싶어요.");
            List<Object[]> customerOrderCounts = repository.findCustomerAndOrderCount();
            log.info("결과 ::::  "+customerOrderCounts.size());
            customerOrderCounts.forEach(result->{
                Customer customer = (Customer) result[0];
                Long count = (Long)result[1];
                log.info("고객 :: "+ customer.getName()+ ",  주문 수 :: "+ count);
            });
            //고객의 세부 정보와 그 고객의 가장 최근 주문 조회를 알고 싶어요.
//            @Query("SELECT c, o FROM Customer c JOIN c.orders o WHERE o.date = (SELECT MAX(o2.date) FROM Order o2 WHERE o2.customer = c")
            log.info("고객의 세부 정보와 그 고객의 가장 최근 주문 조회를 알고 싶어요.");
            List<Object[]> latestOrders = repository.findCustomerAndOrdersRecent();
            latestOrders.forEach(result ->{
                Customer customer = (Customer) result[0];
                Order order=(Order) result[1];
                log.info("고객 ::  {} , 최근 주문 :: {}", customer.getName(), order.getProduct());
            });
            //평균나이보다 많은 고객을 조회하고 싶어요.
//            @Query("SELECT c FROM Customer c WHERE c.age > (SELECT avg(c2.age) FROM Customer c2)")
            log.info("평균나이보다 많은 고객을 조회하고 싶어요.");
            repository.findCustomerOlderThanAvg()
                    .forEach(customer -> log.info("평균나이 이상의 고객 :: "+customer.getName()));
            Pageable pageable = PageRequest.of(0,3);
            repository.findByEmailContaining("exam",pageable)
                    .forEach(customer -> log.info("페이징 처리된 customer :: {},{}",customer.getName(),customer.getEmail()));
        };
    }
}