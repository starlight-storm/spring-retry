package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
 * ServiceインタフェースのSpring-Retryのサンプル。Retry回数は5回です。
 * localhost:8080/で初期化（retryのためのカウンタをクリア）
 * localhost:8080/nでn回Exceptionを発行し、Retryします。
 *   n<5だと"Hello!"が、n>=6だと"Retry Exception!"が戻ります。
 */
@RestController
public class RetryController {
	@Autowired
	RetryService retryService;
	
	@GetMapping("/{retryCount}")
	public String m(@PathVariable int retryCount) {
		return retryService.retry(retryCount);
	}
    
	@GetMapping
	public void crean() {
		retryService.clean();
	}
}
