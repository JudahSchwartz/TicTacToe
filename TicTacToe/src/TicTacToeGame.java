import java.util.Scanner;

public class TicTacToeGame {
	private static boolean xTurn = true, gameOver = false;
	private static Scanner scanner = new Scanner(System.in);
	private static int turnsTaken = 0;// to check when all boxes are full.
	private static Board board = new Board();
	
	public static void main(String[] args)
	{
		char c;
		
		int[] location;
		board.display();
		do
		{
			location = getInput();
			if(xTurn)
				c = 'X';
			else
				c = 'O';
			if(board.addCharachter(location, c))//input validation
			{
				
				xTurn = !xTurn;
				turnsTaken++;
			}
			else
			{
				System.out.println("Location invalid. Try again.");
			}
			board.display();
			
		}while(!gameOver(c));
	}
	/**
	 * Will check whether or not the game has ended, either in a tie or in a win
	 * @return
	 */
	private static boolean gameOver(char c) {
		
		boolean winner = checkForWinner();
		if(winner)
		{
			System.out.println(c +" won the game.");
			return true;
		}
		
		
		 if(turnsTaken == 9)//will be true if game ends in a tie
		 {
			System.out.println("Tie Game"); 
		 }
		 return turnsTaken == 9;
		
	}
	/**
	 * Checks each turn whether or not that player won
	 * @param location the spot just inputed
	 * @return true if he won
	 */
	private static boolean checkForWinner() {
		for(int i = 0;i<3;i++)
		{
				
				if(board.setup(i, 0)!= '\u0000'&&board.setup(i,0) == board.setup(i,1)
						&&board.setup(i,0)==board.setup(i,2))
				{
					return true;
				}
				if(board.setup(0,i)!= '\u0000'&&
						board.setup(0,i) == board.setup(1,i)&&board.setup(0,i)==board.setup(2,i))

				{
					return true;
				}
		}
		if(board.setup(0, 0)!= '\u0000'&&board.setup(0, 0)==board.setup(1,1)
				&&board.setup(0,0)==board.setup(2,2))
		{
			return true;
		}
		if(board.setup(0, 2)!= '\u0000'&&board.setup(0, 2)==board.setup(1,1)
				&&board.setup(0,2)==board.setup(2,0))
		{
			return true;
		}
		return false;
		
		
	}
	/**
	 * Asks where the player wants to make his move
	 * @return an array of two numbers for the location 
	 */
	private static int[] getInput()
	{
		int loc[] = new int[2];
		System.out.println("Where would you like to choose?");
		String input = scanner.nextLine().toUpperCase();
		
		loc[0] = charToInt(input.charAt(0));
		loc[1] = Integer.parseInt(input.substring(1))-1;//pulls the second num stores as int
		return loc;
	}
	/**
	 * Translates the letter from the grid to a numerical value to be used for an array
	 * @param c character being converted
	 * @return a numerical value for the row 
	 */
	private static int charToInt(char c)
	{
		return c - 65;
		
	}
}
