package com.uningen.di;

import com.uningen.di.controllers.MyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class DiApplicationTests {

	@Autowired
	ApplicationContext applicationContext;

	@Test
	void testGetControllerFromCtx(){
		MyController myController = applicationContext.getBean(MyController.class);
		System.out.println(myController.sayHi());
	}
	@Test
	void contextLoads() {
	}

}
