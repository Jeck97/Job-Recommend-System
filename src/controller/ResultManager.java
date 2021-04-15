package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import model.Category;


public class ResultManager{

	private Category field = new Category();

	/**
	 * 
	 * This method analysis the result from the question set.
	 * 
	 * @param name of the JRadioButton as the answer from user 
	 *
	 */
	public void resultHandler(String type) {

		// Depends on the value of radio button to call specific function
		switch(type.toLowerCase()) {

		case "sentimental":
			field.setSentimental(field.getSentimental() + 1);
			break;

		case "structured":
			field.setStructured(field.getStructured() + 1);
			break;

		case "flexible":
			field.setFlexible(field.getFlexible() + 1);
			break;

		case "outgoing":
			field.setOutgoing(field.getOutgoing() + 1);
			break;

		case "reserved":
			field.setReserved(field.getReserved() + 1);
			break;

		case "theoretical":
			field.setTheoretical(field.getTheoretical() + 1);

		}
	}

	/**
	 * 
	 * This method calculate the marks from the question and
	 * display the result for the user
	 * 
	 */
	public String displayResult() {

		String result = new String();

		try {

			String line = new String();
			FileReader fileReader = new FileReader("Result.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String[][] ranking = field.calculateHighestMark();

			String firstInStr = getResultInStr(ranking[0][0]);
			String secondInStr = getResultInStr(ranking[1][0]);

			while ((line = bufferedReader.readLine()) != null) {

				String[] whole = line.split(";");

				if(whole[0].equalsIgnoreCase(firstInStr) && whole[1].equalsIgnoreCase(secondInStr)) {
					result = whole[2];
					break;
				}
			}

			bufferedReader.close();
			fileReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;

	}


	private String getResultInStr(String ranking) {

		String inStr = null;

		switch(ranking) {

		case "0":
			inStr = "fl";
			break;
		case "1":
			inStr = "ou";
			break;
		case "2":
			inStr = "re";
			break;
		case "3":
			inStr = "se";
			break;
		case "4":
			inStr = "st";
			break;
		case "5":
			inStr = "th";
		}

		return inStr;
	}

}
