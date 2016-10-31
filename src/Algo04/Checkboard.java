/* (CSI 3108-01) Algorithm Analysis class HW4 DPPebble
 * Lee, Yun Ji	(2013198070)  	 
 * Nam, Hyo Rim (2013147531)
 * 2016 Fall */
/* Checkboard stores a board and the number of columns of the board, 
 * and has solve() and other methods to calculate max sum of pebbled elements from the board*/
package Algo04;

public class Checkboard {
	private int board[][]; // given board[colNum][4];
	private int colNum; // number of columns
	
	private int dpTable[][]; // dpTable[i][j] is the max value of pebbled board of size 4 x (i-1) + sum of i'th columns' pebbled cells by pattern j. 
	
	/* Patterns: pebbled cell: o, not pebbled cell: _
		pattern 0: _ _ _ _
		pattern 1: o _ _ _
		pattern 2: _ o _ _
		pattern 3: _ _ o _
		pattern 4: _ _ _ o
		pattern 5: o _ o _
		pattern 6: o _ _ o
		pattern 7: _ o _ o
	*/
	
	public Checkboard(int colNum, int board[][]){
		this.colNum = colNum;
		this.board = new int[colNum][4];
		for(int i = 0 ; i < 4 ; i++){
			for(int k = 0 ; k < colNum; k++){
				this.board[k][i] =  Math.abs(board[i][k]); // number of black pebbles and white pebbles are always sufficient
			}
		}
		dpTable = new int[colNum][8];
	}
	
	//solves the problem by filling out dpTable and retrieving max value of the last column.  
	public int solve(){
		//fills out dpTable
		for(int i=0; i < colNum; i++){
			for(int j=0; j < 8; j++){
				setCell(j, i);
			}
		}
//test
		String test="Print dpTable[colNum][j]\n";
		for(int i=0; i < colNum; i++){
			for(int j=0; j < 8; j++){
				test = test + dpTable[i][j] + "\t";
			}
			test = test + "\n";
		}
		test = test + "end\n";
		System.out.println(test);
		
		//return the max value of the dpTable's last column
		int max=0;
		int tmp;
		for(int j=7; j >= 0; j--){
			tmp = dpTable[colNum-1][j];
			max = tmp > max ? tmp : max;
		}
		return max;
	}
	
	//sets a dpTable cell value and returns the value
	//dpTable[colNum][pattern] is sum of colNum'th column's cell of the pattern + max element of dpTable[colNum-1]
	private int setCell(int pattern, int colNum){
		int val = getValue(pattern, colNum);
		if(colNum == 0){
			dpTable[colNum][pattern] = getValue(pattern, colNum);
		}
		else{
			switch(pattern){
				case 0: val = val + max(new int[]{0, 1, 2, 3, 4, 5, 6, 7}, colNum-1); break;
				case 1: val = val + max(new int[]{0, 2, 3, 4, 7}, colNum-1); break;
				case 2: val = val + max(new int[]{0, 1, 3, 4, 5, 6}, colNum-1); break;
				case 3: val = val + max(new int[]{0, 1, 2, 4, 6, 7}, colNum-1); break;
				case 4: val = val + max(new int[]{0, 1, 2, 3, 5}, colNum-1); break;
				case 5: val = val + max(new int[]{0, 2, 4, 7}, colNum-1); break;
				case 6: val = val + max(new int[]{0, 2, 3}, colNum-1); break;
				case 7: val = val + max(new int[]{0, 1, 3, 5}, colNum-1); break;
				default: System.err.println("wrong pattern number: " + pattern); System.exit(1);
			}
			dpTable[colNum][pattern] = val;
		}
		return val;
	}
	
	//returns value of colNum'th column pebbled by pattern
	private int getValue(int pattern, int colNum){
		int val = 0;
		switch (pattern){
			case 0: break;
			case 1: val = board[colNum][0]; break;
			case 2:	val = board[colNum][1]; break;
			case 3:	val = board[colNum][2]; break;
			case 4:	val = board[colNum][3]; break;
			case 5:	val = board[colNum][0] + board[colNum][2]; break;
			case 6:	val = board[colNum][0] + board[colNum][3]; break;
			case 7: val = board[colNum][1] + board[colNum][3]; break;
			default: System.err.println("wrong pattern number: " + pattern); System.exit(1);			
		}
		return val;
	}
	
	//returns the maximum value of dpTable's colNum'th column among given patterns
	private int max(int pattern[], int colNum){
		int max=0;
		int candid;
		for(int i=pattern.length-1; i>=0; i--){
			candid=dpTable[colNum][pattern[i]];
			max = candid > max ? candid : max; 
		}
		return max;
	}	
}
