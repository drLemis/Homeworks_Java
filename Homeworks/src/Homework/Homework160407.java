package Homework;

public class Homework160407 {

	public static void main(String[] args) {
		
		int inputNum = Integer.parseInt(args[0]);
		
		System.out.println("�����: "+ inputNum + "   " + Integer.toBinaryString(inputNum));
		System.out.println("����: ");
		
		do {
			if (inputNum%2==0) {
				System.out.println("0");
			} else {
				System.out.println("1");
			}
			
			if (inputNum>0) {
				inputNum=inputNum >> 1;			
			} else if (inputNum<0) {
				inputNum=inputNum << 1;
			}
		
		} while (inputNum != 0);
		System.out.println("������!");
	}
}