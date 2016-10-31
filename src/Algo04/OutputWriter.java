/* (CSI 3108-01) Algorithm Analysis class HW4 DPPebble
 * Lee, Yun Ji	(2013198070)  	 
 * Nam, Hyo Rim (2013147531)
 * 2016 Fall */
/* OutputWriter writes given string result to file of given path (C:\hw4\2013198070.txt)*/
package Algo04;

import java.io.FileWriter;
import java.io.IOException;

public class OutputWriter {
	private FileWriter fw;

	OutputWriter(String result, String path){
		try{
			fw=new FileWriter(path,true);
			fw.write(result);
			fw.close();
		}catch(IOException e){}
	}
}
