package com;
import com.Track;
import com.Weather;

public class Cars {
	public static int speedStraight = 200;
	public static double control = 0.4;
	public static double windEff = 0.2;
	public static double rainEff = 0.5;
	
	public static double speedTurn = speedStraight * control ;
	public static double timeTurn = Track.lenTurns / speedTurn;
	
	public static double resultTime() {
		double time;
		double wind = Weather.windEffect();
		double rain = Weather.rainEffect();
		time = Track.len / speedStraight + Track.lenTurns / speedTurn;
		return time;
	}
}
