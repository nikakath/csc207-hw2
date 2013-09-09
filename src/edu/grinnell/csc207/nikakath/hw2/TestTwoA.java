package edu.grinnell.csc207.nikakath.hw2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestTwoA {

	@Test
	public void testIsMultiple() {
		for (long b = -10; b < 11; b++){
			assertEquals("a = 0, b = " + b, true, TwoA.isMultiple(0,b));
		} //for
		for (long b = 2; b < 11; b++){
			assertEquals("a is positive prime, b is positive", false, TwoA.isMultiple(11,b));
		} //for
		for (long b = -10; b < -1; b++){
			assertEquals("a is positive prime, b is negative", false, TwoA.isMultiple(11,b));
		} //for
		for (long b = 2; b < 11; b++){
			assertEquals("a is negative prime, b is positive", false, TwoA.isMultiple(-11,b));
		} //for
		for (long b = -10; b < -1; b++){
			assertEquals("a is negative prime, b is negative", false, TwoA.isMultiple(-11,b));
		} //for
		for (long a = -10; a < 11; a++){
			assertEquals("b is 1", true, TwoA.isMultiple(a,1));
		} //for
		for (long a = -10; a < 0; a++){
			assertEquals("a is negative, b is 0", false, TwoA.isMultiple(a,0));
		} //for
		for (long a = 1; a < 11; a++){
			assertEquals("a is positive, b is 0", false, TwoA.isMultiple(a,0));
		} //for
		for (long a = -10; a < 0; a += 2){
			assertEquals("negative multiples", true, TwoA.isMultiple(a,-2));
		} //for
		for (long a = 2; a < 11; a += 2){
			assertEquals("positive multiples", true, TwoA.isMultiple(a,2));
		} //for
	} //testIsMultiple

	@Test
	public void testIsOdd() {
		for(int i=-20; i<=20; i+=2){
			assertEquals("evens", false, TwoA.isOdd(i));
		} //for
		for(int i=-21; i<=19; i+=2){
			assertEquals("odds", true, TwoA.isOdd(i));
		} //for
	} //testIsOdd

	@Test
	public void testOddSumTo() {
		for(int n=-20; n<=1; n++){
			assertEquals("no positive odds", 0, TwoA.oddSumTo(n));
		} //for
		assertEquals("two", 1, TwoA.oddSumTo(2));
		assertEquals("three", 1, TwoA.oddSumTo(3));
		assertEquals("ten", 25, TwoA.oddSumTo(10));
		assertEquals("eleven", 25, TwoA.oddSumTo(11));
		assertEquals("twenty", 100, TwoA.oddSumTo(20));
		assertEquals("twenty-one", 100, TwoA.oddSumTo(21));
	} //testOddSumTo

	@Test
	public void testIsOddProd() {
		int[] empty = {};
		assertEquals("empty array", false, TwoA.isOddProd(empty));
		
		int[] oneElement = new int[1];
		for(int i=-10; i<=10; i++){
			oneElement[0] = i;
			assertEquals("one element array", false, TwoA.isOddProd(oneElement));
		}//for
		
		int[] ints = {2, 4, 6};
		assertEquals("no odds", false, TwoA.isOddProd(ints));
		
		for(int i=-9; i<=11; i+=2){
			ints[0] = i;
			assertEquals("one odd", false, TwoA.isOddProd(ints));
		}//for
		
		for(int i=-9; i<=11; i+=2){
			for(int j=-9; j<=11; j+=2){
				ints[0] = i;
				ints[1] = j;
				assertEquals("two odds", true, TwoA.isOddProd(ints));
			}//inner for
		}//outer for
		
		for(int i=-9; i<=11; i+=2){
			for(int j=-9; j<=11; j+=2){
				for(int k=-9; k<=11; k+=2){
					ints[0] = i;
					ints[1] = j;
					ints[2] = k;
					assertEquals("three odds", true, TwoA.isOddProd(ints));
				}//inner for
			}//middle for
		}//outer for	
	} //testIsOddProd

	@Test
	public void testAllDistinct() {
		int[] empty = {};
		assertEquals("empty array", true, TwoA.allDistinct(empty));
		
		int[] oneElement = new int[1];
		for(int i=-5; i<=5; i++){
			oneElement[0] = i;
			assertEquals("one element: " + i, true, TwoA.allDistinct(oneElement));
		}//for
		
		int[] ints = {-1, 0, 1, 2};
		assertEquals("all distinct", true, TwoA.allDistinct(ints));

		for(int i=0; i<=2; i++){
			for(int j=i; j<=2; j++){
				ints[i] = j;
				assertEquals("not distinct", false, TwoA.allDistinct(ints));
			}//inner for
			ints[i] = i - 1;
		}//outer for
	} //testAllDistinct

	@Test
	public void testReverseInts() {
		int[] empty = {};
		assertEquals("empty array", empty, TwoA.reverseInts(empty));
		
		int[] oneElement = new int[1];
		for(int i=-5; i<=5; i++){
			oneElement[0] = i;
			assertArrayEquals("one element array", oneElement, TwoA.reverseInts(oneElement));
		}//for
			
		int[] twoElements = new int[2];
		int[] twoReversed = new int[2];
		for(int i=-5; i<=5; i++){
			twoElements[0] = i;
			twoReversed[1] = i;
			for(int j=-5; j<=5; j++){
				twoElements[1] = j;
				twoReversed[0] = j;
				assertArrayEquals("two element array: {" + twoElements[0] + ", " + twoElements[1] + "} -> {" + twoReversed[0] + ", " + twoReversed[1] + "}", twoReversed, TwoA.reverseInts(twoElements));
			}//inner for
		}//outer for
		
		int[] threeElements = new int[3];
		int[] threeReversed = new int[3];
		for(int i=-5; i<=5; i++){
			threeElements[0] = i;
			threeReversed[2] = i;
			for(int j=-5; j<=5; j++){
				threeElements[1] = j;
				threeReversed[1] = j;
				for(int k=-5; k<=5; k++){
					threeElements[2] = k;
					threeReversed[0] = k;
					assertArrayEquals("three element array", threeReversed, TwoA.reverseInts(threeElements));
				}//inner for
			}//middle for
		}//outer for
	} //testReverseInts
}//TestTwoA
