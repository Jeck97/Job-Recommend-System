package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private int width = 500;
	private int height = 550;
	private JLabel lblTitle;
	private JLabel lblText;
	private JLabel lblInstruction;
	private JButton btnStart;
	private JButton btnInstruction; 
	private JLabel lblSentimental;
	private JLabel lblSentimentalDescription;
	private JLabel lblTheoretical;
	private JLabel lblTheoreticalDescription;
	private JLabel lblStructured;
	private JLabel lblStructuredDescription;
	private JLabel lblFlexible;
	private JLabel lblFlexibleDescription;
	private JLabel lblOutgoing;
	private JLabel lblOutgoingDescription;
	private JLabel lblReserved;
	private JLabel lblReservedDescription; 
	private JLabel lblInstructionTitle;
	private JLabel lblInstruction1;
	private JLabel lblInstruction2;

	public MainFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

		UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
		
		// Default frame setting
		this.setTitle("Job Recommend System");
		this.setSize(width, height);
		this.setResizable(false);
		this.setLayout(new BorderLayout());

		// Center the frame 
		this.setLocationRelativeTo(null);

		// Must close on X
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Organize component
		this.loadComponent();

	}

	private JPanel getTitlePanel() {

		// Initialize component to be used
		JPanel panel =  new JPanel(new GridLayout(2,1));
		JPanel pnlLabelTitle = new JPanel();
		JPanel pnlLabelText = new JPanel();

		lblTitle = new JLabel("Job Recommend System");
		lblText = new JLabel("You can find who you are and what job suit you");

		// Style the component
		lblTitle.setFont(this.getFont(40));
		lblText.setFont(this.getFont(22));

		// Add component to panel
		pnlLabelTitle.add(lblTitle);
		pnlLabelText.add(lblText);
		panel.add(pnlLabelTitle);
		panel.add(pnlLabelText);

		return panel;
	}

	private JPanel getButtonPanel() {

		// Initialize component to be used
		JPanel panel = new JPanel();
		JPanel pnlBtnStart = new JPanel();
		JPanel pnllblInstruction = new JPanel();
		JPanel pnlbtnInstruction = new JPanel();

		btnStart = new JButton("Start");
		btnInstruction = new JButton("Instruction");


		btnStart.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLACK), 
				BorderFactory.createEmptyBorder(30, 140, 30, 140)));
		btnStart.setFont(this.getFont(35));

		btnStart.setActionCommand("Start");
		btnStart.addActionListener(this);
		btnStart.setFocusable(false);
		
		btnInstruction.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLACK), 
				BorderFactory.createEmptyBorder(30, 100, 30, 100)));
		btnInstruction.setFont(this.getFont(35));

		btnInstruction.setActionCommand("Instruction");
		btnInstruction.addActionListener(this);
		btnInstruction.setFocusable(false);
		lblInstruction = new JLabel("Read instruction before you start the test.");

		lblInstruction.setFont(this.getFont(25));
		lblInstruction.setBorder(
				BorderFactory.createEmptyBorder(30, 100, 30, 100));

		// Add component to panel
		pnllblInstruction.add(lblInstruction);
		pnlBtnStart.add(btnStart);
		panel.add(pnlBtnStart);
		panel.add(pnllblInstruction);
		pnlbtnInstruction.add(btnInstruction);
		panel.add(pnlbtnInstruction);


		return panel;
	}

	private JPanel getInstructionPanel() {

		JPanel panel = new JPanel(new GridLayout(15,1));

		lblSentimental = new JLabel("Sentimental");
		lblSentimentalDescription = new JLabel("A person who relies on emotions more than reason, or a novel or film that is overly emotional. ");
		lblTheoretical = new JLabel("Theoretical");
		lblTheoreticalDescription = new JLabel("A person who enjoy understanding how and why things are done. It gives you opportunity to understand why one technique would work and why other technique would be fail.");
		lblStructured = new JLabel("Structured");
		lblStructuredDescription = new JLabel("A person who happiest when your day is planned out, with lists of things to do, and a tightly-packed schedule,");
		lblFlexible = new JLabel("Flexible");
		lblFlexibleDescription = new JLabel("A personality trait that describes the extent to which a person can cope with changes in circumstances and think about problems and tasks in novel, creative ways.");
		lblOutgoing = new JLabel("Outgoing");
		lblOutgoingDescription = new JLabel("A person with a friendly, easy personality.");
		lblReserved = new JLabel("Reserved");
		lblReservedDescription = new JLabel("A person who is saved for someone or some purpose, or is a person who doesn't share his feelings, thoughts or emotions."); 
		lblInstructionTitle = new JLabel("Instruction: ");
		lblInstruction1 = new JLabel("Read the question carefully and answer with your first answer.");
		lblInstruction2 = new JLabel("Second thought will affect the result of the test.");

		lblInstructionTitle.setFont(this.getTitleFont(30));
		lblInstruction1.setFont(this.getFont(27));
		lblInstruction2.setFont(this.getFont(27));
		
		lblSentimental.setFont(this.getTitleFont(25));
		lblTheoretical.setFont(this.getTitleFont(25));
		lblStructured.setFont(this.getTitleFont(25));
		lblFlexible.setFont(this.getTitleFont(25));
		lblOutgoing.setFont(this.getTitleFont(25));
		lblReserved.setFont(this.getTitleFont(25));
		
		lblSentimentalDescription.setFont(this.getFont(20));
		lblTheoreticalDescription.setFont(this.getFont(20));
		lblStructuredDescription.setFont(this.getFont(20));
		lblFlexibleDescription.setFont(this.getFont(20));
		lblOutgoingDescription.setFont(this.getFont(20));
		lblReservedDescription.setFont(this.getFont(20));
		
		panel.add(lblInstructionTitle);
		panel.add(lblInstruction1);
		panel.add(lblInstruction2);
		panel.add(lblSentimental);
		panel.add(lblSentimentalDescription);
		panel.add(lblTheoretical);
		panel.add(lblTheoreticalDescription);
		panel.add(lblStructured);
		panel.add(lblStructuredDescription);
		panel.add(lblFlexible);
		panel.add(lblFlexibleDescription);
		panel.add(lblOutgoing);
		panel.add(lblOutgoingDescription);
		panel.add(lblReserved);
		panel.add(lblReservedDescription);
		
		return panel;

	}

	private void loadComponent() {

		// Get panels
		JPanel pnlButton = this.getButtonPanel();
		JPanel pnlTitle = this.getTitlePanel();


		// Add panels to frame
		this.add(pnlTitle, BorderLayout.NORTH);
		this.add(pnlButton, BorderLayout.CENTER);

	}

	private Font getFont(int fontSize) {

		return new Font (Font.SANS_SERIF, Font.PLAIN, fontSize);

	}

	private Font getTitleFont(int fontSize) {

		return new Font (Font.SANS_SERIF, Font.BOLD, fontSize);

	}
	
	@Override
	public void actionPerformed(ActionEvent event) {

		String actionCommand = event.getActionCommand();

		if(actionCommand == "Start") {

			try {
				new QuestionFrame(this);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setVisible(false);
			
		} else if(actionCommand == "Instruction") {

			JOptionPane.showOptionDialog(this, this.getInstructionPanel(),
					"Instruction", 
					JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
					null, new Object[] { "Back" }, null);

		}

		
	}
}
