package lets;

import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// System object
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		//Game variables
		String[] enemies = {"Skeleton" , "Zombie" , "Assassin"};
		int maxEnemyHealth = 75;
		int enemeyAttackDamage = 25;
		int enemyKilled = 0;
		
		//player variables
		int health = 100;
		int attackDamage = 30;
		int numHealthPots = 3;
		int HealthPotionHealAmount = 30;
		int healthPotionDropChance = 40 ;// Percentage
		
		boolean running = true;
		
		System.out.println("Welcome to the Dungeon");
		
		GAME:
		while(running){
			System.out.println("---------------------------------------------");
			
			int enemyHealth = rand.nextInt(maxEnemyHealth);
			String enemy = enemies[rand.nextInt(enemies.length)];
			System.out.println("\t# "+enemy+"has appeared! #\n");
			
			while(enemyHealth > 0){
				System.out.println("\tYour HP: "+health);
				System.out.println("\t"+enemy+"'s HP: "+enemyHealth);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink health potion");
				System.out.println("\t3. Run!");
				
				String input = sc.nextLine();
				if(input.equals("1")){
					int damageDelt = rand.nextInt(attackDamage);
					int damageTaken = rand.nextInt(enemeyAttackDamage);
					
					health -= damageTaken;
					enemyHealth -= damageDelt;
					
					System.out.println("\t>You stroke the "+enemy+" for "+damageDelt+" damage.");
					System.out.println("\t>You recieved "+damageDelt+" in retaliation!");
					
						if(health < 1){
							System.out.println("\t> You have taken too much damage you're too weak to go on!");
							break;
						}
				}
				else if(input.equals("2")){
					
					if(numHealthPots > 0){
						if(health + HealthPotionHealAmount >100)
							System.out.println("you can't exceed the maximum health amount please try another action.");
						else{
						health += HealthPotionHealAmount;
						numHealthPots--;
						System.out.println("\t> You drunk a health potion, healing yourself for "+HealthPotionHealAmount
								+".\n\t> You now have "+health+" HP."
								+"\n\t> you have "+numHealthPots+" health potions left.\n");
						
					}}
					else System.out.println("\t> You have no hhealth potion left! Defeat enemies for a chance to drop one");
				}
				else if(input.equals("3")){
						System.out.println("\t> You run away from "+enemy+"!");
						continue GAME;
				}
				else {
					System.out.println("\t> Invalid command!");
				}
			  }
			
			  if(health < 1){
				  System.out.println("You limped out of the Dungeon, weak from battle");break;
			  }
			  
			  System.out.println("---------------------------------------------");
			  enemyKilled++;
			  System.out.println("#"+enemy+" was defeated! #");
			  System.out.println("You killed "+enemyKilled+" enemy(s)");
			  System.out.println("You have "+health+" HP!");
			  if(rand.nextInt(100) < healthPotionDropChance){
				  numHealthPots++;
				  System.out.println("# The "+enemy+" has droped a health potion!");
				  System.out.println("# You have now "+numHealthPots+" health potion(s)");
				  
			  }
			  System.out.println("---------------------------------------------");
			  System.out.println("What would you like to do now?");
			  System.out.println("1. Continue fighting!");
			  System.out.println("2. Exit dungeon");
			  
			  String input = sc.nextLine();
			  	  
			      while(!input.equals("2") && !input.equals("1")){
				  System.out.println("Invalid command");
				  input = sc.nextLine();
			      }
			  if(input.equals("1"))
				  System.out.println("you continue your adventure");			  
			  else if(input.equals("2")){
				  System.out.println("You exit the dungeon, successful from your adventures!");
		break;} 
			  }
		System.out.println("#######################");
		System.out.println("# THANKS FOR PLAYING! #");
		System.out.println("#######################");
	}

}
