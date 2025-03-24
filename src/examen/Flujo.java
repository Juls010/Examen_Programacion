package examen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Flujo {

	public static void main(String[] args) {
		String documento = "datos.csv";
		Scanner scanner = new Scanner(System.in);
		while(true) {
		System.out.println("---- menu----");
		System.out.println("opcion 1: leer archivo");
		System.out.println("opcion2 : agregar lineas");
		System.out.println("opcion 3: filtrar lineas");
		System.out.println("option 4: ordenar");
		System.out.println("opcion 5: salir ");
		
		int opcion = scanner.nextInt();
			
	try {
	switch (opcion) {
			case 1: {
				leerArchivo(documento);
				break;
			}case 2: {
				agregarLinea(documento, scanner);
				break;
			}case 3: {
				filtrarLineas(documento, scanner);
				break;
			}case 4: {
				ordenarLineas(documento);
				break;
			}case 5: {
				System.out.println("saliendo...");
				return;
			}
			default:
				throw new IllegalArgumentException("Opcion Invalida: " + opcion);
			}catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			} 
	}
		
		}
		
		
		

	public static void leerArchivo(String documento) {
		// Creo la instancia de la clase File:
		File archivo = new File("datos.cvs");

		// compruebo que el archivo no está vacío:
		if (!archivo.exists()) {
			System.out.println("El archivo no existe.");
			return;
		}
		// leemos el documento con BufferredReader y FileReader
		try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
			// creamos la variable linea
			String linea;
			System.out.println("\nContenido del archivo:");
			// si la linea no está vacía, se imprime:
			while ((linea = reader.readLine()) != null) {
				System.out.println(linea);
			}
			// se recogen errores:
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void agregarLinea(String documento, Scanner scanner) {
		// se pide al usuario el nombre, la edad y el departamento:
		System.out.print("Introduce el nombre: ");
		String nombre = scanner.nextLine();
		System.out.print("Introduce la edad: ");
		int edad = scanner.nextInt();
		// se consume el salto de linea:
		scanner.nextLine();
		System.out.print("Introduce el departamento: ");
		String departamento = scanner.nextLine();

		// escribo el documento usando BufferWriter
		// pongo true para que no se sobre escriba la linea:
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(documento, true))) {
			// separo los campos con , y lo guardo en el documento:
			writer.write(nombre + "," + edad + "," + departamento);
			writer.newLine();
			System.out.println("Línea agregada.");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void filtrarLineas(String documento, Scanner scanner) {
		// se pide el filtro al usuario:
		System.out.print("Introduce el departamento para filtrar: ");
		String filtro = scanner.nextLine();
		// creo una lista con las lineas que se van a filtrar del archivo:
		ArrayList<String> lineasFiltradas = new ArrayList<>();
		// se lee el archivo y se comprueba que no esta vacio:
		try (BufferedReader reader = new BufferedReader(new FileReader(documento))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				if (linea.contains(filtro)) {
					// se añade a la lista:
					lineasFiltradas.add(linea);
				}
			}
			// errores:
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// se comprueba si se ha encontrado el filtro pedido:
		if (lineasFiltradas.isEmpty()) {
			System.out.println("No se encontraron líneas con el filtro '" + filtro + "'.");
		} else {
			System.out.println("\nLíneas filtradas:");
			lineasFiltradas.forEach(System.out::println);
		}

	}

	public static void ordenarLineas(String documento) {
		// se crea una nuva array list para guardar las lineas del documento:
		ArrayList<String> lineas = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(documento))) {
			String linea;
			// se comprueba que la linea no está vacia y se añade
			while ((linea = reader.readLine()) != null) {
				lineas.add(linea);
			}
			// errores:
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// uso collections para ordenar la lista:
		Collections.sort(lineas);

		// se escribe en la nueva lista las lineas ordenadas:
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(documento))) {
			for (String linea : lineas) {
				writer.write(linea);
				writer.newLine();
			}
			System.out.println("El archivo ha sido ordenado.");

			// errores:
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
