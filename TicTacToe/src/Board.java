
public class Board 
{
	private char[][] setup = new char[3][3];
	public char setup(int a, int b)
	{
		return setup[a][b];
	}
	public void display()
	{
		System.out.println("   1    2    3");
		for(int i = 0; i < 3; i++)
		{
			System.out.print((char)(i+65));
			for(char c: setup[i])
			{
				if(c == '\u0000')//for some reason, boxes were showing up on my screen
					c = ' ';
				System.out.print("| " + c + " |");
			}
			System.out.println();//to skip a line
		}
	}
	/**
	 * Adds the input onto the board
	 * @param location the place character is being added
	 * @param c whether an x or an o should be added
	 * @return true if done successfully, false if place is taken
	 */
	public boolean addCharachter(int[] location, char c)
	{
		if(location[0]!=-1&&(location[1]<3&&location[1]>-1)//checks if on the grid
				&&setup[location[0]][location[1]] == '\u0000')//checks if spot isn't taken
		{
			setup[location[0]][location[1]] = c;
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
