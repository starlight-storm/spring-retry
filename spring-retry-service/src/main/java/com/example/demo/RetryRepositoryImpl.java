package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class RetryRepositoryImpl implements RetryRepository {

	private int cnt;
	
	@Override
	public int retry() {
		return cnt++;
	}

	@Override
	public void clean() {
		cnt = 0;
	}

}
