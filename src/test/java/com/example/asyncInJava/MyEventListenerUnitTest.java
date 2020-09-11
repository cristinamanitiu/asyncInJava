package com.example.asyncInJava;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MyEventListenerUnitTest {
    @InjectMocks
    MyEventListener myEventListener;

    @Mock
    AsyncCaller asyncCaller;

    @Mock
    MyPrinter printer;

    @Test
    public void testEventListener(){
        asyncCaller.callEvents("test");
        myEventListener.onEvent("test");
        verify(printer, times(1)).printForListener("test");
    }
}
