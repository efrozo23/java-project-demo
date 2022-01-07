package com.demo.util;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.security.KeyStore;
import java.util.Base64;

public class UtilKeystore {
	
	public static String createKeystore() throws Exception {
		try (FileOutputStream fos = new FileOutputStream("newKeyStoreFileName.jks")){
			System.out.println("keystore type:" + KeyStore.getDefaultType());
			KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
			char[] pwdArray = "password".toCharArray();
			ks.load(null, pwdArray);
			ks.store(fos, pwdArray);
			File file = new File("newKeyStoreFileName.jks");
			byte[] bytesFile = Files.readAllBytes(file.toPath());
			return Base64.getEncoder().encodeToString(bytesFile);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

}
