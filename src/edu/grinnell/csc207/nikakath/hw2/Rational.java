package edu.grinnell.csc207.nikakath.hw2;

//this is a useless change

public class Rational {
	private int numerator;
	private int denominator;

	/**
	 * Construct a new rational number.  (Constructor)
	 */
	public Rational (int startNumerator, int startDenominator){
		numerator = startNumerator;
		denominator = startDenominator;
	} // Rational
	
	/**
	 * Construct a rational number from an integer.  (Constructor)
	 */
	public Rational (int integer){
		numerator = integer; 
		denominator = 1;
	} // Rational
	
	/**
	 * Construct a rational number from another rational number.  (Constructor)
	 */
	public Rational (Rational number){
		numerator = number.numerator(); 
		denominator = number.denominator();
	} // Rational
	
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
    	denominator = num;
    } // setDenominator(int)
    
    /**
     * Multiply this rational number by another rational number.  (Observer/Constructor)
     */
    public Rational multiply(Rational multiplicand) {
    	Rational product = new Rational(numerator() * multiplicand.numerator(), denominator() * multiplicand.denominator());
    	product.simplify();
    	return product;
    } // multiply(Rational)

    /**
     * Multiply this rational number by an integer.  (Observer/Constructor)
     */
    public Rational multiply(int multiplicand) {
    	Rational product = new Rational(numerator() * multiplicand, denominator());
    	product.simplify();
    	return product;
    } // multiply(int)
    
    /**
     * Divide this rational number by another rational number.  (Observer/Constructor)
     */
    public Rational divide(Rational divisor) {
    	Rational quotient = new Rational(numerator() * divisor.denominator(), denominator() * divisor.numerator());
    	quotient.simplify();
    	return quotient;
    } // divide(Rational)
    
    /**
     * Divide this rational number by an integer.  (Observer/Constructor)
     */
    public Rational divide(int divisor) {
    	Rational quotient = new Rational(numerator(), denominator() * divisor);
    	quotient.simplify();
    	return quotient;
    } // divide(int)
    
    /**
     * Add this rational number to another rational number.  (Observer/Constructor)
     */
    public Rational add(Rational addend) {
    	Rational sum = new Rational(this);
    	sum.simplify();
    	return sum;    //STUB
    } // add(Rational)
    
    /**
     * Add this rational number to an integer.  (Observer/Constructor)
     */
    public Rational add(int addend) {
    	Rational sum = new Rational(numerator() + (addend * denominator()), denominator());
    	sum.simplify();
    	return sum;
    } // add(int)
    
    /**
     * Subtract another rational number from this rational number.  (Observer/Constructor)
     */
    public Rational subtract(Rational subtrahend) {
    	Rational difference = new Rational(this);
    	difference.simplify();
    	return difference;	//STUB
    } // subtract(Rational)
    
    /**
     * Subtract an integer from this rational number.  (Observer/Constructor)
     */
    public Rational subtract(int subtrahend) {
    	Rational difference = new Rational(numerator() - (subtrahend * denominator()), denominator());
    	difference.simplify();
    	return difference;
    } // subtract(int)
    
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
    	//STUB
    } // simplify
} // TwoC

/*CITATIONS
 * The syntax of the constructor methods was created with help from 
 * Oracle (1995). Providing Constructors for Your Classes. The Java(TM) Tutorials. Available at 
 * docs.oracle.com/javase/tutorial/java/javaOO/constructors.html (Last modified 2013; Visited 8 September 2013).
 */
