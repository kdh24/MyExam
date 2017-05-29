package webPrograming.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferReader {
	public static void FileWrite() throws IOException {
		File f = new File("c:\\test\\BMytest.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("¾È³ç ÆÄÀÏ");
		bw.newLine();
		bw.write("hello Çï·Î");
		bw.newLine();
		
		bw.close();
		
	}
	public static void FileRead() throws IOException {
		File f =new File("c:\\test\\BMytest.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readtxt;
		
		while((readtxt=br.readLine())!=null){
			System.out.printf("%s\n", readtxt);
		}
		br.close();
	}
	
	public static void main(String[] args) throws IOException {
		FileWrite();
		FileRead();
	}
}
