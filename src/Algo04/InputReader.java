package Algo04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

public class InputReader {
	private FileReader fr;
	private BufferedReader br;
	
	public int numOfTestcase;
	public int numOfColumn;
	
	private Checkboard board; //checkboard of a test case
	private int tmpBoard[][];
	public Checkboard checkboardOfTestCases[]; // stores checkboard of i'th test case in index i
	
	public InputReader(String path){
		read(path);
	}

	private void read(String path){
		try{
			fr=new FileReader(path);
			br=new BufferedReader(fr);
		
			String s = null;
			numOfTestcase = 0;
			
			// reads the first line
			s = br.readLine();
			String[] a = s.split(" ");
			numOfTestcase = Integer.parseInt(a[0]);
			checkboardOfTestCases = new Checkboard[numOfTestcase];
					
			//one test case per a loop
			for(int i =0 ; i <numOfTestcase ; i++){
				numOfColumn  = Integer.parseInt(br.readLine());
				tmpBoard = new int[4][numOfColumn];	
				
				//one board per a loop
				for(int k = 0 ; k <4 ; k++){
					String ss = null;
					s = br.readLine();
					String[] aa = s.split(" ");
					//aa배열에 받은 한 row에서의 숫자들 저장 (numOfColumn개 numbers) 
					
					if (aa.length < 1){throw new IOException();}
					for(int j = 0;j < numOfColumn;j++){
						tmpBoard[k][j] = Integer.parseInt(aa[j]);						
					}
				} //a board is filled
				board = new Checkboard(numOfColumn, tmpBoard);
				checkboardOfTestCases[i] = board;
			} // test case loop ends

			}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(br != null){
				try{br.close();}
				catch(IOException e){}
			}
			if(fr != null){
				try{fr.close();}
				catch(IOException e){}
			}
		}			
	}
}
