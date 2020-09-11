package com.example.asyncInJava;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncRun {

  @Async("threadPoolTaskExecutor2")
  public void asyncVoid() {
    System.out.println("Hello from void async thread -  "
        + Thread.currentThread().getName());
  }

  @Async
  public CompletableFuture<Integer> asyncFactorial(int number){
    Integer fact = 1;
    for(int i=1; i<=number; i++){
      fact= fact*i;
    }
    String name = Thread.currentThread().getName();
    System.out.printf("in factorial the thread is " + name + "\n");
    return CompletableFuture.completedFuture(fact);
  }

}
