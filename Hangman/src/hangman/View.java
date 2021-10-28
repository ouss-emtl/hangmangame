package hangman;

/**
 * In charge of interacting with the user of the Hangman game.
 * 
 * @author V. Galtier
 *
 */
public class View {

	/**
	 * Ask the user to input a character until she/he provides in a letter. Both
	 * upper case and lower case characters are accepted; if the user inputs a lower
	 * case character, it is transformed to upper case. Accentuated characters are
	 * not accepted.
	 * 
	 * @param characterAsker I/O system to use to interact with the user
	 * @return an upper case letter [A-Z]
	 */
	public static char readUserInput(CharacterAsker characterAsker) {
		char c = characterAsker.askChar("Enter a guess: ");
		String validChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		while (!validChars.contains(Character.toString(c))) {
			c = characterAsker.askChar(c + " is not a valid letter. Enter a new guess: ");
		}
		return c;
	}

	/**
	 * Display the current state of the game.
	 * 
	 * @param current the current state of the word to be discovered, with place
	 *                holders for unknown letters
	 * @param errors  the list of failed attempts
	 */
	public void displayGame(String current, String errors) {
		if (errors.length() > 0) {
			System.out.println("Your attempts: " + errors);
			displayAsciiHangman(errors.length());
		}
		System.out.println("Word to guess: " + current);
	}

	/**
	 * Print a congratulation message.
	 * 
	 * @param word
	 */
	public void sayCongrat() {
		System.out.print("Congratulations!");
	}

	/**
	 * Print a game over message and reveals the word to guess.
	 * 
	 * @param word the word to guess
	 */
	public void sayGameOver(String word) {
		System.out.print("Game over :-(  The word was \"" + word + "\".");
	}

	/**
	 * Print an ASCII Hangman stick figure. The number of elements in the figure
	 * depends on the number of errors.
	 * 
	 * @param nbErrors number of errors
	 */
	protected void displayAsciiHangman(int nbErrors) {
		String hangman = "";
		if (nbErrors == 0) {
			hangman = "-------     \n";
		} else if (nbErrors == 1) {
			hangman = "                \n";
			hangman += "    |           \n";
			hangman += "    |           \n";
			hangman += "    |           \n";
			hangman += "    |           \n";
			hangman += " --------       \n";
		} else if (nbErrors == 2) {
			hangman = "    -------     \n";
			hangman += "    |           \n";
			hangman += "    |           \n";
			hangman += "    |           \n";
			hangman += "    |           \n";
			hangman += " --------       \n";
		} else if (nbErrors == 3) {
			hangman = "    -------     \n";
			hangman += "    |/          \n";
			hangman += "    |           \n";
			hangman += "    |           \n";
			hangman += "    |           \n";
			hangman += " --------       \n";
		} else if (nbErrors == 4) {
			hangman = "    -------     \n";
			hangman += "    |/    0     \n";
			hangman += "    |           \n";
			hangman += "    |           \n";
			hangman += "    |           \n";
			hangman += " --------       \n";
		} else if (nbErrors == 5) {
			hangman = "    -------     \n";
			hangman += "    |/    0     \n";
			hangman += "    |     |     \n";
			hangman += "    |           \n";
			hangman += "    |           \n";
			hangman += " --------       \n";
		} else if (nbErrors == 6) {
			hangman = "    -------     \n";
			hangman += "    |/    0     \n";
			hangman += "    |   --|     \n";
			hangman += "    |           \n";
			hangman += "    |           \n";
			hangman += " --------       \n";
		} else if (nbErrors == 7) {
			hangman = "    -------     \n";
			hangman += "    |/    0     \n";
			hangman += "    |   --|--   \n";
			hangman += "    |           \n";
			hangman += "    |           \n";
			hangman += " --------       \n";
		} else if (nbErrors == 8) {
			hangman = "    -------     \n";
			hangman += "    |/    0     \n";
			hangman += "    |   --|--   \n";
			hangman += "    |    /      \n";
			hangman += "    |           \n";
			hangman += " --------       \n";
		} else if (nbErrors == 9) {
			hangman = "    -------     \n";
			hangman += "    |/    0     \n";
			hangman += "    |   --|--   \n";
			hangman += "    |    / \\    \n";
			hangman += "    |           \n";
			hangman += " --------       \n";
		}
		System.out.println(hangman);
	}
}
