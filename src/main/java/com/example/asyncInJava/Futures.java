package com.example.asyncInJava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Futures {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executor2 = Executors.newFixedThreadPool(1);

    Future futureTask = executor2.submit(getFactorial(10));
    System.out.println(futureTask.get());
    for(int i=0; i<10; i++){
      System.out.println(Thread.currentThread().getName() + i);
    }

    //wait until is done
    Future future = executor2.submit(getFactorial(10));
    while (!future.isDone()) {
      System.out.println("FutureTask is not finished yet...");
    }
    System.out.println(future.get().toString());

    executor2.shutdown();
  }

  public static Callable getFactorial(int number) {
    Callable<String> callable = () -> {
      String threadName = Thread.currentThread().getName();
      System.out.println("Hello Thread " + threadName);
      Integer fact = 1;
      for (int i = 1; i < number; i++) {
        fact = fact * i;
      }
      return "For thread " + threadName + " factorial is " + fact;
    };

    return callable;
  }
}
