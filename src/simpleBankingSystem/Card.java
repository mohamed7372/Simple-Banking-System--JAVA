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
		CheckSum = "0";
		PIN = generateNbrs(4, 10000);
		Balance = 0;
		String som = "";
		do {
			AccountIdentifier = generateNbrs(9, 1000000000);
			som = luhnAlgo();
		}while(som.length() != 1);
		CheckSum = som;
	}
	
	private String generateNbrs(int tailleNbr, int maxNbr) {
		Random rd = new Random();
		String a = String.valueOf(rd.nextInt(maxNbr));
		for (int i = a.length(); i < tailleNbr; i++) 
			a = "0" + a;
		return a;
	}
	private String luhnAlgo() {
		int arr[] = new int[15];
		for (int i = 0; i < codeCard().length()-1; i++) 
			arr[i] = Integer.valueOf(codeCard().substring(i,i+1));
		int som = 0;
		for (int i = 0; i < arr.length; i++) {
			if(i % 2 == 0)
				arr[i] *= 2;
			if(arr[i] > 9)
				arr[i] -= 9;
			som += arr[i];
		}
		return 60 - som % 60 + "";
	}
	String codeCard() {
		return BIN + AccountIdentifier + CheckSum;
	}
}
