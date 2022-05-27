package com.comcast.functional.demo;

import com.comcast.functional.model.Meteo;

/**
 * @author rkasar422
 *
 */
public class FunctionDemo {
	/**
	 * @param args
	 */
	public static void main(String args[]) {

		Meteo meteo = new Meteo(10);
		MyFunction<Meteo, Integer> readCelsius = m -> m.getTemperature();
		MyFunction<Integer, Double> celciusToFahrenheit = t -> t * 9d / 5d + 32d;
		
		//we are still obeying chaining here
		MyFunction<Meteo, Double> readFahrenheit = readCelsius.andThen(celciusToFahrenheit);
	System.out.println("Meteo is Fahrenheit "+readFahrenheit.apply(meteo));
		
		//lets achieve composition modifying types
		// celciusToFahrenheit T=Integer, R=Double
		// readCelsius T=Integer, V=Meteo
		readFahrenheit=celciusToFahrenheit.compose(readCelsius);
		
		System.out.println("Meteo is Fahrenheit "+readFahrenheit.apply(meteo));

	}

}
