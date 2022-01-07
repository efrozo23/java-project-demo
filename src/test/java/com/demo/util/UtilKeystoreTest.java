package com.demo.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class UtilKeystoreTest {
	
	@Test
	public void createKeystoreWhenGenerateFile() throws Exception {
		String result = UtilKeystore.createKeystore();
		System.out.println("Resultado " + result);
		assertNotNull(result);
	}

}
