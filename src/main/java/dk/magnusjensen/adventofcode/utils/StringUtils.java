package dk.magnusjensen.adventofcode.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringUtils {
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
		return "Failed";
	}

	public static boolean checkStringForWords(String input, String[] checkList) {
		for (String check : checkList) {
			if (input.contains(check)) {
				return true;
			}
		}
		return false;
	}

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
