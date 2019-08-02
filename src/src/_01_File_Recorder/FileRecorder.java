package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileRecorder {
public static void main(String[] args) {
	String message = JOptionPane.showInputDialog("Leave a Message");
	try {
		FileWriter fw = new FileWriter("src/message.txt");
		
		fw.write(message);
			
		fw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
