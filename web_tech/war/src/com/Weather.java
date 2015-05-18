package com;
import com.Cars;

public class Weather {
	public static double windSpeed = 5; // ì/ñ
	public static double rain = 0.5;
	
	public static double windEffect() {
		double effect = Cars.windEff * windSpeed;
		return effect;
	}
	
	public static double rainEffect() {
		double effect = Cars.rainEff * rain;
		return effect;
	}
	
}
