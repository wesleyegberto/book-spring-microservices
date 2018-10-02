package com.github.wesleyegberto.springmicroservices.chapt2actuator.metrics;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.LongAdder;

public class TPSCounter {
	private LongAdder count;
	private int threshold = 2;
	private LocalDateTime expiry = null;

	public TPSCounter() {
		this.count = new LongAdder();
		this.expiry = LocalDateTime.now().plusSeconds(30);
	}

	public boolean isExpired() {
		return LocalDateTime.now().isAfter(expiry);
	}

	public boolean isWeak() {
		if (isExpired()) return false;
		return (count.intValue() > threshold);
	}

	public void increment() {
		count.increment();
	}
}