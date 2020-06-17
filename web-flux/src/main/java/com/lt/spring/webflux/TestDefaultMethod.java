package com.lt.spring.webflux;

public interface TestDefaultMethod {
    default void print() {
        System.out.println("333");
    }
}
