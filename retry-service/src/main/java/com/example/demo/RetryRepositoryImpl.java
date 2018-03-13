package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class RetryRepositoryImpl implements RetryRepository {

	private int cnt;
	
	@Override
	public int getCount() {
		return cnt++;
	}

	@Override
	public void initializeCount() {
		cnt = 0;
	}

}
