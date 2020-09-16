package com.example.asyncInJava;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AsyncRunUnitTests {
    @Mock
    private AsyncRun asyncRun;

    @InjectMocks
    private AsyncCaller asyncCaller;

    final CountDownLatch latch = new CountDownLatch(1);

    @Test
    public void testVoid() throws Exception {
        asyncCaller.callAsyncVoid();
        verify(asyncRun, Mockito.timeout(1000).times(1)).asyncVoid();
    }

    @Test
    public void testWithResult() throws Exception {
        CompletableFuture<Integer> cf = new CompletableFuture<Integer>();
        cf.complete(120);

        when(asyncRun.asyncFactorial(anyInt())).thenReturn(cf);

        CompletableFuture<Integer> completableFuture = asyncCaller.callAsyncWithResult();
        assert(completableFuture.join()).equals(120);
        verify(asyncRun, Mockito.timeout(1000).times(1)).asyncFactorial(anyInt());
    }

    @Test
    public void testWithResultCountDownLatch() throws Exception {
        doAnswer((Answer<CompletableFuture>) invocation -> {
            CompletableFuture<Integer> cf = new CompletableFuture<Integer>();
            cf.complete(120);
            latch.countDown();
            return cf;
        }).when(asyncRun).asyncFactorial(anyInt());
        CompletableFuture completableFuture = asyncCaller.callAsyncWithResult();

        assert(latch.await(10L, TimeUnit.MILLISECONDS));
        assert(completableFuture.join()).equals(120);
    }
}
