/* (CSI 3108-01) Algorithm Analysis class HW4 DPPebble
 * Lee, Yun Ji	(2013198070)  	 
 * Nam, Hyo Rim (2013147531)
 * 2016 Fall */
/* Solve gets number of test case and each board information as a Checkboard array,
 * conduct Checkboard.solve() and store the returned answer to max for each test case, 
 * and make result string of the max's*/
package Algo04;

public class Solve {
	private int numOfTestcase;
	private int max;
	public String result;
	
	public Solve(int numOfTestcase, Checkboard[] checkboardOfTestCases){
		this.numOfTestcase = numOfTestcase;
		result = "";
		for(int i=0; i < numOfTestcase; i++){ // for each test case
			max = checkboardOfTestCases[i].solve();
			result = result + max + '\n';
		}
	}
}
