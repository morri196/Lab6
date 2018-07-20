package Lab6;

import java.util.Random;
import java.util.Scanner;

public class DiceRollerApp {
	public static void main(String [] args) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Welcome to Grand Circus Casino\n");
		int count = 1;
		String play;
		do {
			System.out.println("How many sides should each pair of die have?");//prompt the user for how many sides the dice has? 
			int sides = scnr.nextInt();
			int num1 = rollTheDice(sides);//from method rollTheDice which generates the random dice number from userinput sides
			int num2 = rollTheDice(sides);//same
			
			System.out.println("Roll " + count);
			count = count + 1;
			System.out.println("" + num1 + " " + num2);//print both numbers
			System.out.println(callSpecial(num1, num2));//print from method callSpecial whether they roll is craps, not special, boxcars, or snalke eyes
			System.out.println("Do you want to roll again? (y/n)");//prompt user to play again
			play = scnr.next();
			
		} while (play.equalsIgnoreCase("y"));//while String play equals y , play again
		
	}
	
	public static int rollTheDice(int numSides) {
		Random rand = new Random();//get 2 random numbers
		
		int randomside = rand.nextInt(numSides); //initialize randomSide from numSides pulled from main sides
		return randomside + 1;//this is needed to shift up a number by 1.
	}
	
	public static String callSpecial(int num1, int num2) {
		String specialString = "Not Special";//had to set string to number that do not fit conditions below.
	
		if (num1 == 1 && num2 == 1) {
			specialString = "Snake Eyes!";
		}	
		if (num1 == 6 && num2 == 6) {
			specialString = "Box Cars!";
		}	
		if (num1 + num2 == 7 || num1 + num2 == 11) {
			specialString = "Craps!";
		}	
		
		return specialString;
	}
}
