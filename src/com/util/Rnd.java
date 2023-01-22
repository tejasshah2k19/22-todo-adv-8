package com.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.TimeZone;

public class Rnd {

	public static void main(String[] args) {

		LocalDateTime t1 = LocalDateTime.now();
		LocalDateTime t2 = LocalDateTime.now();
		t2 = t2.plusSeconds(60 * 5);

		System.out.println(t1);
		System.out.println(t2);

		long diff = Duration.between(t1, t2).getSeconds();
		System.out.println(diff/60);
	}
}
