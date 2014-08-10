package com.java8.feature.dinterface;

public interface InterfaceA {

	void print(String message);

	default void printMessage() {
		System.out.println("Hello from InterfaceA");
	}

	default void printHelloTo(String to) {
		System.out.println("Hello to " + to + " from InterfaceA");
	}

	static void printMe() {
		System.out.println("I am InterfaceA");
	}
}
