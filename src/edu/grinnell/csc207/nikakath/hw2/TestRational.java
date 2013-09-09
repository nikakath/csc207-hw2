package edu.grinnell.csc207.nikakath.hw2;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * This is the test file for Rational, as required by Part D of Assignment 2.
 */

public class TestRational {


	@Test
	public void testAll() {
		
		//Test Constructors
		Rational a = new Rational(1);
		Rational b = new Rational(3, 8);
		Rational c = new Rational(b);
		
		//Test get/set numerator methods
		for(int i=-10; i<=10; i++){
			a.setNumerator(i);
			assertEquals("Numerator", i, a.numerator());
		} //for
		
		//Test get/set denominator methods
		for(int i=-10; i<=10; i++){
			a.setDenominator(i);
			assertEquals("Denominator", i, a.denominator());
		} //for
		
		//Test decimal
		b.setDenominator(4);
		for(int i=-10; i<=10; i++){
			b.setNumerator(i);
			assertEquals("Decimal quarters", .25*(double)i, b.decimal(), 0.001); //[1]
		}
		
		//Test addition
		a.setNumerator(1);
		a.setDenominator(1);
		for(int i=-10; i<=10; i++){
			Rational sum = new Rational(a.add(i));
			assertEquals("Integer addition", 1+i, (int)sum.decimal());
		}
		
	} //testAll()
} //TestRational

/*CITATIONS: 
 * [1] Assistance with the assertEquals(String, double, double, double) call came from:
 * jberg (2011). Meaning of epsilon argument of assertEquals for double values. StackOverflow. Available at 
 * http://stackoverflow.com/questions/5686755/meaning-of-epsilon-argument-of-assertequals-for-double-values 
 * (Last modified 16 April 2011; Visited 8 September 2013).
 */