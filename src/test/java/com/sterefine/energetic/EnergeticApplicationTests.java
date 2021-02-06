package com.sterefine.energetic;

import com.sterefine.energetic.async.http.service.TestAsyncService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnergeticApplicationTests {

	private ArrayList<Object> list;

	@Test
	public void contextLoads() {
		    final TestAsyncService testAsyncService = new TestAsyncService();
	}

}
