package modelo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Silabas {
	public static void main(String[] args) {
		// Declaración de variables
		Scanner scan = new Scanner(System.in);
		String word = "";
		Pattern patern = Pattern.compile("(.*[\\d].*){1,}");
		Matcher matcher;

		// Obtención de datos
		System.out.print("Ingrese una palabra: ");
		word = scan.next();
		matcher = patern.matcher(word);

		// Se compara si no incluyen datos numericos, en caso de ser verdadero procede,
		// sino se sale
		if (!matcher.find()) {

			while (!word.endsWith("-")) {
				String[] splits = word.split("\\.");
				String token = (splits.length <= 1) ? word : splits[1];
				String eval = containsConsonants(token);
				if (eval != null) {
					String center = token.substring(0, token.indexOf(eval) + getSplitPosition(eval)) + "-";
					String right = token.substring(token.indexOf(eval) + getSplitPosition(eval));
					word = (splits.length <= 1) ? center + "." + right : splits[0] + center + "." + right;
				} else {
					word = word.replaceAll("\\.", "");
					word += "-";
				}
			}
			System.out.println(word.substring(0, word.length() - 1));

		} else {
			System.out.println("Error las palabras no pueden contener numeros");
		}

	}

	/* Método que verifica si una cadena contiene la estructua
	 "vocal{consonante(s)}vocal" si sí, regresa el token, si no devuelve null*/
	public static String containsConsonants(String word) {
		char[] characters = word.toCharArray();
		String token = "";
		for (int i = 0; i < characters.length; i++) {
			if (token.isEmpty() && isVowel(characters[i]) && i + 1 < characters.length && !isVowel(characters[i + 1])) {
				token += characters[i];
			} else if (!token.isEmpty()) {
				token += characters[i];
				if (isVowel(characters[i])) {
					return token;
				}
			}
		}
		return null;
	}

	// Método para evaluar si un carácter es una vocal.
	public static boolean isVowel(char character) {
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
		for (Character value : vowels) {
			if (character == value) {
				return true;
			}
		}
		return false;
	}

	/* Método que devuelve la cantidad de posiciones a recorrer despues de encontrar
	 el token para realizar el corte*/
	public static int getSplitPosition(String token) {
		String[] exceptions = { "pr", "pl", "br", "bl", "fr", "fl", "tr", "tl", "dr", "dl", "cr", "cl", "gr" };
		String constants = token.substring(1, token.length() - 1);
		int result = -1;
		char[] characters = constants.toCharArray();
		int counter = 0;

		for (int i = 0; i < characters.length; i++) {
			if (i + 1 < characters.length && ((characters[i] == 'l' && characters[i + 1] == 'l')
					|| (characters[i] == 'r' && characters[i + 1] == 'r')
					|| (characters[i] == 'c' && characters[i + 1] == 'h'))) {
			} else {
				counter++;
			}

		}
		switch (counter) {
		case 1:
			result = 1;
			break;
		case 2:
			for (String exception : exceptions) {
				if (exception.equals(constants)) {
					result = 1;
				}
			}
			result = (result == -1) ? 2 : result;
			break;
		case 3:
			for (String exception : exceptions) {
				if (exception.equals(constants.substring(1))) {
					result = 2;
				}
			}
			result = (result == -1) ? 3 : result;
			break;
		case 4:
			result = 3;
			break;
		default:

		}
		return result;
	}
}