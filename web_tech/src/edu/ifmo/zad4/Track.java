package edu.ifmo.zad4;

public class Track {
	public String trackId;
	public String trackName;
	public String src;
	public double lenTrack;  // общая длина трека в км
	public int turns;
	public double lenTurn; // средняя длина поворота в метрах
	
	public double lenTurns; // длина поворотов в км
	public double len; // длина прямой
	
	public Cars setTimeTurn(Cars car){
		lenTurns = turns * lenTurn / 1000;
		len = lenTrack - lenTurns;
		car.speedTurn = car.speedStraight * car.control;
		car.timeTurn = lenTurns / car.speedTurn;
		return car;
	}
}
