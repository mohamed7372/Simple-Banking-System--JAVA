package simpleBankingSystem;

import java.util.Random;

class Card{
	int MII; // 1 digit
	int BIN; // 6 digits
	String AccountIdentifier; // 9 digits
	String CheckSum;
	String PIN;
	int Balance;
	
	public Card() {
		MII = 4;
		BIN = this.MII * 100000;
		AccountIdentifier = generateNbrs(9, 1000000000);
		CheckSum = generateNbrs(1, 9);
		
		PIN = generateNbrs(4, 10000);
		Balance = 0;
	}
	
	private String generateNbrs(int tailleNbr, int maxNbr) {
		Random rd = new Random();
		String a = String.valueOf(rd.nextInt(maxNbr));
		for (int i = a.length(); i < tailleNbr; i++) 
			a = "0" + a;
		return a;
	}
	
	String codeCard() {
		return BIN + AccountIdentifier + CheckSum;
	}
}
