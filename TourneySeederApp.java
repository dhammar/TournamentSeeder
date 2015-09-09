import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TourneySeederApp {

	public static void main(String[] args) {
		System.out
				.println("\n\t\t------------------\n\tWelcome to Dave's tourney seeder.\n\t\t------------------");
		Scanner input = new Scanner(System.in);
		System.out
				.println("\nHow many contestants are there? Enter non-negative, non-zero integers only.");
		int contestantCount = input.nextInt();
		System.out.println("Were preliminary games played? y/n");
		String prelimResponse = input.next();
		boolean prelims = prelimResponse.trim().equalsIgnoreCase("y");
		ArrayList<Contestant> contestants = new ArrayList<>();

		for (int i = 0; i < contestantCount; i++) {
			System.out.println("\nPlease enter contestant "+(i+1)+"'s name: ");
			String name = input.next();
			if (prelims) {
				System.out
						.println("Please enter contestant "+(i+1)+"'s preliminary win count: ");
				int wins = input.nextInt();
				System.out
						.println("Please enter contestant "+(i+1)+"'s preliminary loss count: ");
				int losses = input.nextInt();
				contestants.add(new Contestant(name, wins, losses));
			} else {
				contestants.add(new Contestant(name));
			}
		}
		
		contestants = sortBySeed(contestants);
		input.close();
		for(int i = 0 ; i < contestantCount; i++){
			System.out.println((i+1) + ": " + contestants.get(i).getName());
		}
	}
	
	public static ArrayList<Contestant> sortBySeed(ArrayList<Contestant> contestants){
		contestants = randomize(contestants);
		if(contestants.get(0).getWins() == -1){
			return contestants;
		}
		contestants.sort(null);
		return contestants;
	}
	
	public static ArrayList<Contestant> randomize(ArrayList<Contestant> arr){
		ArrayList<Contestant> newArray = new ArrayList<Contestant>();
		Random rand = new Random();
		int oldSize = arr.size();
		while(newArray.size() != oldSize){
			int choice = rand.nextInt(arr.size());
			newArray.add(arr.remove(choice));
		}
		return newArray;
	}
	
	

}
