package com.java8.feature.dinterface;

public class InterfaceImpl implements InterfaceA, InterfaceB {

	@Override
	public void print(String message) {
		System.out.println(message);
	}

	@Override
	public void printMessage() {
		InterfaceA.super.printMessage();
		System.out.println("Hello from interfaceImpl");
	}

	@Override
	public void printHelloTo(String to) {
		System.out.println("Hello to " + to + " from InterfaceImpl");
	}

	public void printMe() {
		System.out.println("This is InterfaceImpl");
	}

}
