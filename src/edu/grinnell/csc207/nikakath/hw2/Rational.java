package edu.grinnell.csc207.nikakath.hw2;

public class Rational {
	private int numerator;
	private int denominator;

	/**
	 * Construct a new rational number.  (Constructor)
	 */
	public Rational (int startNumerator, int startDenominator){  //[1]
		numerator = startNumerator;    	
		if(startDenominator != 0)
			denominator = startDenominator;
    	else
    		throw new IllegalArgumentException("Denominator cannot be 0");
	} // Rational(int, int)
	
	/**
	 * Construct a rational number from an integer.  (Constructor)
	 */
	public Rational (int integer){
		numerator = integer; 
		denominator = 1;
	} // Rational(int)
	
	/**
	 * Construct a rational number from another rational number.  (Constructor)
	 */
	public Rational (Rational number){
		numerator = number.numerator(); 
		denominator = number.denominator();
	} // Rational(Rational)
	
	/**
	 * Construct a rational number from another rational number.  (Constructor)
	 */
	public Rational (){
		numerator = 0; 
		denominator = 1;
	} // Rational()
	
    /**
     * Get the numerator of this rational number.  (Observer)
     */
    public int numerator() {
      return numerator;
    } // numerator
    
    /**
     * Get the denominator of this rational number.  (Observer)
     */
    public int denominator() {
      return denominator;
    } // denominator
    
    /**
     * Change the numerator of this rational number.  (Mutator)
     */
    public void setNumerator(int num){
    	numerator = num;
    } // setNumerator(int)
    
    /**
     * Change the denominator of this rational number.  (Mutator)
     */
    public void setDenominator(int num){
    	if(num != 0)
    		denominator = num;
    	else
    		throw new IllegalArgumentException("Denominator cannot be 0");
    } // setDenominator(int)
    
    /**
     * Return the decimal approximation of this rational number.  (Observer) 
     */
    public double decimal(){
      return ((double)numerator() / (double)denominator());
    } // decimal
    
    /**
     * Reduce a rational number to simplest terms.  (Mutator) 
     */
    public void simplify(){
    	//Find Greatest Common Divisor [2]
    	int num = numerator();
    	int denom = denominator();
    	int gcd = num % denom;
    	while(gcd != 0){
    		num = denom;
    		denom = gcd;
    		gcd = num % denom;
    	}
    	gcd = denom;
    	
    	//Simplify by dividing both parts by GCD
    	setNumerator(numerator() / gcd);
    	setDenominator(denominator() / gcd);
    	
    	//Move negative sign to numerator
    	if(denominator() < 0){
    		setNumerator(numerator() * -1);
        	setDenominator(denominator() * -1);
    	}
    } // simplify
    
    /**
     * Add this rational number to another rational number.  (Observer/Constructor)
     */
    public Rational plus(Rational addend) {
    	Rational sum = new Rational();
    	sum.setDenominator(denominator() * addend.denominator());
    	sum.setNumerator((numerator() * addend.denominator()) + (addend.numerator() * denominator()));
    	sum.simplify();
    	return sum;
    } // add(Rational)
    
    /**
     * Add this rational number to an integer.  (Observer/Constructor)
     */
    public Rational plus(int addend) {
    	Rational sum = new Rational(numerator() + (addend * denominator()), denominator());
    	sum.simplify();
    	return sum;
    } // add(int)
    
    /**
     * Subtract another rational number from this rational number.  (Observer/Constructor)
     */
    public Rational minus(Rational subtrahend) {
    	Rational difference = new Rational();
    	difference.setDenominator(denominator() * subtrahend.denominator());
    	difference.setNumerator((numerator() * subtrahend.denominator()) - 
    			(subtrahend.numerator() * denominator()));
    	difference.simplify();
    	return difference;
    } // subtract(Rational)
    
    /**
     * Subtract an integer from this rational number.  (Observer/Constructor)
     */
    public Rational minus(int subtrahend) {
    	Rational difference = new Rational(numerator() - (subtrahend * denominator()), denominator());
    	difference.simplify();
    	return difference;
    } // subtract(int)
    
    /**
     * Multiply this rational number by another rational number.  (Observer/Constructor)
     */
    public Rational times(Rational multiplicand) {
    	Rational product = new Rational(numerator() * multiplicand.numerator(), denominator() * multiplicand.denominator());
    	product.simplify();
    	return product;
    } // multiply(Rational)

    /**
     * Multiply this rational number by an integer.  (Observer/Constructor)
     */
    public Rational times(int multiplicand) {
    	Rational product = new Rational(numerator() * multiplicand, denominator());
    	product.simplify();
    	return product;
    } // multiply(int)
    
    /**
     * Divide this rational number by another rational number.  (Observer/Constructor)
     */
    public Rational dividedBy(Rational divisor) {
    	if(divisor.numerator() != 0){
    		Rational quotient = new Rational(numerator() * divisor.denominator(), denominator() * divisor.numerator());
    		quotient.simplify();
    		return quotient;
    	}else{
    		throw new ArithmeticException("Division by 0");
    	}
    } // divide(Rational)
    
    /**
     * Divide this rational number by an integer.  (Observer/Constructor)
     */
    public Rational dividedBy(int divisor) {
    	Rational quotient = new Rational(numerator(), denominator() * divisor);
    	quotient.simplify();
    	return quotient;
    } // divide(int)

} // TwoC

/*CITATIONS
 * [1] The syntax of the constructor methods was created with help from: 
 * Oracle (1995). Providing Constructors for Your Classes. The Java(TM) Tutorials. Available at 
 * docs.oracle.com/javase/tutorial/java/javaOO/constructors.html (Last modified 2013; Visited 8
 * September 2013).
 * 
 * [2] The algorithm for finding the GCD in the simplify method was Euclid's algorithm, as found at:
 * Wikipedia. Using Euclid's algorithm. Greatest common divisor. Available at 
 * http://en.wikipedia.org/wiki/Greatest_common_divisor#Using_Euclid.27s_algorithm 
 * (Last modified 15 August 2013; Visited 9 September 2013).
 */
