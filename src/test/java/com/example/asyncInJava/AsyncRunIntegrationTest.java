package com.example.asyncInJava;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.CompletableFuture;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AsyncInJavaApplication.class)
public class AsyncRunIntegrationTest {
    @Autowired
    AsyncCaller asyncCaller;

    @Test
    public void test(){
        CompletableFuture completableFuture = asyncCaller.callAsyncWithResult();
        assert(completableFuture.join()).equals(3628800);
    }
}
