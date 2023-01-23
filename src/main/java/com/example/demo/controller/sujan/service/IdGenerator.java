
package com.example.demo.controller.sujan.service;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
	private static final AtomicLong TS = new AtomicLong();

	public static long getGenerateId() {
		long micros = System.currentTimeMillis() * 100;
		for (;;) {
			long value = TS.get();
			if (micros <= value)
				micros = value + 1;
			if (TS.compareAndSet(value, micros))
				return micros;
		}
	}

}