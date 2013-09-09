package edu.grinnell.csc207.nikakath.hw2;

public class TwoA {
	public static boolean isMultiple(long a, long b){
		if(a == 0)
			return true;
		if(b == 0)
			return false;
		return (a%b == 0);
	} // isMultiple(long,long)
	
	public static boolean isOdd(int i){
		return !(isMultiple(i, 2));
	} //isOdd(int)
	
	public static int oddSumTo(int n){
		int total = 0;
		for(int i=1; i<n; i+=2){
			total += i;
		}//for
		return total;
	} // oddSumTo(int)
	
	public static boolean isOddProd(int[] ints){
		int oddCount = 0;
		for(int i=0; i < ints.length; i++){
			if(isOdd(ints[i]))
				oddCount++;
			if(oddCount >= 2)
				return true;
		}//for
		return false;
	} // isOddProd(int[])
	
	public static boolean allDistinct(int[] ints){
		for(int i=0; i < ints.length; i++){
			for(int j= i+1; j < ints.length; j++){
				if(ints[i] == ints[j])
					return false;
			}//inner for
		}//outer for
		return true;
	} //allDistinct(int[])
	
	public static int[] reverseInts(int[] ints){
		int[] original = new int[ints.length];
		for(int i=0; i<ints.length; i++){
			original[i] = ints[i];
		}//for
		for(int i=0; i<ints.length; i++){
			ints[i] = original[ints.length - (i + 1)];
		}//for
		return ints;
	} //reverseInts(int[])
} //TwoA