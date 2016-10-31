package Algo04;

public class Solve {

	private int numOfTestcase;
	private int max;
	public String result;
	
	public Solve(int numOfTestcase, Checkboard[] checkboardOfTestCases){//constructor
		this.numOfTestcase = numOfTestcase;
		result = "";
		for(int i=0; i < numOfTestcase; i++){
			max = checkboardOfTestCases[i].solve();
			result = result + max + '\n';
		}
	}
}
