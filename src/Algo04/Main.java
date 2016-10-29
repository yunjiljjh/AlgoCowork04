package Algo04;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("run");
//		InputReader reader = new InputReader("C:\\hw4\\input.txt");
		InputReader reader = new InputReader("C:\\Users\\p34g\\Documents\\GitHub\\AlgoCowork04\\src\\Algo04\\input.txt");
		Solve solver = new Solve(reader.numOfTestcase, reader.checkboardOfTestCases);
//		OutputWriter writer = new OutputWriter(solver.result, "C:\\hw4\\2013198070.txt");
		OutputWriter writer = new OutputWriter(solver.result, "C:\\Users\\p34g\\Documents\\GitHub\\AlgoCowork04\\src\\Algo04\\Output.txt");
	}
}
