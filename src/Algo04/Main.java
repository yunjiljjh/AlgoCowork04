/* (CSI 3108-01) Algorithm Analysis class HW4 DPPebble
 * Lee, Yun Ji	(2013198070)  	 
 * Nam, Hyo Rim (2013147531)
 * 2016 Fall */
/* main */
/* The aim is to find the maximum sum of pebbled cells of a board of 4 x N, 
 * while 2N white pebble, 2N black pebble are given, black pebble negate the cell's value, 
 * and each pebble cannot be locate next to another pebble. */
package Algo04;

public class Main {

	public static void main(String[] args) {
		InputReader reader = new InputReader("C:\\hw4\\input.txt");
		Solve slv = new Solve(reader.numOfTestcase, reader.checkboardOfTestCases);
		OutputWriter wr = new OutputWriter(slv.result, "C:\\hw4\\2013198070.txt");
	}
}
