package com.demo.pruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class CalculatorTest {

	private Calculator calculator;


	private Calculator mockCalculator;

	@Before()
	public void setUp() {
		System.out.println("Instance created");
		this.calculator = new Calculator();
		this.mockCalculator  = Mockito.spy(Calculator.class);
	}

	@Test
	public void whenSumReturnOk() {
		long r = this.calculator.sum(2, 2);
		assertEquals(4, r);
	}

	@Test
	public void whenMultiplyReturnOk() {
		long r = this.calculator.multiply(4, 5);
		assertEquals(20, r);
	}

	@Test
	public void whenDivisionReturnOk() {
		double r = this.calculator.division(3, 2);
		assertEquals(1.5, r, 0);
	}

	@Test()
	public void whenDivisionThrowException() {
		assertThrows(ArithmeticException.class, () -> this.calculator.division(3, 0));
	}

	@Test()
	public void whenSummationReturnOK() {
		long r = this.calculator.summation(100);
		assertEquals(5050, r);
	}

	@Test()
	public void whenSummationReturnOkMockSum() {
		Mockito.doReturn(102l).when(this.mockCalculator).sum(100,1);
		assertEquals(5100, this.mockCalculator.summation(100));
	}

}
