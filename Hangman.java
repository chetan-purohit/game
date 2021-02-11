package test.demo.test;

import java.util.Scanner;

public class Hangman{

	private static String[] fruits = {"apple", "banana", "avocado", "orange", "grapes", "mango" };
	private static String fruit = fruits[(int) (Math.random() * fruits.length)];
	private static String asterisk = new String(new char[fruit.length()]).replace("\0", "#");
	private static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (count < 7 && asterisk.contains("#")) {
			System.out.println("Guess any letter of the fruits");
			System.out.println(asterisk);
			char guess = sc.next().charAt(0);
			hang(guess);
		}
		sc.close();
	}

	public static void hang(char guess) {
		String newasterisk = "";
		for (int i = 0; i < fruit.length(); i++) {
			if (fruit.charAt(i) == guess) {
				newasterisk += guess;
			} else if (asterisk.charAt(i) != '#') {
				newasterisk += fruit.charAt(i);
			} else {
				newasterisk += "#";
			}
		}

		if (asterisk.equals(newasterisk)) {
			count++;
			HangmanImage.hangmanImage(count);
		} else {
			asterisk = newasterisk;
		}
		if (asterisk.equals(fruit)) {
			System.out.println("Correct! You win! The word was " + fruit);
		}
	}


}
