package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ResultDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnlAnswer;
	private JPanel pnlAnswerSouth;
	private JScrollPane scrollPaneResult;
	private JLabel lblTitle;
	private JTextArea jtaResult;
	
	public ResultDialog(JFrame parent, String message) {

		super(parent, "Test Result", true);
		this.setLayout(new BorderLayout());
		this.add(answerPanel(message), BorderLayout.CENTER);
		this.setSize(700, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	}
	
	private JPanel answerPanel(String message) {

		// Layers
		pnlAnswer = new JPanel(new BorderLayout());
		pnlAnswerSouth= new JPanel(new FlowLayout()); 
		
		// Components
		lblTitle = new JLabel("RESULTS");
		jtaResult = new JTextArea();
		
		// Design components
		lblTitle.setFont(this.getTitleFont(30));
		
		jtaResult.setEditable(false);
		jtaResult.setFont(this.getFont(23));
		jtaResult.setLineWrap(true);
		jtaResult.setWrapStyleWord(true);
		jtaResult.setBackground(new Color(0,0,0,0));
		jtaResult.append(message);

		
		// First layer
		pnlAnswerSouth.add(lblTitle);
		scrollPaneResult = new JScrollPane(jtaResult);
		scrollPaneResult.setSize(400, 200);
		scrollPaneResult.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100));
		
		// Background layer
		pnlAnswer.setSize(500,300);
		pnlAnswer.add(pnlAnswerSouth, BorderLayout.NORTH);
		pnlAnswer.add(scrollPaneResult, BorderLayout.CENTER);
		
		return pnlAnswer;
	}
	
	private Font getFont(int fontSize) {

		return new Font (Font.SANS_SERIF, Font.PLAIN, fontSize);

	}
	
	private Font getTitleFont(int fontSize) {

		return new Font (Font.SANS_SERIF, Font.BOLD, fontSize);

	}

}
