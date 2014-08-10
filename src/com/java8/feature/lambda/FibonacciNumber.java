package com.java8.feature.lambda;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

public class FibonacciNumber {

	private static int fibonacci(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}

	private static int fibonacciOperation(Predicate<Integer> condition,
			BinaryOperator<Integer> operation) {
		System.out.println("Fibonacci numbers: ");
		int i = 0;
		int result = 0;
		int fibo = fibonacci(i);
		for (int temp = operation.apply(result, fibo); condition.test(temp); fibo = fibonacci(i), temp = operation
				.apply(result, fibo)) {
			System.out.print(fibo + " ");
			result = temp;
			i++;
		}
		System.out.println();
		return result;
	}

	public static void main(String[] args) {
		int range = 100;
		System.out.println("Sum of even fibonacci number less then "
				+ range
				+ " is "
				+ fibonacciOperation(i -> i < range,
						(sum, i) -> i % 2 == 0 ? sum + i : sum));
		System.out.println("Sum of odd fibonacci number less then "
				+ range
				+ " is "
				+ fibonacciOperation(i -> i < range,
						(sum, i) -> i % 2 != 0 ? sum + i : sum));
	}
}
