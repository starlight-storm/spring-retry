package com.example.demo;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

public interface RetryService {
	@Retryable(value = RetryException.class, maxAttempts = 5, backoff = @Backoff(delay = 500))
	String retry(int retryCount);

	@Recover
    String recover(RetryException exception);
    
	void clean();
}
