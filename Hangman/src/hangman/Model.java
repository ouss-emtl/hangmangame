package hangman;

/**
 * Represent the state of a Hangman game.
 * 
 * @author V. Galtier
 *
 */
public class Model {

	/**
	 * the word to be guessed
	 */
	protected String objective;
	/**
	 * the current state of the discovery: non-discovered letters are replaced by
	 * place holders
	 */
	protected String current;
	/**
	 * list of failed attempts to discover a letter of the word (or repetitions of
	 * already discovered letters)
	 */
	protected String errors;
	/**
	 * place holder for unknown letters
	 */
	private static final char BLANK = '-';

	/**
	 * Create a new Model.
	 * 
	 * @param word the word to be guessed
	 */
	public Model(String word) {
		objective = word.toUpperCase();
		current = "";
		for (int c = 0; c < word.length(); c++) {
			current += BLANK;
		}
		errors = "";
	}

	/**
	 * Check if a letter is part of the word to guess. If the word contains the
	 * letter, and this is the first presentation of the letter, it updates
	 * 'current'. Otherwise, it update 'errors'.
	 * 
	 * @param letter the letter to try
	 * @return true if the word contains the letter, false otherwise
	 */
	public boolean tryLetter(char letter) {
		letter = Character.toUpperCase(letter);
		if ( // letter is not part of the word
		(!objective.contains(Character.toString(letter))) ||
		// or letter was tried already (successfully or not):
				(errors.contains(Character.toString(letter))) || (current.contains(Character.toString(letter)))) {
			errors += letter;
			return false;
		} else {
			for (int i = 0; i < objective.length(); i++) {
				if (objective.charAt(i) == letter) {
					current = current.substring(0, i) + letter + current.substring(i + 1, current.length());
				}
			}
			return true;
		}
	}

	/**
	 * Check if all letters in the word were discovered.
	 * 
	 * @return true if all letters in the word were discovered, else return false
	 */
	public boolean isGuessed() {
		return !current.contains(Character.toString(BLANK));
	}

	/**
	 * Representation of the word in discovery mode.
	 * 
	 * @return the current state of the discovery: non-discovered letters are
	 *         replaced by place holders
	 */
	public String getCurrent() {
		return current;
	}

	/**
	 * List the characters tried that did not yield to the discovery of a new
	 * letter.
	 * 
	 * @return list of failed attempts to discover a letter of the word (or
	 *         repetitions of already discovered letters)
	 */
	public String getErrors() {
		return errors;
	}

}
