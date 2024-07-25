package code;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;

public class ExceptionDemo {
	
	public void writeToFile(String text) throws IOException{
		
		PrintWriter out = new PrintWriter(new FileWriter("output-file.txt"));
		
		out.println(text);
		
		out.close();
	}
	
	public void readFromFile() throws IOException{
				
		
		try(BufferedReader br =new BufferedReader(new FileReader("output-file.txt")) ){
			
		System.out.println(br.readLine());
		//
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		

		
	}
	
	
	public static void main(String[] args) throws IOException {
		
			
		ExceptionDemo ed = new ExceptionDemo();
		String [] arr = {"FirstLine", "Second Line", "ThirdLine"};
		
		ed.readFromFile();
		
		
		try {
		for (int i =0; i<10;i++) {
			
			ed.writeToFile(arr[i]);
			
			}
		
		}
		catch(IOException | ArrayIndexOutOfBoundsException e ) {
			// code to throw an exception
			//throw new ArrayIndexOutOfBoundsException("message");
			System.out.println(e.getMessage());
		}
//		catch (IOException e) {
//			e.printStackTrace();
//		}
//		catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println(e.getMessage());
//		}
		
		
	}
		
		

}
