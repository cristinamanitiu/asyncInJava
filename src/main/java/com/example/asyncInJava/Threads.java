package com.example.asyncInJava;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Threads extends Thread{

  public static void main(String[] args){
    //simple Runnable
    Runnable runnable = () -> {
      String threadName = Thread.currentThread().getName();
      System.out.println("Hello runnable " + threadName);
      Integer sum = 0;
      for (int i = 0; i < 100000; i++) {
        sum = sum + i;
      }
      System.out
              .println("Sum for simple runnable thread " + threadName + " is " + sum);
    };
    runnable.run();


    Executor executor = Executors.newFixedThreadPool(3);

    //threads
    for (int i = 0; i < 5; i++) {
      getThread(i,i+100000).start();
    }

    //executor
    for (int i = 0; i < 5; i++) {
      executor.execute(useExecutor());
    }
  }

  private static Thread getThread(int start, int end) {
    Runnable runnable = () -> {
      String threadName = Thread.currentThread().getName();
      System.out.println("Hello Thread " + threadName);
      Integer sum = 0;
      for (int i = start; i < end; i++) {
        sum = sum + i;
      }
      System.out
          .println("Sum for thread " + threadName + " is " + sum);
    };
    return new Thread(runnable);
  }

  private static Runnable useExecutor() {
    Runnable runnable = () -> {
      String threadName = Thread.currentThread().getName();
      System.out.println("Hello Thread from Executor " + threadName);
      try {
        sleep(1000);
        System.out.println("Good Bye Thread from Executor " + threadName);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    };
    return runnable;
  }
}