package com.example.aopexam.proxyexam;

public class ProxyService implements Service {

    private  RealService realService;

    @Override
    public void perform() {
        if (realService == null) {
            realService = new RealService();
        }
        System.out.println("추가로 해야하는 작업을 수정");
        realService.perform();
        System.out.println("aop가 구현한 코드라던지 추가로 수정해야하는 작업들을 수행");
    }
}
