package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.QuestionManager;
import controller.ResultManager;
import model.Question;

public class QuestionFrame extends JFrame implements ActionListener, WindowListener{

	private static final long serialVersionUID = 1L;

	private int width = 750;
	private int height = 325;
	private int numbering = 1;
	private JLabel lblQuestion;
	private JLabel lblQuestionNumber;
	private JRadioButton radioBtn1;
	private JRadioButton radioBtn2;
	private ButtonGroup radioGroup;
	private JButton btnConfirm;

	private JFrame frame;

	private Question question;
	private QuestionManager questionManager;
	private ResultManager resultManager;	


	public QuestionFrame(JFrame frame) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

		UIManager.setLookAndFeel(
				UIManager.getSystemLookAndFeelClassName());

		questionManager = new QuestionManager();
		resultManager = new ResultManager();	
		this.frame = frame;
		this.setTitle("Job Recommend System");
		this.setSize(width, height);
		this.setVisible(true);
		this.setLocationRelativeTo(frame);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.loadComponent();
		this.addWindowListener(this);
	}

	private JPanel getQuestionPanel() {

		this.setQuestion();

		JPanel panel = new JPanel(new BorderLayout());
		JPanel pnlQuestion = new JPanel();
		JPanel pnlSelection = new JPanel();
		JPanel pnlButton = new JPanel();
		pnlSelection.add(radioBtn1);
		pnlSelection.add(radioBtn2);


		lblQuestion.setFont(this.getTitleFont(20));
		lblQuestionNumber.setFont(getTitleFont(20));
		pnlQuestion.add(lblQuestionNumber);
		pnlQuestion.add(lblQuestion);

		radioBtn1.setFont(this.getFont(25));
		radioBtn1.setBorder(BorderFactory.createEmptyBorder(0, 150, 0, 150));
		radioBtn1.setFocusable(false);
		radioBtn2.setFont(this.getFont(25));
		radioBtn2.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 100));
		radioBtn2.setFocusable(false);
		pnlSelection.setBorder(BorderFactory.createEmptyBorder(30, 100, 30, 100));

		btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(this.getFont(30));
		btnConfirm.addActionListener(this);
		btnConfirm.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLACK), 
				BorderFactory.createEmptyBorder(30, 100, 30, 100)));
		btnConfirm.setFocusable(false);
		pnlButton.add(btnConfirm);
		this.rootPane.setDefaultButton(btnConfirm);

		panel.add(pnlQuestion, BorderLayout.NORTH);
		panel.add(pnlSelection, BorderLayout.CENTER);
		panel.add(pnlButton, BorderLayout.SOUTH);

		return panel;

	}

	private Font getFont(int fontSize) {

		return new Font (Font.SANS_SERIF, Font.PLAIN, fontSize);

	}

	private Font getTitleFont(int fontSize) {

		return new Font (Font.SANS_SERIF, Font.BOLD, fontSize);

	}

	private void loadComponent() {

		lblQuestion = new JLabel();
		lblQuestionNumber = new JLabel();
		radioBtn1 = new JRadioButton();
		radioBtn2 = new JRadioButton();
		radioGroup = new ButtonGroup();
		radioGroup.add(radioBtn1);
		radioGroup.add(radioBtn2);

		this.add(this.getQuestionPanel());

	}
	
	private void setQuestion() {

		if (questionManager.isQuestionsEmpty()) {
			new ResultDialog(this, resultManager.displayResult());
			this.dispose();
			this.windowClosing(null);
			return;
		}

		question = questionManager.getQuestion();
		this.lblQuestionNumber.setText(numbering++ + ". " );
		this.lblQuestion.setText(question.getQuery());
		this.radioBtn1.setText(question.getSelection1());
		this.radioBtn2.setText(question.getSelection2());

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (radioBtn1.isSelected()) 
			resultManager.resultHandler(question.getCategory1());

		else if (radioBtn2.isSelected()) 
			resultManager.resultHandler(question.getCategory2());

		else {
			JOptionPane.showMessageDialog(this, "Please select an answer", "No Selected", JOptionPane.WARNING_MESSAGE);
			return;
		}

		radioGroup.clearSelection();
		this.setQuestion();

	}

	@Override
	public void windowActivated(WindowEvent arg0) {

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		this.frame.setVisible(true);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {

	}

	@Override
	public void windowIconified(WindowEvent arg0) {

	}

	@Override
	public void windowOpened(WindowEvent arg0) {

	}

}
