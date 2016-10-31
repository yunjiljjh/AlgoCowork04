/* (CSI 3108-01) Algorithm Analysis class HW4 DPPebble
 * Lee, Yun Ji	(2013198070)  	 
 * Nam, Hyo Rim (2013147531)
 * 2016 Fall */
/**/
package Algo04;

public class Checkboard {
	public int board[][];
	public int colNum;
	
	private int dpTable[][];
	
	public Checkboard(int colNum, int board[][]){
		this.colNum = colNum;
		this.board = new int[colNum][4];
		for(int i = 0 ; i < 4 ; i++){
			for(int k = 0 ; k < colNum; k++){
				this.board[k][i] =  Math.abs(board[i][k]); // number of black pebble and white pebble are always sufficient
			}
		}
		dpTable = new int[colNum][8];
		for(int i = 0 ; i < 8 ; i++){
			dpTable[0][i] = 0;
		}
	}
	
	public int solve(){
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
		
		int max=0;
		for(int j=7; j >= 0; j--){
			if(max < dpTable[colNum-1][j]){
				max = dpTable[colNum-1][j];
			}
		}
		return max;
	}
	
	private int setCell(int pattern, int colNum){
		int val=getValue(pattern, colNum);
		if(colNum == 0){
			for(int i=7; i>=0; i--){
				dpTable[colNum][i] = getValue(i, colNum);
				if (val < dpTable[colNum][i]){
					val = dpTable[colNum][i];
				}
			}
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
				default: System.err.println("wrong pattern number"); System.exit(1);	
			}
			dpTable[colNum][pattern] = val;
		}
		return val;
	}
	
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
			default: System.err.println("wrong pattern number"); System.exit(1);			
		}
		return val;
	}
	
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
