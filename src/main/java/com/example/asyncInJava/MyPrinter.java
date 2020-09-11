package com.example.asyncInJava;

import org.springframework.stereotype.Component;

@Component
public class MyPrinter {
    public void printForListener(String message){
        System.out.println("Printing happening in thread " + Thread.currentThread().getName());
        System.out.println("Event received: "+ message);
    }
}
