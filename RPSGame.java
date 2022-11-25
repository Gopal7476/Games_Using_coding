package com.Game.RockPaperScissors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class RPSGame {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("How many times do you want to play: ");
		int No_Of_Times = Integer.parseInt(br.readLine());
		
		int user_score = 0;
		int comp_score = 0;
		
		while (No_Of_Times --> 0) {
			
			System.out.println("Enter your choice R/P/S: ");
			String user = br.readLine().toUpperCase();
			char user_choice = user.charAt(0);
			
			char[] arr={'R', 'P', 'S'}; 
	        Random r=new Random(); 
	        int randomNumber=r.nextInt(arr.length); 
	        char comp_choice = arr[randomNumber];
	        
	        if((user_choice == 'R' && comp_choice == 'S') || (user_choice == 'P' && comp_choice == 'R') || (user_choice == 'S' && comp_choice == 'P')) {
	        	user_score++;
	        	System.out.println("-----------------------------------------------------------------");
	        	System.out.println("You chosen "+user_choice+" and Computer chosen "+comp_choice);
	        	System.out.println("You won!!");
	        	System.out.println("Your score is "+user_score+" and Computer score is "+comp_score);
	        	System.out.println("-----------------------------------------------------------------");
	        }
	        else if((user_choice == 'R' && comp_choice == 'P') || (user_choice == 'P' && comp_choice == 'S') || (user_choice == 'S' && comp_choice == 'R')) {
	        	comp_score++;
	        	System.out.println("-----------------------------------------------------------------");
	        	System.out.println("You chosen "+user_choice+" and Computer chosen "+comp_choice);
	        	System.out.println("Computer won!!");
	        	System.out.println("Your score is "+user_score+" and Computer score is "+comp_score);
	        	System.out.println("-----------------------------------------------------------------");
	        }
	        else {
	        	System.out.println("-----------------------------------------------------------------");
	        	System.out.println("You chosen "+user_choice+" and Computer chosen "+comp_choice);
	        	System.out.println("TIED!!");
	        	System.out.println("Your score is "+user_score+" and Computer score is "+comp_score);
	        	System.out.println("-----------------------------------------------------------------");
	        }
	        
		}
		
		if(user_score > comp_score) {
			System.out.println("User has won the game!!!");
		}
		else if(user_score < comp_score) {
			System.out.println("Computer has won the game!!!");
		}
		else {
			System.out.println("Game TIED!!!");
		}

	}

}
