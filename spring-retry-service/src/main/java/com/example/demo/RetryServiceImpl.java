package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryServiceImpl implements RetryService {

	@Autowired
	RetryRepository retryRepository;
	
	//@Retryable(value = RetryException.class, maxAttempts = 5, backoff = @Backoff(delay = 500))
	public String retry(int retryCount) {
		int cnt = retryRepository.retry();
		if(cnt < retryCount) {
			System.out.println("***** " + "RETRY! " + cnt);
			throw new RetryException();
		}
		return "Hello!";
	}

	//@Recover
    public String recover(RetryException exception) {
		System.out.println("##### " + "RECOVER! ");
        return "Retry Exception!";
    }
    
	public void clean() {
		retryRepository.clean();
	}

}
