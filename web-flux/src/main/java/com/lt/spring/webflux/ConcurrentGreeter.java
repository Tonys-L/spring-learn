package com.lt.spring.webflux;

public class ConcurrentGreeter extends Greeter {
    public void greet() {
        Thread t = new Thread(System.out::println);
        t.start();
    }

    public void g(String i, String j) {
        System.out.println(i + j);
    }

    public static void main(String[] args) {
        new ConcurrentGreeter().greet();
    }
}
