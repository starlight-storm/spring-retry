package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class RetryServiceImpl implements RetryService {

	private int cnt;
	
	@Override
	public int getCount() {
		return cnt++;
	}

	@Override
	public void crearCount() {
		cnt = 0;
	}

}
