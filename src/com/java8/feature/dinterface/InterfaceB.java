package com.java8.feature.dinterface;

public abstract interface InterfaceB {

	abstract void print(String message);

	default void printHelloTo(String to) {
		System.out.println("Hello to " + to + " from InterfaceB");
	}

	static void printMe() {
		System.out.println("I am InterfaceB");
	}
}
