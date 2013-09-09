package edu.grinnell.csc207.nikakath.hw2;

public class TwoB {
    /**
     * Compute the average of two integers.  Rounds toward zero if the
     * average is not a whole number.  The original version of this method
     * did not accurately calculate the averages of very large values
     * due to dividing integer type values.
     */
    public static int average(int left, int right) {
        return (int) (((double)left + (double)right) / 2);
    } // average(int,int)
} // class TwoB

	