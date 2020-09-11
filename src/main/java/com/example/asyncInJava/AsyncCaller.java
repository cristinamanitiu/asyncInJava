package com.example.asyncInJava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AsyncCaller {
    @Autowired
    AsyncRun asyncRun;

    @Autowired
    EventPublisher eventPublisher;


    public void callAsyncVoid(){
        asyncRun.asyncVoid();
    }

    public CompletableFuture callAsyncWithResult(){
        CompletableFuture<Integer> result = asyncRun.asyncFactorial(10);
        result.thenAccept((res) -> System.out.println("Result of factorial is " + res));
        return result;
    }

    public void callEvents(String message){
        String name = Thread.currentThread().getName();
        System.out.println("Current thread is " + name);
        eventPublisher.publishEvent(message);
    }

    public void callBothAsync(){
        callAsyncVoid();
        callAsyncWithResult();
    }
}
