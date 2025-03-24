package examen;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio1 {

	public static void main(String[] args) {
		// creo las variables
		int num1 = 5;
		double num2 = 2.2;
		String mensaje = "La operacion es: ";

		// hago la suma de las dos variables
		double suma = num1 + num2;

		// convierto el double en un string:
		String cadena = String.valueOf(suma);

		// Lo concateno con otra cadena:
		String mensajeCadena = "La cadena es: " + cadena;

		// Se reemplaza la palabra 'operación' por 'calculo':
		String reemplazo = mensaje.replace("operacion", "calculo");

		// saco el subString empezando por la posicion 0 hasta llegar a la 5:
		String subString = mensaje.substring(0, 5);

		// se crea un patron con la excepcion qu busca algun numero:
		Pattern patron = Pattern.compile("\\d+");
		Matcher matcher = patron.matcher(cadena);
		// si lo encuentra, se muestra por pantalla:
		if (matcher.find()) {
			System.out.println("El numero encontrado es: " + matcher.group());
		}

		// saco los resultados:
		System.out.println("La suma del numero " + num1 + ", y del numero " + num2 + " es: " + suma);
		System.out.println(mensaje + suma);
		System.out.println(mensajeCadena);

	}
}
