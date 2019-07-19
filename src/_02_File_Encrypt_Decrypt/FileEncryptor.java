package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	public static void main(String[] args) {
		
	
	String message = JOptionPane.showInputDialog("Leave a Message");
	try {
		FileWriter fw = new FileWriter("src/message.txt");
		
		fw.write(message+" HIDE");
			
		fw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
	}

