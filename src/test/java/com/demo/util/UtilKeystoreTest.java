package com.demo.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class UtilKeystoreTest {
	
	private ClassLoader classLoad;
	
	@Before
	public void setup() {
		classLoad = UtilKeystoreTest.class.getClassLoader();
	}
	
	@Test
	public void createKeystoreWhenGenerateFile() throws Exception {
		String pathCert = classLoad.getResource("mycert.cert").getPath();
		String pathKeystore = classLoad.getResource("").getPath() + "mykeystore.jks";
		System.out.println(pathKeystore);
		String result = UtilKeystore.createKeystore(pathCert,pathKeystore,"myhost");
		System.out.println("Resultado " + result);
		assertNotNull(result);
	}

}
