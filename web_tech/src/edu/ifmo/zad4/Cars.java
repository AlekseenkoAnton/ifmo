package edu.ifmo.zad4;
import java.math.BigDecimal;

import edu.ifmo.zad4.Track;

public class Cars {
	public String model;
	public String carId;
	public double speedStraight;
	public double control;
	public double windEff; // ���������������� � �����. ������ - �����
	public double rainEff; // �������������� � �����. ������ - �����
	
	public double speedTurn; // = speedStraight * control ;
	public double timeTurn;
	
	public double resultTime(Track trk) {
		double time;
		speedStraight = speedStraight * rainEff;
		time = trk.len / speedStraight + trk.lenTurns / speedTurn;
		time = time * windEff; // ������� �����
		time = time * 3600; // � �������
		BigDecimal bd = new BigDecimal(time);
		bd = bd.setScale(2, BigDecimal.ROUND_UP);
		time = bd.doubleValue();
		return time;
	}
}
//you big ��� ������