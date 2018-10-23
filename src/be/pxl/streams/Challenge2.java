package be.pxl.streams;

import java.util.OptionalInt;
import java.util.Random;

public class Challenge2 {
	public static void main(String[] args) {
		// maak een stream met 10 random gehele getallen tussen 0 en 30
		// bekijk hiervoor de methode ints(...) in de klasse Random
		// filter de getallen die deelbaar zijn door 3
		// en geef het maximum 
		// gebruik eventueel peek() om een tussenresultaat van de stream te tonen


		Random random = new Random();

		OptionalInt max = random.ints(10, 0,30)/*.peek(n -> System.out.println("###" + n))*/.filter(n -> n % 3 == 0)/*.peek(n -> System.out.println("##" + n))*/.max();

		if (max.isPresent()) {
			System.out.println("Maximum : " + max.getAsInt());
		} else {
			System.out.println("Geen maximum beschikbaar.");
		}
	}
}
