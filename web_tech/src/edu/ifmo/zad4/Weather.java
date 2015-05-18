package edu.ifmo.zad4;
import edu.ifmo.zad4.Cars;

public class Weather {
	public double windSpeed; // ì/ñ
	public double rain; // 0 -- 0.3

	
	public Cars setWeatherToCar (Cars car) {
		car.rainEff = car.rainEff * rain;
		car.rainEff = 1 - car.rainEff;
		car.windEff = car.windEff * windSpeed;
		car.windEff = 1 + car.windEff/10;
		return car;
	}
	
}
