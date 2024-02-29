package cadenas;

import java.util.Arrays;
import java.util.Random;

public class Ahorcado {
	
	static String[] palabras = {
			"humanidad", "persona", "hombre", "mujer",
			"individuo", "cuerpo", "pierna", "cabeza",
			"brazo", "familia"
	};

	final static int NUMINTENTOS = 7;
	
	static int intentosActuales = 0;
	
	static String palabraSecreta = "";
	
	static String palabraPista = "";
	
	static String noAcertadas = "";
	
	static char[] letras;
	
	public Ahorcado() {}
	
	static void generaPalabra() {
		Random rand = new Random();
		
		palabraSecreta = palabras[rand.nextInt(0, palabras.length)];
		
		letras = new char[palabraSecreta.length()];
		Arrays.fill(letras, '_');
	}
	 
	static void compruebaLetra(String letra) {
		if (palabraSecreta.contains(letra)) {
			for (int i = 0; i < palabraSecreta.length(); i++) {
				if (String.valueOf(palabraSecreta.charAt(i)).equalsIgnoreCase(letra)) {
					letras[i] = letra.charAt(0);
				}
			}
			
			palabraPista = String.valueOf(letras);			
		} else {
			
			if (!noAcertadas.contains(letra)) {
				noAcertadas += letra;
				intentosActuales++;
			}
			
		}
	}
	
	static void compruebaPalabra(String cadena) {
		if (cadena.equalsIgnoreCase(palabraSecreta)) {
			palabraPista = cadena;
		} else {
			intentosActuales++;
		}
	}
	
	static void pintaPista() {
		System.out.println("Letras usadas no acertadas:");
		
		System.out.println(Arrays.toString(noAcertadas.toCharArray()));
		
		System.out.println("Pista: " + palabraPista);
	}
	
	
	
}
