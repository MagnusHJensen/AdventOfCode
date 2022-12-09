package dk.magnusjensen.adventofcode.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtils {
    /**
     * Gets the MD5 hash of any string.
     * @param input A string to get the MD5 hash of.
     * @return The MD5 hash of any string.
     */
	public static String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] messageDigest = md.digest(input.getBytes());

			BigInteger no = new BigInteger(1, messageDigest);

			StringBuilder hashText = new StringBuilder(no.toString(16));

			while (hashText.length() < 32) {
				hashText.insert(0, "0");
			}

			return hashText.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		throw new RuntimeException("Failed");
	}

    /**
     *
     * @param input The String to check
     * @param checkList A list words to check for.
     * @return A boolean if the input contains any of the checkList words.
     */
	public static boolean checkStringForWords(String input, String[] checkList) {
		for (String check : checkList) {
			if (input.contains(check)) {
				return true;
			}
		}
		return false;
	}

    /**
     * Returns how many times the string matches a character from the list.
     * @param input The string to check characters for.
     * @param chars An array of characters.
     * @return How many times the string matches a character from the list.
     */
	public static int countCharactersInString(String input, char[] chars) {
		int counter = 0;
		for (char chr : input.toCharArray()) {
			for (char check : chars) {
				if (chr == check) {
					counter++;
					break;
				}
			}
		}
		return counter;
	}

    /**
     *
     * @param input The string to check
     * @param amount The amount of characters there should be in a row.
     * @return A boolean based on if the string contained the amount of characters in a row.
     */
	public static boolean checkCharsInRow(String input, int amount) {
		char chrCheck = 0;
		int counter = 0;

		for (char chr : input.toCharArray()) {
			if (chr == chrCheck) {
				counter++;
				if (counter >= amount) {
					return true;
				} else {
					continue;
				}
			}
			chrCheck = chr;
			counter++;
		}
		return false;
	}

	public static boolean checkStringForPairs(String input, int pairSize, int pairAmount) {
		String currentPair = "";
		for (int i = 0; i < input.length(); i++) {
			boolean failed = false;
			if (i + pairSize > input.length() - 1) return false;
			currentPair = input.substring(i, i + pairSize);
			String reducedString = input.substring(i + pairSize);
			for (int j = 1; j < pairAmount; j++) {
				if (!reducedString.contains(currentPair)) {
					failed = true;
					break;
				}
				reducedString = reducedString.substring(reducedString.indexOf(currentPair));
			}
			if (!failed) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkCharRepeatsWithSpace(String input, int space, int timesShouldRepeat) {

		for (int i = 0; i < input.length(); i++) {
			char chr = input.charAt(i);
			int counter = 0;
			for (int j = 0; j < timesShouldRepeat; j++) {
				if (i + space + 1 > input.length() - 1) return false;
				if (input.charAt(i + space + 1) == chr) {
					counter++;
				}
			}
			if (counter >= timesShouldRepeat) {
				return true;
			}
		}
		return false;
	}
}
