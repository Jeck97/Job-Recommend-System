package view;

import java.io.Serializable;

import javax.swing.UnsupportedLookAndFeelException;

public class MainApp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		MainFrame mainFrame = new MainFrame();
		mainFrame.setVisible(true);
		
	}
	

}

