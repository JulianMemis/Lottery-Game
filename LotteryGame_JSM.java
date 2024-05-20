import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Julian Memis
 * Purpose: The LotteryGame class simulates a lottery game.
 * This is done by asking the user for the amount of digits 
 * in the lottery and then asking for what number the user 
 * wants for each lottery digit. The users selected lottery number 
 * is then compared to the randomly calculated lottery number.
 * Rewards are outputted depending on how many digits match.
 */
public class LotteryGame_JSM
{
	public static void main(String[] args)
	{
		//Variables:
		int amount; //Number of selected lottery digits
		int matches; //Number of lottery digit matches
		int [] user; //User selected lottery numbers
		int [] loto; //Randomly selected lottery numbers
		
		//Create scanner to read from the keyboard
		Scanner kb = new Scanner(System.in);
			
		//Ask user for how many values in lottery
		System.out.print("Welcome to the Lottery game!");
		System.out.print("\n\nHow many numbers are in the lottery? ");
		
		//Use helper methods to get the user's choices
		amount = kb.nextInt();
		user = etUserPicks(kb, amount);

		//Use helper method to get random lottery numbers
		loto = generateRandomLottery(amount);
		
		//Display the users choices
		System.out.print("\nYou picked:\n");
		display(user);
		
		//Display the lottery values
		System.out.print("\n\nThe lottery values are:\n");
		display(loto);
		
		//Report how many values matched and what is won.
		matches = countMatches(loto, user);
		System.out.print("\n\nYou matched " + matches + " of " + amount + "!");
		
		//Check + Print Earnings:
		if (matches == 0)
		{
			System.out.print("\nYou do not win any money.");
		}
		
		else if (matches == amount)
		{
			System.out.printf("\nYou win $%,d!", (matches * 10000));
		}
		
		else
		{
			System.out.printf("\nYou win $%,d!", 1000);
		}
		
		//Close Scanner:
		kb.close();
	}
	
	
	//Methods:
	
	/**
	 * Generates random lottery number of the user selected size
	 * @param size
	 * @return lottery
	 */
	public static int[] generateRandomLottery(int size)
	{
		int [] lottery = new int[size];
		for(int i = 0; i < size; i++)
		{
			Random rand = new Random();
			lottery[i] = rand.nextInt(10);
		}
		
		return lottery;
	}
	
	/**
	* Asks the user for lottery numbers until they selected the chosen amount.
	*
	* @param kb A scanner
	* @param size The number of integers to get from the user
	* @return An array of integers containing only the numbers 0-9.
	*/
	public static int[] etUserPicks(Scanner kb, int size)
	{
		System.out.println("Enter only integers between 0-9.");//Ask for int
		int[] userPicks = new int [size]; //Initialize int array
		for (int i = 0; i < size; i++)
		{	
			do
			{
				System.out.printf("Enter #" + (i+1) + ": ");
				userPicks[i] = kb.nextInt(); //Get user int	
				if (!(0 <= userPicks[i] && userPicks[i] <= 9)) //Check if int between 0-9
					System.out.println("Please re-enter - Your choice must be 0-9."); //Re-enter if not
			} while(!(0 <= userPicks[i] && userPicks[i] <= 9)); //Add to array until filled
			
		}
		
		//Return the user's choices
		return userPicks;
	}
	
	/**
	* Count how many values match between the
	* lottery array and the user choices.
	* @param lottoNums An array of lottery values
	* @param userNums An array of user's values
	* @return how many match
	*
	* Example: countMatches([1,2,3,4], [0,2,3,9]) returns 2
	*/
	public static int countMatches(int[] lottoNums, int[] userNums)
	{
		int numberThatMatch = 0; //Holds how many values are the same
		for (int i = 0; i < lottoNums.length; i++)
		{	
			if(lottoNums[i] == userNums[i]) //Check if lottery/user values match
			{
				numberThatMatch++; //Increment match counter
			}
		}
		
		return numberThatMatch;
	}
	
	/**
	 * Displays the array of selected numbers with 
	 * commas separating each integer.
	 * @param array
	 */
	public static void display(int [] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			if(i == array.length-1)
			{
				System.out.print(array[i]);
			}
			
			else 
				System.out.print(array[i] + ", ");
		}
	}
}