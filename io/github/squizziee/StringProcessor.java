package io.github.squizziee;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ThreadLocalRandom;

public class StringProcessor {

	public static String reverse(String str) {
		List<String> list = new LinkedList<>(Arrays.asList(str.split("")));
		StringBuilder result = new StringBuilder();
		ListIterator<String> it = list.listIterator(list.size());
		while (it.hasPrevious())
			result.append(it.previous());
		return result.toString();
	}
	
	public static boolean isPalindrome(String str, boolean caseSensitive) {
		String processString;
		if (caseSensitive)
			processString = str;
		else
			processString = str.toLowerCase();
		if (processString.length() == 0)
			return false;
		else if (processString.length() == 1)
			return true;
		else {
			if (processString.substring(0, 1).equals(processString.substring(processString.length() - 1))) {
				if (processString.length() == 2)
					return true;
				return isPalindrome(processString.substring(1, processString.length() - 1), caseSensitive);
			} else {
				return false;
			}
		}
	}
	
	public static String generateRandomWord(int length, boolean uppercase) {
		final String[] LETTERS = "abcdefghijklmnopqrstuvwxyz".split(""); 
		final String[] VOWELS = "euioa".split("");
		StringBuilder result = new StringBuilder();
		for (int i = 0; i <= length; i++) {
			int token = ThreadLocalRandom.current().nextInt(0, 1 + 1);
			switch (token) {
				case 0 :
					result.append(LETTERS[ThreadLocalRandom.current().nextInt(0, LETTERS.length)]);
					break;
				case 1 :
					result.append(VOWELS[ThreadLocalRandom.current().nextInt(0, VOWELS.length)]);
					break;
			}
		}
		if (uppercase)
			return result.toString().toUpperCase();
		return result.toString();
	}
	
}
