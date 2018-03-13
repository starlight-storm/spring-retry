package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetryServiceImpl implements RetryService {

	@Autowired
	RetryRepository retryRepository;
	
	public String retryMethod(int retryCount) {
		int cnt = retryRepository.getCount();
		if(cnt < retryCount) {
			System.out.println("***** " + "RETRY! " + cnt);
			throw new RetryException();
		}
		return "Hello!";
	}

    public String recover(RetryException exception) {
		System.out.println("##### " + "RECOVER! ");
        return "Retry Exception!";
    }
    
	public void initializeCount() {
		retryRepository.initializeCount();
	}

}
