package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a  task and save it to an array list
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */
	 ArrayList<String> task = new ArrayList<String>();
	 JFrame frame = new JFrame("Tasks");
	 JPanel panel = new JPanel();
	 public JButton askTask = new JButton("Add Task");
	 JButton viewTask = new JButton("View Task");
 JButton removeTask = new JButton("Remove Task");
	 JButton saveList = new JButton("Save List");
	 JButton loadList = new JButton("Load List");
	public static void main(String[] args) {
		
		ToDoList kust = new ToDoList();
		kust.loadListFunc();
	kust.createUI();
	}
	public void createUI() {
		
		
		 frame.add(panel);
			panel.add(askTask);
			panel.add(viewTask);
			panel.add(removeTask);
			panel.add(saveList);
			panel.add(loadList);
			frame.pack();
			frame.setVisible(true);
			askTask.addActionListener(this);
			viewTask.addActionListener(this);
			removeTask.addActionListener(this);
			saveList.addActionListener(this);
			loadList.addActionListener(this);
	}
	public void addTaskFunc() {
		String task1 = JOptionPane.showInputDialog("Add a Task");
		task.add(task1);
	}
	public void viewTaskFunc() {
		String n = "";
		for(String s:task) {
			n+=s+"\n";
		}
		JOptionPane.showMessageDialog(null, n);
	}
	public void removeTaskFunc() {
		int taskIndex =-1;
		String task1 = JOptionPane.showInputDialog("Remove a Task");
		for(int i = 0;i<task.size();i++) {
			if(task.get(i).equalsIgnoreCase(task1)) {
				taskIndex=i;
				break;
		}
			
	}
	task.remove(taskIndex);
	
	
}
	public void saveListFunc() {
		String n ="";
		for(String s:task)
			n+=s+"\n";
		try {
			FileWriter fw = new FileWriter("src/message.txt");
			
			fw.write(n);
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void loadListFunc() {
		String file = "";
		String fileName ="";
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			fileName = jfc.getSelectedFile().getAbsolutePath();
			System.out.println(fileName);
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			
			String line = br.readLine();
			while(line != null){
				file+=line;
				System.out.println(line);
				line = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JOptionPane.showMessageDialog(null, file);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(askTask))
			addTaskFunc();
		if(e.getSource().equals(viewTask))
			viewTaskFunc();
		if(e.getSource().equals(removeTask))
			removeTaskFunc();
		if(e.getSource().equals(saveList))
			saveListFunc();
		if(e.getSource().equals(loadList))
			loadListFunc();
		
			
		
	}
}
