package com.Game.HandCricket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class HandCricket {
	
	public static int chooseNumber() {
		int[] arr = {1, 2, 3, 4, 5, 6};
		Random r = new Random();
		int randomNumber = r.nextInt(arr.length);
		return arr[randomNumber];
	}
	
	public static int check_input_lessthan_6() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("CAUTION: INPUT ERROR!!!!!");
		System.out.println("Choose a number b/w 1-6: ");
		int toss_user_number = Integer.parseInt(br.readLine());
		if(toss_user_number <= 6 && toss_user_number > 0) {
			return toss_user_number;
		}
		return check_input_lessthan_6();
	}
	
	public static long batting (String player, long target) throws IOException {
		long score = 0;
		while(target > score) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Choose a number b/w 1-6: ");
			int user_choose = Integer.parseInt(br.readLine());
			
			while(user_choose > 6 || user_choose == 0) {
				user_choose = check_input_lessthan_6();
			}
			
			int comp_choose = chooseNumber();
			
			System.out.println("You have chosen "+user_choose+" and computer has chosen "+comp_choose);
			
			if(user_choose != comp_choose) {
				if(player == "user") {
					score += user_choose;
				}
				else {
					score += comp_choose;
				}
			}
			else {
				System.out.println(player+" OUT!!!");
				break;
			}
		}
		return score;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("--------------- Let the TOSS begins ---------------");
		System.out.println("Choose ODD or EVEN: ");
		String toss_user = br.readLine().toUpperCase();
		System.out.println("Choose a number b/w 1-6: ");
		int toss_user_number = Integer.parseInt(br.readLine());
		
		while(toss_user_number > 6 || toss_user_number == 0) {
			toss_user_number = check_input_lessthan_6();
		}
		
		String toss_comp = "";
		while (true){
			String[] arr = {"ODD", "EVEN"}; 
	        Random r = new Random(); 
	        int randomNumber = r.nextInt(arr.length); 
	        toss_comp  = arr[randomNumber];
	        
	        if(!toss_user.equals(toss_comp)) {
	        	break;
	        }
		}
		int toss_comp_number = chooseNumber();
		
		System.out.println();
		System.out.println("You chosen: "+toss_user);
		System.out.println("You chosen a number: "+toss_user_number);
		System.out.println("Computer chosen: "+toss_comp);
		System.out.println("Computer chosen a number: "+toss_comp_number);
		System.out.println();
		
		int toss_number = toss_user_number + toss_comp_number;
		
		String user_toss = "";
		String comp_toss = "";
		
		if((toss_number%2 == 0 && toss_user.equals("EVEN")) || (toss_number%2 !=0 && toss_user.equals("ODD"))) {
			System.out.println("You have won the toss, do you like to do BAT or BALL");
			System.out.println("Choose to BAT or BALL: ");
			user_toss = br.readLine().toUpperCase();
			if(user_toss == "BAT") {
				comp_toss = "BALL";
			}
			else {
				comp_toss = "BAT";
			}
		}
		else {
			String[] arr = {"BAT", "BALL"};
			Random r = new Random();
			int randomNumbers = r.nextInt(arr.length);
			comp_toss = arr[randomNumbers];
			
			if(comp_toss.equals("BAT")) {
				user_toss = "BALL";
			}
			else {
				user_toss = "BAT";
			}
			System.out.println("You have lost the toss and computer has chosen "+comp_toss+" so you will do "+user_toss);
		}
		System.out.println("------------------------------------------------------------------------------------------------------");
		
		long user_score = 0;
		long comp_score = 0;
		
		if(user_toss.equals("BAT") || comp_toss.equals("BALL")) {
			user_score = batting("user", 1000000);
			System.out.println("----------------------------------------------");
			System.out.println("Computer TARGET is "+(user_score+1));
			System.out.println("----------------------------------------------");
			comp_score = batting("comp", (user_score+1));
		}
		else {
			comp_score = batting("comp", 1000000);
			System.out.println("----------------------------------------------");
			System.out.println("Your TARGET is "+(comp_score+1));
			System.out.println("----------------------------------------------");
			user_score = batting("user", (comp_score+1));
		}
		
		if(user_score > comp_score) {
			System.out.println("User won the game!!!");
		}
		else if(user_score == comp_score) {
			System.out.println("Match TIED!!!");
		}
		else {
			System.out.println("Computer won the game!!!");
		}       	
	}
}