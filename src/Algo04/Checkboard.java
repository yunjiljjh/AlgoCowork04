package Algo04;

public class Checkboard {
	public int board[][];
	public int colNum;
	
	private int dpTable[][];
	
	public Checkboard(int colNum, int board[][]){
		this.colNum = colNum;
/*		
		this.board = new int[4][colNum];
		for(int i = 0 ; i < 4 ; i++){
			for(int k = 0 ; k < colNum; k++){
				this.board[i][k] =  board[i][k];
			}
		}
*/
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
			for(int i=1; i<8; i++){
				dpTable[colNum][i] = getValue(i, colNum);
				if (val < dpTable[colNum][i]){
					val = dpTable[colNum][i];
				}
			}
		}
		else{
			switch(pattern){
				case 0: val = val + getPattern0CompatibleMaxVal(colNum-1); break;
				case 1: val = val + getPattern1CompatibleMaxVal(colNum-1); break;
				case 2: val = val + getPattern2CompatibleMaxVal(colNum-1); break;
				case 3: val = val + getPattern3CompatibleMaxVal(colNum-1); break;
				case 4: val = val + getPattern4CompatibleMaxVal(colNum-1); break;
				case 5: val = val + getPattern5CompatibleMaxVal(colNum-1); break;
				case 6: val = val + getPattern6CompatibleMaxVal(colNum-1); break;
				case 7: val = val + getPattern7CompatibleMaxVal(colNum-1); break;
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
	
	private int getPattern0CompatibleMaxVal(int colNum){
		int val1, val2, val3, val4;
		val1 = Math.max(getValue(7, colNum), getValue(6, colNum));
		val2 = Math.max(getValue(5, colNum), getValue(4, colNum));
		val3 = Math.max(getValue(3, colNum), getValue(2, colNum));
		val4 = Math.max(getValue(1, colNum), getValue(0, colNum));
		val1 = Math.max(val1, val2);
		val3 = Math.max(val3, val4);
		val1 = Math.max(val1, val3);
		return val1;
	}
	private int getPattern1CompatibleMaxVal(int colNum){
		int val1, val2;
		val1 = Math.max(getValue(7, colNum), getValue(4, colNum));
		val2 = Math.max(getValue(3, colNum), getValue(2, colNum));
		val1 = Math.max(val1, val2);
		val1 = Math.max(val1, getValue(0, colNum));
		return val1;
	}
	private int getPattern2CompatibleMaxVal(int colNum){
		int val1, val2, val3;
		val1 = Math.max(getValue(6, colNum), getValue(5, colNum));
		val2 = Math.max(getValue(4, colNum), getValue(3, colNum));
		val3 = Math.max(getValue(1, colNum), getValue(0, colNum));
		val1 = Math.max(val1, val2);
		val1 = Math.max(val1, val3);
		return val1;
	}
	private int getPattern3CompatibleMaxVal(int colNum){
		int val1, val2, val3;
		val1 = Math.max(getValue(7, colNum), getValue(6, colNum));
		val2 = Math.max(getValue(4, colNum), getValue(2, colNum));
		val3 = Math.max(getValue(1, colNum), getValue(0, colNum));
		val1 = Math.max(val1, val2);
		val1 = Math.max(val1, val3);
		return val1;
	}
	private int getPattern4CompatibleMaxVal(int colNum){
		int val1, val2;
		val1 = Math.max(getValue(5, colNum), getValue(3, colNum));
		val2 = Math.max(getValue(2, colNum), getValue(1, colNum));
		val1 = Math.max(val1, val2);
		val1 = Math.max(val1, getValue(0, colNum));
		return val1;
	}
	private int getPattern5CompatibleMaxVal(int colNum){
		int val1, val2;
		val1 = Math.max(getValue(7, colNum), getValue(4, colNum));
		val2 = Math.max(getValue(2, colNum), getValue(0, colNum));
		val1 = Math.max(val1, val2);
		return val1;
	}
	private int getPattern6CompatibleMaxVal(int colNum){
		int val1, val2;
		val1 = Math.max(getValue(5, colNum), getValue(3, colNum));
		val2 = Math.max(getValue(1, colNum), getValue(0, colNum));
		val1 = Math.max(val1, val2);
		return val1;
	}
	private int getPattern7CompatibleMaxVal(int colNum){
		int val;
		val = Math.max(getValue(3, colNum), getValue(2, colNum));
		val = Math.max(val, getValue(0, colNum));
		return val;
	}
}
