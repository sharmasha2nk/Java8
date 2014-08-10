package com.java8.feature.lambda;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ValidPhoneNumber {

	public static void main(String[] args) {
		List<String> numbers = new LinkedList<>();
		numbers.add("+9134232323");
		numbers.add("+9123423422");
		numbers.add("3242342243");
		List<String> validNumbers = numbers.stream()
				.filter(s -> s.startsWith("+91")).collect(Collectors.toList());
		System.out.println(validNumbers);
	}
}
