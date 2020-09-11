package com.example.asyncInJava;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutures {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    CompletableFuture<Integer> completableFuture = CompletableFuture
        .supplyAsync(() -> factorial(5));

    String name = Thread.currentThread().getName();
    System.out.printf("out of completable future the thread is " + name + "\n");

    completableFuture
        .thenApplyAsync((result) -> {
          String threadName = Thread.currentThread().getName();
          System.out.println("async -> in thread " + threadName + " result before apply is " + result + "\n");
          return result * 10;
        })
        .thenAcceptAsync((res) -> {
          String threadName = Thread.currentThread().getName();
          System.out.println("async -> in thread " + threadName + " final result is " + res);
        });


      completableFuture
              .thenApply((result) -> {
                  String threadName = Thread.currentThread().getName();
                  System.out.println("in thread " + threadName + " result before apply is " + result + "\n");
                  return result * 10;
              })
              .thenAccept((res) -> {
                  String threadName = Thread.currentThread().getName();
                  System.out.println("in thread " + threadName + " final result is " + res);
              });
  }

  private static Integer factorial(int number){
    int fact = 1;
      for(int i=1; i<=number; i++){
        fact= fact*i;
      }
    String name = Thread.currentThread().getName();
    System.out.printf("in factorial the thread is " + name + "\n");
      return fact;
  }
}
