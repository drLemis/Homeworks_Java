package Practise;

import java.util.Random;
import java.util.Scanner;



public class DipLie {
	
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_CLS = "\u001b[2J";
	public static final String ANSI_HOME = "\u001b[H";	
	
	
	

	static boolean[] leftTeam = new boolean[4];
	static boolean[] rightTeam = new boolean[4];
	static int amountOfTurns = 3;
	static int intReplace;
	static Scanner input;
	static boolean cheatcode;
	
	public static void main(String[] args) {
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
		
		System.out.println("You are the President of little republic, declared independence in 19XX, named Lorgia.");
		System.out.println("Your neighbour, little republic of Sorgia, also dissected from your mother Norgia.");
		System.out.println("Unfortunately, your republics peoples hates each other. Also you both have some nuclear weapons.");
		System.out.println("One day some of your ministers betrayed you - now they tell you a lie about Sorgia's activity.");
		System.out.println("You don't know, who is lying you, and who is not. Also some Sorgia's ministers tell them a lie.");
		System.out.println("Will they bomb you or they only want to live in peace? It's your choise.");
		System.out.println("-----");
		System.out.println("You have 3 turns to choose - do nothing or launch a prevent  nuclear rocket.");
		System.out.println("1-3 ministers on each side will tell an antipodal lie about what's happening.");
		
		Initialise();
		
	}

	public static void Initialise(){
		System.out.println("");
		System.out.println("(s)tart new game, e(x)it or get (h)elp?");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String turn;
		turn = input.next();
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();		
		switch (turn){
		case "x":
			System.exit(0);
		case "s":
			break;
		case "h":
			System.out.println("--------");
			System.out.println("PRESIDENT - can only wants war or peace, without changing of mind.");
			System.out.println("THEIR MINISTERS - will tell your ministers info about country. If president wants war - they will tell about that. But they can lie.");
			System.out.println("OUR MINISTERS - tell you info, what they got from their ministers. But also can lie to you.");
			System.out.println("REPLACING - you can put a new your minister,what can tell you info without lying. But if he got lie - he will tell lie.");
			System.out.println("LIE - president want war : their minister lie to you what he's not : your minister lie to you what he wants war. You got truth, but only because 2 lies.");
			System.out.println("--------");
			Initialise();
		case "146":
			cheatcode = true;
			break;
		default:
			System.out.println("Sorry?");
			Initialise();
		}
		
		
		Random random = new Random();
		
		leftTeam[0] = random.nextBoolean();
		int rannum;
		for (int i = 0; i < 2 ; i++){
			rannum = random.nextInt(3)+1;
			leftTeam[rannum] = !leftTeam[rannum];
			rannum = random.nextInt(3)+1;
			rightTeam[rannum] = !rightTeam[rannum];
		}
		if (cheatcode == true) {
		System.out.println("President want war:" + leftTeam[0]);
		System.out.println("");
		System.out.println("Their 1 lying: "+leftTeam[1]);
		System.out.println("Their 2 lying: "+leftTeam[2]);
		System.out.println("Their 3 lying: "+leftTeam[3]);
		System.out.println("Our 1 lying: "+rightTeam[1]);
		System.out.println("Our 1 lying: "+rightTeam[2]);
		System.out.println("Our 1 lying: "+rightTeam[3]);
		System.out.println("");
		}
		
		UpdateInterface(false, false);
	}
	
