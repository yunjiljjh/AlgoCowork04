package Algo04;

public class Checkboard {
	public int board[][];
	public int colNum;
	
	public Checkboard(int colNum, int board[][]){
		this.colNum = colNum;
		this.board = new int[4][colNum];
		for(int i = 0 ; i < 4 ; i++){
			for(int k = 0 ; k < colNum; k++){
				this.board[i][k] =  board[i][k];
			}
		}
	}
	
}
