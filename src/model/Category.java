package model;

public class Category {

	private int structured;
	private int flexible;
	private int outgoing;
	private int reserved;
	private int theoretical;
	private int sentimental;

	public static final int FLEXIBLE = 0;
	public static final int OUTGOING = 1;
	public static final int RESERVED = 2;
	public static final int SENTIMENTAL = 3;
	public static final int STRUCTURED = 4;
	public static final int THEORETICAL = 5;


	private String[][] countType = new String[6][2];

	public int getStructured() {
		return structured;
	}

	public void setStructured(int structured) {
		this.structured = structured;
	}

	public int getFlexible() {
		return flexible;
	}

	public void setFlexible(int flexible) {
		this.flexible = flexible;
	}

	public int getOutgoing() {
		return outgoing;
	}

	public void setOutgoing(int outgoing) {
		this.outgoing = outgoing;
	}

	public int getReserved() {
		return reserved;
	}

	public void setReserved(int reserved) {
		this.reserved = reserved;
	}

	public int getTheoretical() {
		return theoretical;
	}

	public void setTheoretical(int theoretical) {
		this.theoretical = theoretical;
	}

	public int getSentimental() {
		return sentimental;
	}

	public void setSentimental(int sentimental) {
		this.sentimental = sentimental;
	}

	private  void addMarks() {

		for(int i = 0; i <= 5; i++) {

			countType[i][0] = String.valueOf(i); 	

		}

		countType[FLEXIBLE][1] = String.valueOf(getFlexible()); 
		countType[OUTGOING][1] = String.valueOf(getOutgoing()); 
		countType[RESERVED][1] = String.valueOf(getReserved()); 
		countType[SENTIMENTAL][1] = String.valueOf(getSentimental()); 
		countType[STRUCTURED][1] = String.valueOf(getStructured()); 
		countType[THEORETICAL][1] = String.valueOf(getTheoretical()); 

	}

	public String[][] calculateHighestMark() {

		addMarks();
		String number = new String();
		String value = new String();

		for(int nice = 0; nice < 5; nice++) {
			for(int index = 0; index < 5 - nice; index++) {

				int temp = Integer.parseInt(countType[index][1]);
				int temp2 = Integer.parseInt(countType[index + 1][1]);

				if(temp < temp2) {

					number = countType[index + 1][0];
					value = countType[index + 1][1];

					countType[index + 1][0] = countType[index][0];
					countType[index + 1][1] = countType[index][1];

					countType[index][0] = number;
					countType[index][1] = value;

				}

			}
		}

		return countType;
	}



















}
