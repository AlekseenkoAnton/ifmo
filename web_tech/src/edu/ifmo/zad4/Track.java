package edu.ifmo.zad4;

public class Track {
	public String trackId;
	public String trackName;
	public String src;
	public double lenTrack;  // ����� ����� ����� � ��
	public int turns;
	public double lenTurn; // ������� ����� �������� � ������
	
	public double lenTurns; // ����� ��������� � ��
	public double len; // ����� ������
	
	public Cars setTimeTurn(Cars car){
		lenTurns = turns * lenTurn / 1000;
		len = lenTrack - lenTurns;
		car.speedTurn = car.speedStraight * car.control;
		car.timeTurn = lenTurns / car.speedTurn;
		return car;
	}
}