	public static void UpdateInterface(Boolean typeOfTurn, boolean replaced){
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
		if (amountOfTurns == 1) EndGame(false);
		Generate(typeOfTurn);
		
		if (typeOfTurn == true) amountOfTurns--;
		
		System.out.println("--------");	
		System.out.print(ANSI_BLUE + "ne(x)t turn"+ ANSI_RESET +", " + ANSI_PURPLE + "(l)aunch rockets" + ANSI_RESET);
		if (replaced == false) System.out.print(", " + ANSI_YELLOW + "(r)eplace minister" + ANSI_RESET);
		System.out.println("");
		System.out.println("You have " + amountOfTurns + " turns");
		if (replaced == true) System.out.println(intReplace +" minister was replaced and now tell only true.");
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		char turn;
		turn = input.findInLine(".").charAt(0);
		
		switch (turn){
		case 'x':
			UpdateInterface(true, replaced);
		case 'l':
			EndGame(true);
		case 'r':
			if (replaced == false) {
			System.out.println("Which minister should be replaced? (1-3)");
			@SuppressWarnings("resource")
			Scanner inpReplace = new Scanner(System.in);
			intReplace = inpReplace.nextInt();
			rightTeam[intReplace] = false;
			UpdateInterface(true, true);
			}
		default:
		}
		UpdateInterface(false, replaced);
	}
	
	public static void Generate(Boolean typeOfTurn) {
		
		for (int i = 1; i < leftTeam.length; i++) {
			if (leftTeam[i] != rightTeam[i]) System.out.println(Oppinion (i, true));
			else System.out.println(Oppinion (i, false));
		}
	}
	
	public static String Oppinion(int minister, boolean opp){
		switch (minister){
		case 1:
			if (leftTeam[0] == true && opp == false) return ANSI_RED + "Minister of Economy says: Their President start making war bonds." + ANSI_RESET;
			else if (leftTeam[0] == true && opp == true) return ANSI_GREEN + "Minister of Economy says: Their President increased tax spending on schools and medicine." + ANSI_RESET;
			else if (leftTeam[0] == false && opp == true) return ANSI_RED +  "Minister of Economy says: Their President start making war bonds." + ANSI_RESET;
			else if (leftTeam[0] == false && opp == false) return ANSI_GREEN + "Minister of Economy says: Their President increased tax spending on schools and medicine." + ANSI_RESET;
		case 2:
			if (leftTeam[0] == true && opp == false) return ANSI_RED + "Minister of Culture says: Their President moved a lot of arts in unknown secured places." + ANSI_RESET;
			else if (leftTeam[0] == true && opp == true) return ANSI_GREEN + "Minister of Culture says: Their President will arrive on gallery meeting this year with new masterpieces." + ANSI_RESET;
			else if (leftTeam[0] == false && opp == true) return ANSI_RED + "Minister of Culture says: Their President moved a lot of arts in unknown secured places." + ANSI_RESET;
			else if (leftTeam[0] == false && opp == false) return ANSI_GREEN + "Minister of Culture says: Their President will arrive on gallery meeting this yearwith new masterpieces." + ANSI_RESET;
		case 3:
			if (leftTeam[0] == true && opp == false) return ANSI_RED + "Minister of Agrary says: Their President replaced a lot of field workers with military guards." + ANSI_RESET;
			else if (leftTeam[0] == true && opp == true)  return ANSI_GREEN + "Minister of Agrary says: Their President want to make a new world record of harvests." + ANSI_RESET;
			else if (leftTeam[0] == false && opp == true) return ANSI_RED + "Minister of Agrary says: Their President replaced a lot of field workers with military guards." + ANSI_RESET;
			else if (leftTeam[0] == false && opp == false)  return ANSI_GREEN + "Minister of Agrary says: Their President want to make a new world record of harvests." + ANSI_RESET;
		default:
			
		}
		return null;
	}
	
	public static void EndGame(boolean nuclear){
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
		System.out.println("========");
		if (nuclear == true && leftTeam[0] == true) System.out.println(ANSI_GREEN + "You won with preventive strike! Take that, bastards!" + ANSI_RESET);
		if (nuclear == true && leftTeam[0] == false) System.out.println(ANSI_RED + "You started a nuclear war with piece country! What a shame!" + ANSI_RESET);
		if (nuclear == false && leftTeam[0] == true) System.out.println(ANSI_RED + "Your country was destroyed! You was too bad in guessing!" + ANSI_RESET);
		if (nuclear == false && leftTeam[0] == false) System.out.println(ANSI_GREEN + "You stayed in peace! Long live the President!" + ANSI_RESET);
		System.exit(0);
	}
	
}