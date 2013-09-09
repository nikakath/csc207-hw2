package edu.grinnell.csc207.nikakath.hw2;

import static org.junit.Assert.*;
import java.lang.Math;

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
		Rational d = new Rational();
		
		//Test get/set numerator methods
		for(int i=-10; i<=10; i++){
			a.setNumerator(i);
			assertEquals("Numerator", i, a.numerator());
		} //for
		
		//Test get/set denominator methods
		for(int i=-10; i<=10; i++){
			if(i != 0){
				a.setDenominator(i);
				assertEquals("Denominator", i, a.denominator());
			}//if
		} //for
		try{    //[1]
			a.setDenominator(0);
		} catch(IllegalArgumentException e){
		    System.err.println("IllegalArgumentException: " + e.getMessage());
		}//try/catch
		
		//Test decimal
		for(int i=-10; i<=10; i++){
			if(i != 0){
				b.setDenominator(i);
				for(int j=-10; j<=10; j++){
					b.setNumerator(j);
					assertEquals("Decimal: " + j + "/" + i, (double)j / (double)i, b.decimal(), 0.000001); //[2]
				}//for(j)
			}//if
		}//for(i)
		
		//Test simplify
		for(int i=-10; i<= 10; i++){
			if(i!=0){
				a.setDenominator(i);
				a.setNumerator(i);
				a.simplify();
				assertEquals("Simplify to one (numerator)", 1, a.numerator());
				assertEquals("Simplify to one (denominator)", 1, a.denominator());

				b.setDenominator(2 * i);
				b.setNumerator(i);
				b.simplify();
				assertEquals("Simplify to one half (numerator)", 1, b.numerator());
				assertEquals("Simplify to one half (denominator)", 2, b.denominator());
				
				c.setDenominator(i);
				c.setNumerator(i + 1);
				c.simplify();
				assertEquals("Already simplified (numerator)", Math.abs(i+1), c.numerator());
				assertEquals("Already simplified (denominator)", Math.abs(i), c.denominator());
				
				d.setDenominator(i);
				d.setNumerator(0 - i);
				d.simplify();
				assertEquals("Simplify to negative one (numerator)", -1, d.numerator());
				assertEquals("Simplify to negative one (denominator)", 1, d.denominator());
				
				d.setDenominator(2*i);
				d.setNumerator(0 - i);
				d.simplify();
				assertEquals("Simplify to negative one half (numerator)", -1, d.numerator());
				assertEquals("Simplify to negative one half (denominator)", 2, d.denominator());
			}//if
		}//for

		
		//Test addition
		a.setNumerator(1);
		a.setDenominator(1);
		for(int i=-10; i<=10; i++){
			Rational sum = new Rational(a.plus(i));
			assertEquals("Integer addition", 1+i, (int)sum.decimal());
		}//for
		a.setNumerator(3);
		a.setDenominator(4);
		for(int i=-10; i<=10; i++){
			if(i != 0){
				b.setDenominator(i);
				for(int j=-10; j<=10; j++){
					b.setNumerator(j);
					assertEquals("Rational addition: 3/4 + " + j + "/" + i, .75 + ((double)j / (double)i),
							(a.plus(b)).decimal(), 0.000001);
				}//for(j)
			}//if
		}//for(i)
		
		//Test subtraction
		for(int i=-10; i<=10; i++){
			if(i != 0){
				a.setDenominator(i);
				for(int j=-10; j<=10; j++){
					a.setNumerator(j);
					for(int k=-10; k<=10; k++){
						assertEquals("Integer subtraction", ((double)j/(double)i)-k, 
								(a.minus(k)).decimal(), 0.000001);
					}//for(k)
				}//for(j)
			}//if
		}//for(i)
		for(int i=-5; i<=5; i++){
			if(i != 0){
				a.setDenominator(i);
				for(int j=-5; j<=5; j++){
					a.setNumerator(j);
					for(int k=-5; k<=5; k++){
						if(k != 0){
							b.setDenominator(k);
							for(int m=-5; m<=5; m++){
								b.setNumerator(m);
								assertEquals("Rational subtraction", (double)j/(double)i - (double)m/(double)k, 
										(a.minus(b)).decimal(), 0.000001);
							}//for(m)
						}//if
					}//for(k)
				}//for(j)
			}//if
		}//for(i)
		
		//Test multiplication
		for(int i=-10; i<=10; i++){
			if(i != 0){
				a.setDenominator(i);
				for(int j=-10; j<=10; j++){
					a.setNumerator(j);
					for(int k=-10; k<=10; k++){
						assertEquals("Integer multiplication", ((double)j/(double)i)*k, 
								(a.times(k)).decimal(), 0.000001);
					}//for(k)
				}//for(j)
			}//if
		}//for(i)
		for(int i=-5; i<=5; i++){
			if(i != 0){
				a.setDenominator(i);
				for(int j=-5; j<=5; j++){
					a.setNumerator(j);
					for(int k=-5; k<=5; k++){
						if(k != 0){
							b.setDenominator(k);
							for(int m=-5; m<=5; m++){
								b.setNumerator(m);
								assertEquals("Rational multiplication", 
										((double)j/(double)i) * ((double)m/(double)k), 
										(a.times(b)).decimal(), 0.000001);
							}//for(m)
						}//if
					}//for(k)
				}//for(j)
			}//if
		}//for(i)
		
		//Test division
		for(int i=-10; i<=10; i++){
			if(i != 0){
				a.setDenominator(i);
				for(int j=-10; j<=10; j++){
					a.setNumerator(j);
					for(int k=-10; k<=10; k++){
						if(k != 0){
							assertEquals("Integer division", ((double)j/(double)i) / k, 
									(a.dividedBy(k)).decimal(), 0.000001);
						}//if
					}//for(k)
				}//for(j)
			}//if
		}//for(i)
		for(int i=-5; i<=5; i++){
			if(i != 0){
				a.setDenominator(i);
				for(int j=-5; j<=5; j++){
					a.setNumerator(j);
					for(int k=-5; k<=5; k++){
						if(k != 0){
							b.setDenominator(k);
							for(int m=-5; m<=5; m++){
								if(m != 0){
									b.setNumerator(m);
									assertEquals("Rational division", 
											((double)j/(double)i) / ((double)m/(double)k), 
											(a.dividedBy(b)).decimal(), 0.000001);
								}//if
							}//for(m)
						}//if
					}//for(k)
				}//for(j)
			}//if
		}//for(i)
	} //testAll()
} //TestRational

/*CITATIONS: 
 * [1] The try/catch syntax was lifted from:
 * Oracle (1995). Lesson: Exceptions. The Java(TM) Tutorials. Available at 
 * http://docs.oracle.com/javase/tutorial/essential/exceptions/index.html (Last modified 2013; Visited 9
 * September 2013).  
 *
 * [2] Assistance with the assertEquals(String, double, double, double) call came from:
 * jberg (2011). Meaning of epsilon argument of assertEquals for double values. StackOverflow. Available at 
 * http://stackoverflow.com/questions/5686755/meaning-of-epsilon-argument-of-assertequals-for-double-values 
 * (Last modified 16 April 2011; Visited 8 September 2013).
 */