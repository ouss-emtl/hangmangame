package hangman;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Wrapper for system input/output functions. Useful to test drive the View
 * code.
 * 
 * @author V. Galtier
 *
 */
public class CharacterAsker {
	private final Scanner scanner;
	private final PrintStream out;

	/**
	 * Define the input source and output destination of interactions with the user.
	 * 
	 * @param in  Where to read user inputs from? Probably from "System.in" in
	 *            production.
	 * @param out Where to send messages to the user? Probably to "System.out" in
	 *            production.
	 */
	public CharacterAsker(InputStream in, PrintStream out) {
		scanner = new Scanner(in);
		this.out = out;
	}

	/**
	 * Prompt the user to enter a character and return it.
	 * 
	 * @param message user prompt
	 * @return first input character, transformed to upper case
	 */
	public char askChar(String message) {
		out.print(message);
		return scanner.next().toUpperCase().charAt(0);
	}
}
