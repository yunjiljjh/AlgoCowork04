package Algo04;

/* 
 *  pattern types = total 8 patterns (_ is empty and # is pebble)
 *  vertical patterns are laid horizontally for the sake of expression here.
 *  pattern type 0: _ _ _ _ // 1: #_ _ _ // 2: _#_ _ // 3: _ _#_ // 4: _ _ _# // 5: #_#_ // 6: #_ _# // 7: _#_#
 */

public class Checkboard {
	public int board[][];
	public int colNum;
	public int sum; 
	public int pattern[]; // stores pattern types listed above for each column in the pattern[] array.
	
	public Checkboard(int colNum, int board[][]){
		this.colNum = colNum;
		this.board = new int[4][colNum];
		for(int i = 0 ; i < 4 ; i++){
			for(int k = 0 ; k < colNum; k++){
				this.board[i][k] =  board[i][k];}	}
		sum = 0;
		pattern = new int[colNum];
		for(int t = 0 ; t< colNum ; t++) pattern[t] = -1; //initialize by inserting negative number -1, instead of pattern types.
	}
	
/*
 *  lay pebbles on 'colNum'th column, and updates sum according to it. 
 */
	public void layPebbles(int colNum, int patternType){ 
	
		pattern[colNum]=patternType; // updates pattern type for the column designated.
		
		if (patternType==1){sum += board[0][colNum];}
		else if (patternType==2){sum += board[1][colNum];}
		else if (patternType==3){sum += board[2][colNum];}
		else if (patternType==4){sum += board[3][colNum];}
		else if (patternType==5){sum += ( board[0][colNum] + board[2][colNum]);}
		else if (patternType==6){sum += ( board[0][colNum] + board[3][colNum]);}
		else if (patternType==7){sum += ( board[1][colNum] + board[3][colNum]);}
		else{/*does nothing with updating sum*/}
	}
	
	/* 
	 * check if 'i'th column and 'k'th column are compatible
	 */
	public boolean checkCompatible(int i, int k){ 
		if(pattern[i]==0 || pattern[k]==0 ) return true; // compatible if any of the column is empty.
		if(pattern[i]==-1 || pattern[k]==-1 ) return true; // pebbles are not placed yet.
		else if (pattern[i] == 1)  return ( (pattern[k]==2|| pattern[k]==3 ||pattern[k]==4||pattern[k]==7) ?  true :  false);
		else if (pattern[i] == 2)  return ( (pattern[k]==1|| pattern[k]==3 ||pattern[k]==4||pattern[k]==5||pattern[k]==6) ?  true :  false);
		else if (pattern[i] == 3)  return ( (pattern[k]==1|| pattern[k]==2 ||pattern[k]==4||pattern[k]==6||pattern[k]==7) ?  true :  false);
		else if (pattern[i] == 4)  return ( (pattern[k]==1|| pattern[k]==2 ||pattern[k]==3||pattern[k]==5) ?  true :  false);
		else if (pattern[i] == 5)  return ( (pattern[k]==2|| pattern[k]==4 ||pattern[k]==7) ?  true :  false);
		else if (pattern[i] == 6)  return ( (pattern[k]==2|| pattern[k]==3 ) ?  true :  false);
		else if (pattern[i] == 7)  return ( (pattern[k]==1|| pattern[k]==3 ||pattern[k]==5) ?  true :  false);
		else {System.out.println("wring column");
					return false;}
	}
		
	
	
}
