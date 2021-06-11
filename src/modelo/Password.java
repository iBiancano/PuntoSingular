package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
	public static void main(String[] args) {
		
		//Declaraci�n de variables y obtenci�n de datos.
		System.out.print("Contrase�a: ");
		Scanner scan = new Scanner(System.in);
		String password = scan.nextLine();
		String messagge = "";
		
		//Validaciones y formateo de resultado.
		messagge += (validate(password, "[\\s]{1}")) ? "Error la contrase�a no debe tener espacios en blanco\n" : "";
		messagge += (validate(password, "[*|_|\\-|�|�|?|#|$]{1,}")) ? ""
				: "Error la contrase�a debe tener al menos un car�cter especial (*_-��?#$)\n";
		messagge += (validate(password, "(.*[A-Z].*){2,}")) ? ""
				: "Error la contrase�a debe tener al menos 2 letras May�sculas\n";
		messagge += (password.length() >= 8 && password.length() <= 15) ? ""
				: "Error la contrase�a debe tener de 8 a 15 caracteres\n";
		messagge += (validate(password, "(.*[\\d].*){3,}")) ? ""
				: "Error la contrase�a debe tener al menos 3 n�meros\n";
		messagge += (hasDifferentNumbers(password)) ? "" : "Error la contrase�a debe tener n�meros repetidos";

		messagge += (messagge.isEmpty())?"Contrase�a valida":"";
		//Se muestra el resultado
		System.out.println(messagge);
	}

	//M�todo de validaci�n de expresiones regulares, recibe la cadena y la expresion regular, devuelve el resultado.
	public static boolean validate(String string, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(string);
		return matcher.find();
	}
	//M�todo que eval�a si contiene numeros diferentes
	public static boolean hasDifferentNumbers(String string) {
		char[] characters = string.toCharArray();
		List<Character> container = new ArrayList<>();
		for (char c : characters) {
			if (Character.isDigit(c) && container.contains(c)) {
				return false;
			}
			container.add(c);
		}
		return true;
	}
}
