package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
 * ControllerのSpring-Retryのサンプル。Retry回数は5回です。
 * localhost:8080/で初期化（retryのためのカウンタをクリア）
 * localhost:8080/nでn回Exceptionを発行し、Retryします。
 *   n<5だと"Hello!"が、n>=6だと"Retry Exception!"が戻ります。
 */
@RestController
public class RetryController {
	@Autowired
	RetryService retryService;
	
	@GetMapping("/{retryCount}")
	@Retryable(value = RetryException.class, maxAttempts = 5, backoff = @Backoff(delay = 500))
	public String m(@PathVariable int retryCount) {
		int cnt = retryService.getCount();
		if(cnt < retryCount) {
			System.out.println("***** " + "RETRY! " + cnt);
			throw new RetryException();
		}
		return "Hello!";
	}
	
    @Recover
    public String recover(RetryException exception) {
        return "Retry Exception!";
    }
    
	@GetMapping
	public void crear() {
		retryService.crearCount();
	}
}
