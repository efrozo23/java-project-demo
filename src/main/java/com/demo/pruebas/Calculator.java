package com.demo.pruebas;

public class Calculator {

	private long c;

	public long sum(int a, int b) {
		this.c = a;
		return c + b;
	}

	public long multiply(int a, int b) {
		this.c = a;
		return c * b;
	}

	public double division(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("Is not divisible by zero");
		}
		double d = a;
		return d / b;

	}

	public long summation(int n) {
		long m = n * this.sum(n, 1);
		return m / 2;
	}

}
