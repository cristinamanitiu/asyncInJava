package com.example.asyncInJava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
  @Autowired
  private AsyncCaller asyncCaller;

  @Override
  public void run(String... args) throws Exception {
    asyncCaller.callBothAsync();
  // asyncCaller.callEvents(" my event!!!");

  }
}
