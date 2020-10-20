package com.example.asyncInJava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {
  @Autowired
  private ApplicationEventPublisher applicationEventPublisher;

  public void publishEvent(final String message) {
    String name = Thread.currentThread().getName();
    System.out.println("Publishing custom event in thread " + name);
    String myEvent = message;
    applicationEventPublisher.publishEvent(myEvent);
  }
}
