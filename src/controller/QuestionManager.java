package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Vector;

import model.Question;

public class QuestionManager {
	
	private Vector<Question> questions;
	
	public QuestionManager() {
		
		this.questions = this.retrieveQuestions();
		
	}
	
	public Question getQuestion() {
		
		SecureRandom random = new SecureRandom();
		int index = random.nextInt(questions.size());
		
		Question question = questions.get(index);
		questions.remove(index);
		
		return question;
		
	}
	
	public boolean isQuestionsEmpty() {
		
		return this.questions.isEmpty();
		
	}
	
	private Vector<Question> retrieveQuestions() {
		
		Vector<Question> questions = new Vector<Question>();
		
		try {
			
			String line = new String();
			FileReader fileReader = new FileReader("Question.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while ((line = bufferedReader.readLine()) != null) {

				Question question = new Question(line.split(";"));
				questions.add(question);
				
			}
			
			bufferedReader.close();
			fileReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return questions;
		
	}

}
