package Practise;

import java.util.Random;
import java.util.Scanner;

public class BombNavigation {
	
	public static void main(String[] args) {
		
		int amount;
		int priors;
		float radius;
		float xsize;
		float ysize;
		double distance;
		Random random = new Random();
		
		Scanner input = new Scanner(System.in);
		System.out.println("X size (km,dm): ");
		xsize = input.nextFloat(); // getting an integer
		System.out.println("Y size (km,dm): ");
		ysize = input.nextFloat(); // getting an integer
		System.out.println("Amount of targets: ");
		amount = input.nextInt(); // getting an integer
		System.out.println("Radius of a bomb (km,dm): ");
		radius = input.nextFloat(); // getting an integer
		System.out.println("Amount of priorities: ");
		priors = input.nextInt(); // getting an integer
		System.out.println("--------");
		
		input.close();
		
		float[][] target = new float[amount][3];
		
		//generate targets coordinates list
		for (int i = 0; i < target.length; i++){
	        target[i][1] = random.nextFloat()*xsize;
			target[i][2] = random.nextFloat()*ysize;
		}
		
		//get a distances between all targets
		for (int i = 0; i < target.length; i++){
			for (int j = 0; j < target.length; j++){
				distance = Math.sqrt((target[i][1]-target[j][1])*(target[i][1]-target[j][1]) + (target[i][2]-target[j][2])*(target[i][2]-target[j][2]));
				if (distance < radius) {
					target[i][0]++;
				}
			}
		}
			
		//bubble sort for priority 
        for (int i = 0; i < target.length - 1; i++) {
            for (int j = 0; j < target.length - i - 1; j++) {
                if (target[j][0] < target[j + 1][0]) {
                    float t0 = target[j][0];
                    float t1 = target[j][1];
                    float t2 = target[j][2];
                    target[j][0] = target[j + 1][0];
                    target[j][1] = target[j + 1][1];
                    target[j][2] = target[j + 1][2];
                    target[j + 1][0] = t0;
                    target[j + 1][1] = t1;
                    target[j + 1][2] = t2;
               	}
            }
        }
        
        //output
		System.out.println("PRIOR. TARGETS");
		if (priors > target.length) priors = target.length;
		for (int i = 0; i < priors; i++) {
			System.out.println("X:"+ target[i][1] + " Y:" + target[i][2] + " P:" +(int)target[i][0]);
		}

	}

}