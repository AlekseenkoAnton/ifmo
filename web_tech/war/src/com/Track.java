package com;

public class Track {
	
	public static double lenTrack = 4;  // общая длина трека в км
	public static int turns = 9;
	//public double cover = 0.9;
	public static double lenTurn = 150; // средняя длина поворота в метрах
	
	public static double lenTurns = turns * lenTurn / 1000; // длина поворотов в км
	public static double len = lenTrack - lenTurns; // длина прямой
}
