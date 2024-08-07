package serialization;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;



public class SerializationDemo {
	
	
	private static void writeTofile(String path) throws IOException {
		
		//FileOutputStream fo = new FileOutputStream(path);
		//fo.write(01010101);
		
		//FileWriter fw = new FileWriter(path);
		
		//char[] text = {'h', 'e','l','l','l','o'};
		
//		for (char c: text) {
//			fw.write(c);
//		}	
//		
//		fw.close();
		
//		BufferedWriter bw = new BufferedWriter(new FileWriter(path));
//		
//		bw.append("random text");
//		bw.close();
		
		PrintWriter pr = new PrintWriter(new FileWriter(path));
		
		pr.printf("demo text: %.2f", 1.324);
		
		pr.close();

		
		
	}
	
	private static void readFromFile(String path) throws IOException {
		
		//FileInputStream fi = new FileInputStream(path);
//		FileReader fr = new FileReader(path);
//		System.out.println(fr.read());
		
		BufferedReader br = new BufferedReader(new FileReader(path));
		System.out.println(br.readLine());
		
		Scanner sc = new Scanner (new FileReader(path));
		System.out.println(sc.nextLine());
		
		
		
	}
	
	public static void main(String[] args) {
		
		String path = "C:/jfs/training-notes-week-3/advanced-java/src/main/java/serialization/demo.txt";
		
		Scanner sc = new Scanner (System.in);
		try {
			writeTofile(path);
			readFromFile(path);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	

}
