package com.example.demo.common.converter;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

// 암복호화를 위한 컨버터
@Converter
public class CryptoConverter implements AttributeConverter<String, String> {
	private static final String ALGORITHM = "AES/ECB/PKCS5Padding";
	private static final byte[] KEY = "pskpskpskpskpskp".getBytes();

	@Override
	public String convertToDatabaseColumn(String attribute) {
		Key key = new SecretKeySpec(KEY, "AES");
		try {
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			return new String(Base64.getEncoder().encode(cipher.doFinal(attribute.getBytes())));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String convertToEntityAttribute(String dbData) {
		Key key = new SecretKeySpec(KEY, "AES");
		try {
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, key);
			return new String(cipher.doFinal(Base64.getDecoder().decode(dbData)));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
