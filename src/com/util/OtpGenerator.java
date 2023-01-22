package com.util;

public class OtpGenerator {

	public static String generateOtp(int size) {

		String aNs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
//		String aNs =  "0123456789";
		StringBuilder sb = new StringBuilder(size);

		for (int i = 0; i < size; i++) {
			sb.append(aNs.charAt((int) (aNs.length() * Math.random())));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println((int) (Math.random() * 100));// 99//09.384576489
		System.out.println(OtpGenerator.generateOtp(5));
		System.out.println(OtpGenerator.generateOtp(7));

	}
}
