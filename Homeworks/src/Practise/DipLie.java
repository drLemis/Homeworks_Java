package Practise;

import java.awt.print.Printable;
import java.util.Random;

public class DipLie {

	public static void main(String[] args) {
		
		
		//присваивается правда-ложь при начале
		//функция обрабатывает поступающую инфу по присвоенному
		
		boolean[] leftTeam = new boolean[4];
		boolean[] rightTeam = new boolean[4];
		int lieGen;
		Random random = new Random();
		
		for (int i = 0; i < 4 ; i++){
			lieGen = random.nextInt(4);
			leftTeam[lieGen] = true;
			lieGen = random.nextInt(4);
			rightTeam[lieGen] = true;
		}
		
		System.out.println("P: " + leftTeam[0] + " | " + rightTeam[0]);
		System.out.println("1: " + leftTeam[1] + " | " + rightTeam[1]);
		System.out.println("2: " + leftTeam[2] + " | " + rightTeam[2]);
		System.out.println("3: " + leftTeam[3] + " | " + rightTeam[3]);
		
		System.out.println("-----");
		//generate info about WAR
		//hello, indian code
		
		boolean speech;
		for (int i = 1; i < 4; i++) {
			speech = leftTeam[0];
			if (leftTeam[i] == true) speech =! speech;
			if (rightTeam[i] == true) speech =! speech;
			System.out.println(i + ": " + speech);
		}
		
		
		
		
		
		
		
		
	}

}
