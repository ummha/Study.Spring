package com.company.ioc;

public class Main {

    public static void main(String[] args) {
        String url = "www.naver.com/book/it?page=10&size=20&name=spring-boot";

        // DI 원리
        Encoder encoder = new Encoder(new UrlEncoder());
        String result = encoder.encode(url);
        System.out.println("message: " + result);
        encoder = new Encoder(new Base64Encoder());
        result = encoder.encode(url);
        System.out.println("message: " + result);
    }
}
