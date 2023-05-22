import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Random rng = new Random();
		
		Map<Integer, String> rpsDict = new HashMap<>();
		rpsDict.put(1, "Rock");
		rpsDict.put(2, "Paper");
		rpsDict.put(3, "Scissors");
		
		int roundNums;
		
		while(true) {
		
			System.out.println("How many round would you like to play? (1 to 10 inclusive)");
			if(!sc.hasNextInt()) {
				System.out.println("Invalid choice!");
				return;
			}
			
			roundNums = sc.nextInt();
			
			if(roundNums < 1 || roundNums > 10) {
				System.out.println("Invalid choice!");
				return;
			}
		
			int playerWins = 0;
			int computerWins = 0;
			int tieNum = 0;
			
			for(int i = 0; i < roundNums; i++) {
				System.out.println("Pick your weapon!");
				System.out.println("1: Rock\n2: Paper\n3: Scissors");
				
				int playerChoice;
				
				while(true) {
					if(sc.hasNextInt()) {
						
						playerChoice = sc.nextInt();
						
						if(playerChoice < 1 || playerChoice > 3) {
							System.out.println("Only choose 1, 2, or 3");
							continue;
						}
						break;
					}else {
						System.out.println("Only choose 1, 2, or 3");
						sc.next();
					}
				}
				
				int computerChoice = rng.nextInt(3)+1;
				
				if(playerChoice == computerChoice) {
					System.out.println("It's a tie, you both played " + rpsDict.get(computerChoice) + "!");
					tieNum++;
				}else if(playerChoice == 1 && computerChoice == 2) {
					System.out.println("Computer played " + rpsDict.get(computerChoice) + ", Computer wins!");
					computerWins++;
				}else if (playerChoice == 1 && computerChoice == 3) {
					System.out.println("Computer played " + rpsDict.get(computerChoice) + ", you win!");
					playerWins++;
				}else if (playerChoice == 2 && computerChoice == 1) {
					System.out.println("Computer played " + rpsDict.get(computerChoice) + ", you win!");
					playerWins++;
				}else if (playerChoice == 2 && computerChoice == 3) {
					System.out.println("Computer played " + rpsDict.get(computerChoice) + ", Computer wins!");
					computerWins++;
				}
				
			}
			
			System.out.println("----------------------------------");
			System.out.println("Player wins: " + playerWins);
			System.out.println("Computer wins: " + computerWins);
			System.out.println("Ties: " + tieNum + "\n");
			
			if(playerWins == computerWins) {
				System.out.println("It's a tie overall!");
			}else if(playerWins > computerWins){
				System.out.println("You win overall!");
			}else if(playerWins < computerWins){
				System.out.println("Computer wins overall, better luck next time!");
			}
			
			sc.nextLine();
			System.out.println("Would you like to play again? (yes or no)");
			
			String response = sc.nextLine();
			while(!response.equals("yes") && !response.equals("no")) {
				System.out.println("Please only respond with yes or no");
				response = sc.nextLine();
			}
			
			if(response.equals("no")) {
				System.out.println("Thanks for playing!");
				break;
			}
		}
	
	}
}



