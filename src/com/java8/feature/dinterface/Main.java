package com.java8.feature.dinterface;

public class Main {
	public static void main(String[] args) {
		InterfaceA a = new InterfaceImpl();
		a.print("hello");
		a.printMessage();
		InterfaceA.printMe();
		a.printHelloTo("Default Interface Method");
		InterfaceB b = new InterfaceImpl();
		b.print("world");
		b.printHelloTo("Default Interface Method");
		InterfaceB.printMe();
	}
}
