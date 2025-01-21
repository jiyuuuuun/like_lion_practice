package com.example.aopexam.proxyexam;

public class ServiceRun {

    public static void main(String[] args) {
        Service service=new ProxyService();

        service.perform();
    }
}
