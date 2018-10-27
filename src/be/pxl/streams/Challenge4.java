package be.pxl.streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

import be.pxl.streams.Person.Gender;

public class Challenge4 {
	public static void main(String[] args) {
		List<Person> personen = Arrays.asList(
				new Person("Sofie", 23, Gender.FEMALE),
				new Person("Adam", 31, Gender.MALE), 
				new Person("Bastiaan", 25, Gender.MALE),
				new Person("Berend", 22, Gender.MALE), 
				new Person("Aagje", 27, Gender.FEMALE)
		);
		// 1. Geef de gemiddelde leeftijd van alle personen
		// Verwachte output:  Gemiddelde leeftijd: 25.6
		
		OptionalDouble averageAge = personen.stream().mapToInt(Person::getAge).average();

		if (averageAge.isPresent()) {
			System.out.println("Gemiddelde leeftijd: " + averageAge.getAsDouble());
		} else {
			System.out.println("Average is not available");
		}

		// 2. Hoeveel mannen staan er in de lijst
		// Verwachte output: Aantal mannen: 3

		long numberOfMen = personen.stream().filter(p -> p.getGender() == Gender.MALE).count();

		System.out.println("Aantal mannen: " + numberOfMen);
		
		// 3. Hoeveel mannen ouder dan 24 staan er in de lijst
		// Verwachte output: Aantal mannen boven 24: 2

		long numberOfMenOlderThan24 = personen.stream().filter(p -> p.getGender() == Gender.MALE).filter(p -> p.getAge() > 24).count();
		//long numberOfMenOlderThan24 = personen.stream().filter(p -> p.getGender() == Gender.MALE && p.getAge() > 24).count(); MAG OOK IN 1 FILTER

		System.out.println("Aantal mannen boven 24: " + numberOfMenOlderThan24);

		// 4. Geef de gemiddelde leeftijd van alle mannen
		// Gemiddelde leeftijd mannen: 26.0

		OptionalDouble averageAgeOfMen = personen.stream().filter(p -> p.getGender() == Gender.MALE).mapToInt(Person::getAge).average();

		if (averageAgeOfMen.isPresent()) {
			System.out.println("Gemiddelde leeftijd mannen: " + averageAgeOfMen.getAsDouble());
		} else {
			System.out.println("Average is not available");
		}
		
		// 5. Maak een nieuwe persoon met als naam de eerste letter van iedere persoon in de lijst
		// en als leeftijd de som van alle leeftijden
		// Maak gebruik van de methode .reduce()

/*
		String nameReduce = personen.stream().map(p -> p.getName().substring(0,1)).reduce("", (a, b) -> a.substring(0,1) + b.substring(0,1));
		Integer totalAgeReduce = personen.stream().map(Person::getAge).reduce(0, (a, b) -> a + b);
*/

		//Person newPerson = new Person(personen.stream().map(p -> p.getName().substring(0,1)).reduce("", (a, b) -> a + b), personen.stream().map(Person::getAge).reduce(0, (a, b) -> a + b), Gender.FEMALE);

		Person newPerson = personen.stream().reduce(new Person("", 0, Gender.FEMALE), (p1,p2) -> { p1.setAge(p1.getAge() + p2.getAge()); p1.setName(p1.getName() + p2.getName().substring(0, 1)); return  p1;});

		System.out.println(newPerson.getName() + " " + newPerson.getAge());
	}
}
