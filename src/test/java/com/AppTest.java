package com;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class AppTest {
	App app;
	
	@Before
	public void init(){
		app = new App();
	}
	
	@Test
	public void testSayHello(){
		Assert.assertEquals("LVS", app.satHello());
	}
}
