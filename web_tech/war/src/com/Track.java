package com;

public class Track {
	
	public static double lenTrack = 4;  // ����� ����� ����� � ��
	public static int turns = 9;
	//public double cover = 0.9;
	public static double lenTurn = 150; // ������� ����� �������� � ������
	
	public static double lenTurns = turns * lenTurn / 1000; // ����� ��������� � ��
	public static double len = lenTrack - lenTurns; // ����� ������
}
