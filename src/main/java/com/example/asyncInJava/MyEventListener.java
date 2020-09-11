package com.example.asyncInJava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener {
  @Autowired
  private MyPrinter myPrinter;

  @Async("threadPoolTaskExecutor")
  @EventListener
  public void onEvent(String ev) {
    String name = Thread.currentThread().getName();
    System.out.println("Handling received event started in thread " + name);
    myPrinter.printForListener(ev);
  }
}
