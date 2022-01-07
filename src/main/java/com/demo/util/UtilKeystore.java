package com.demo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Base64;

public class UtilKeystore {

	public static String createKeystore(String pathCert,String pathKeystore,String host) throws Exception {
		try (FileOutputStream fos = new FileOutputStream(pathKeystore)) {
			System.out.println("keystore type:" + KeyStore.getDefaultType());
			Certificate mycert = loadCertificate(pathCert);
			KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
			char[] pwdArray = "password".toCharArray();
			ks.load(null, pwdArray);
			ks.setCertificateEntry(host, mycert);
			ks.store(fos, pwdArray);
			File file = new File(pathKeystore);
			byte[] bytesFile = Files.readAllBytes(file.toPath());
			return Base64.getEncoder().encodeToString(bytesFile);
		} catch (Exception e) {
			//cambiar por exception personalizada
			throw new Exception(e.getMessage());
		}

	}

	public static Certificate loadCertificate(String pathCert) throws Exception {
		try (InputStream certificateInputStream = new FileInputStream(pathCert)) {
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			return cf.generateCertificate(certificateInputStream);
		} catch (Exception e) {
			//cambiar por exception personalizada
			throw new Exception(e.getMessage());
		}
	}

}
