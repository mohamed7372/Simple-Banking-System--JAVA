package simpleBankingSystem;

import java.util.ArrayList;

public class BankingSystem {
	ArrayList<Card> cards = new ArrayList<Card>();
	
	void addCard(Card card) {
		cards.add(card);
	}
	Card isExiste(String cardNumber, String pin) {
		for (int i = 0; i < cards.size(); i++) 
			if(cards.get(i).PIN.equals(pin) && cards.get(i).codeCard().equals(cardNumber))
				return cards.get(i);
		return null;
	}
}
