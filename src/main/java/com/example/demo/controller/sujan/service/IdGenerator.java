
package com.example.demo.controller.sujan.service;
import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private static AtomicLong numberGenerator = new AtomicLong(10000L);

    public static long getGenerateId() {
        return numberGenerator.getAndIncrement();
    }

   

}