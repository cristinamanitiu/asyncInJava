package com.example.asyncInJava;

import java.util.concurrent.Executor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncInJavConfig {

  @Bean(name = "threadPoolTaskExecutor")
  public Executor threadPoolTaskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(2);
    executor.setMaxPoolSize(2);
    executor.setQueueCapacity(500);
    executor.setThreadNamePrefix("async-test-");
    executor.initialize();
    return executor;
  }

  @Bean(name = "threadPoolTaskExecutor2")
  public Executor threadPoolTaskExecutor2() {
    ThreadPoolTaskExecutor executor2 = new ThreadPoolTaskExecutor();
    executor2.setCorePoolSize(2);
    executor2.setMaxPoolSize(2);
    executor2.setQueueCapacity(500);
    executor2.setThreadNamePrefix("async-test2-");
    executor2.initialize();
    return executor2;
  }
}