package Algo04;

public class Solve {

	private int numOfTestcase;
//	private Checkboard board;
	private int max;
	public String result;
	
	public Solve(int numOfTestcase, Checkboard[] checkboardOfTestCases){//constructor
		result = "";
		for(int i=0; i < numOfTestcase; i++){
			max = checkboardOfTestCases[i].solve();
			result = result + max + '\n';
		}
		
	
/* 
 * check if 'i'th column and 'k'th column are compatible
 */
/*private boolean checkCompatible(int i, int k){ 
 return true;
 */
	}

}
