package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Letras {
	public static void main(String[] args) {
	// Inicializacion de variables
		List<Character> letters = new ArrayList<>();
		List<Integer> counters = new ArrayList<>();
		Scanner scan = new Scanner(System.in);

	// lectura de la palabra
		System.out.println("Ingresa una palabra:");
		String word = scan.next();

	// Cadena ordenada
		char[] arraysString = word.toCharArray();
		Arrays.sort(arraysString);

	//Inserción, conteo y formateo del resultado
		for (int i = 0; i < word.length(); i++) {
			Character letter = Character.toLowerCase(word.charAt(i));
			if (!letters.contains(letter)) {
				letters.add(letter);
				counters.add(1);
			} else {
				counters.set(letters.indexOf(letter), counters.get(letters.indexOf(letter)) + 1);
			}
		}
		word += " --> [";
		for (int i = 0; i < letters.size(); i++) {
			word += letters.get(i) + "->" + counters.get(i);
			word += (i + 1 == letters.size()) ? "]" : ", ";
		}
		word += Arrays.toString(arraysString).replace(", ", "");
	//Se muestra el resultado
		System.out.println(word);

	}
}
