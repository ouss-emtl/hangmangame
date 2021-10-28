package hangman;

/**
 * Entry to the Hangman game.
 * 
 * @author V. Galtier
 *
 */
public class Controler {

	/**
	 * user interaction object
	 */
	protected View view;
	/**
	 * state of the word discovery
	 */
	protected Model model;

	public static void main(String[] arg) {
		new Controler();
	}

	/**
	 * Pick a random word from a list, create the View and Model objects and start
	 * the game.
	 */
	public Controler() {
		String[] words = new String[] { "Banana", "Chocolate", "Apple", "Cookie", "whale", "dinosaur" };
		String word = words[(int) (words.length * Math.random())];
		view = new View();
		model = new Model(word);
		play(word);
	}

	/**
	 * Game main loop: ask a character, feed it to the model, display feedback to
	 * the user and repeat until the word is guessed or 9 errors were made.
	 * 
	 * @param word the word to guess
	 */
	private void play(String word) {
		int nbErrors = 0;
		while (!model.isGuessed() && (nbErrors < 9)) {
			view.displayGame(model.getCurrent(), model.getErrors());
			Character c = view.readUserInput(new CharacterAsker(System.in, System.out));
			boolean isIn = model.tryLetter(c);
			if (!isIn)
				nbErrors++;
		}
		view.displayGame(model.getCurrent(), model.getErrors());
		if (model.isGuessed()) {
			view.sayCongrat();
		} else {
			view.sayGameOver(word);
		}
	}
}
