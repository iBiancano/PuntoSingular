	package modelo;
	
	import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
	import java.util.List;
	import java.util.Scanner;
	
	public class Prueba {
		public static void main(String[] args) {
			//Inicializacion de variables
			List<Character> letters = new ArrayList<Character>();		
			int counter = 0, counterLetters = 1;
			Character previous = null;
			Scanner scan = new Scanner(System.in);
			
			//lectura de la palabra
			System.out.println("Ingresa una palabra:");
			String world = scan.next();
	
			//Proceso para agregar, ordenar y mostrar resultados
			for (int i = 0; i < world.length(); i++) {
				letters.add(world.charAt(i));
			}
			
			
			System.out.println(world+"]");
			world+=" -> [";
			while(counter < letters.size()) {
				if(counter+1<letters.size()) {
					if(letters.get(counter)!=letters.get(counter+1)) {
						world += letters.get(counter)+" -> "+counterLetters+", ";
						counterLetters=1;
					}else {
					counterLetters++;
					}
				}
				counter++;
				if(counter == letters.size()) {
					world += letters.get(counter-1)+" ->"+counterLetters+"][";
				}
			}
			
			Collections.sort(letters);
			for (Character character : letters) {
				world+=character;
			}
			
			
			System.out.println(world+"]");
		}
	}