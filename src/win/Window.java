package win;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Window {
	//This is all short hand methods for JOptionPane methods 

	public void msg(String msg, String title) {
		JOptionPane.showMessageDialog(null, msg, title, JOptionPane.PLAIN_MESSAGE);
	}
	
	public void msg(String msg, String title, ImageIcon icon) {
		JOptionPane.showMessageDialog(null, msg, title, JOptionPane.PLAIN_MESSAGE, icon);
	}
	
	public String in(String msg) {
		return JOptionPane.showInputDialog(null, msg, null, JOptionPane.PLAIN_MESSAGE);
	}
	
	public int option(ImageIcon[] options, String msg, String title, ImageIcon icon) {
		return JOptionPane.showOptionDialog(null, msg, title, 
				JOptionPane.PLAIN_MESSAGE, 
				JOptionPane.PLAIN_MESSAGE, icon, 
				options, options[0]);
	}
	
	public int option(String[] options, String msg) {
		return JOptionPane.showOptionDialog(
				null, 
				msg, // my message
                "Click a button", // dialog box title
                JOptionPane.PLAIN_MESSAGE, 
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                options, // possible options
                options[0]); // default option
	}
	
	public int option(String[] options, String msg, ImageIcon icon) {
		return JOptionPane.showOptionDialog(
				null, 
				msg, // my message
                "Click a button", // dialog box title
                JOptionPane.PLAIN_MESSAGE, 
                JOptionPane.PLAIN_MESSAGE, 
                icon, 
                options, // possible options
                options[0]); // default option
	}
	public int option(String[] options, String msg, String title) {
		return JOptionPane.showOptionDialog(
				null, 
				msg, // my message
                title, // dialog box title
                JOptionPane.PLAIN_MESSAGE, 
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                options, // possible options
                options[0]); // default option
	}
	
	public int option(String[] options, String msg, String title, ImageIcon icon) {
		return JOptionPane.showOptionDialog(
				null, 
				msg, // my message
                title, // dialog box title
                JOptionPane.PLAIN_MESSAGE, 
                JOptionPane.PLAIN_MESSAGE, 
                icon, 
                options, // possible options
                options[0]); // default option
	}
	
	public void println(String msg) {
		System.out.println(msg);
	}
	
	public void print(String msg) {
		System.out.println(msg);
	}
	
	public void msg(Object msg) {
		JOptionPane.showMessageDialog(null, msg, null, JOptionPane.PLAIN_MESSAGE);
	}
	
	public String in(Object msg) {
		return JOptionPane.showInputDialog(msg, JOptionPane.PLAIN_MESSAGE);
	}
	
	public int option(Object[] options, Object msg) {
		return JOptionPane.showOptionDialog(
				null, 
				msg, // my message
                "Click a button", // dialog box title
                JOptionPane.PLAIN_MESSAGE, 
                JOptionPane.PLAIN_MESSAGE, 
                null, 
                options, // possible options
                options[0]); // default option
	}

}
