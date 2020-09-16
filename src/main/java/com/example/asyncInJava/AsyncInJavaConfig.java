package com.example.asyncInJava;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncInJavaConfig {

  @Bean(name = "threadPoolTaskExecutor")
  public Executor threadPoolTaskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(2);
    executor.setMaxPoolSize(2);
    executor.setThreadNamePrefix("async-test-");
    executor.initialize();
    return executor;
  }

  @Bean(name = "threadPoolTaskExecutor2")
  public Executor threadPoolTaskExecutor2() {
    ThreadPoolTaskExecutor executor2 = new ThreadPoolTaskExecutor();
    executor2.setCorePoolSize(5);
    executor2.setMaxPoolSize(5);
    executor2.setThreadNamePrefix("async-test2-");
    executor2.initialize();
    return executor2;
  }
}