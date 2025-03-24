package examen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Array {
	public static void main(String[] args) {
		//creo el scanner y la arrayList que necesito:
		Scanner scanner = new Scanner (System.in);
		ArrayList<Integer> enteros = new ArrayList<>();
		
		//pido 5 numeros por la consola y las guardo en la variable numero:
		System.out.println("Ingresa 5 numeros enteros: ");
		int numero = scanner.nextInt();
		
		//recorro la lista de enteros para meter cada registro que mete el usuario:
		for (int i = 1; i < 5; i++) {
			enteros.add(scanner.nextInt());
		}

		// creo la variable de suma, max y min
		int suma = 0;
		int max = enteros.get(0);
		int min = enteros.get(0);
		
		// recorro la lista para sumar cada elemento
		// tambien compruebo el maximo y minimo de la lista en cada vuelta:
		for (int i = 1; i < 5; i++) {
			suma += i;
			
			if(i > max) {
				max = i;
			}
			if(i < min) {
				min = i;
			}
		}
		
		// calculo el promedio o media con la suma y el tamaño de la lista:
		double promedio = (double) suma / enteros.size();
		
		// creo una nuva lista para añadir los nuevos numeros ordenados
		ArrayList<Integer> listaOrdenada = new ArrayList<>();
		//uso la clase Collections para ordenar la lista:
		Collections.sort(enteros);
		
		System.out.println("Lista ordenada:");
		// recorro la lista para añadir cada numero a la lista ordenada
		// y ademas lo imprimo
		for (int i = 1; i <= 5; i++) {
			listaOrdenada.add(i);
			System.out.println(i);
		}
		
		// imprimo el resultado d las variables:
		System.out.println("La suma es: "+ suma);
		System.out.println("El numero maximo es: " + max);
		System.out.println("El numero minimo es: " + min);
		System.out.println("La media es de: " + promedio);
		
		// cierro scanner por seguridad:
		scanner.close();
	}
}
