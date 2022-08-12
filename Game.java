
import java.util.Scanner;
public class Game
{
	final String BLACK = "black";
	final String WHITE = "white";

	final static int BOARD_LENGTH = 8;

	final int ROW_location = 0;
	final int COL_location = 1;


	final int ROW_START_PLACE_I = 0;
	final int COL_START_PLACE_I = 0;

	final int ROW_START_PLACE_J = 0;
	final int COL_START_PLACE_J = 1;

	final int ROW_END_PLACE_I = 1;
	final int COL_END_PLACE_I = 0;

	final int ROW_END_PLACE_J = 1;
	final int COL_END_PLACE_J = 1;
	
	final int NUMBER_OF_INDEXES = 2;

	
	//Recive type of piece and translate it to indexes
	private int [] getLocatioFromType(Board board, String input)
	{
		int[] locations = new int[2];

		for (int i = 0; i < BOARD_LENGTH; i++) { 
			for (int j = 0; j < BOARD_LENGTH; j++) {
				if (board.getBoard()[i][j].getType().equals(input)){
					
					locations[ROW_location] = i;
					locations[COL_location] = j;
					
					return locations;

				}
			}
		}
		return null;
	}


	//gets the first input and return an array of the index of the spot that was chosen
	private int[][] input(String color, String opColor, Board board)
	{
		Scanner scan = new Scanner(System.in);
		int [][]arrayOfIndexes = new int [NUMBER_OF_INDEXES][NUMBER_OF_INDEXES];
		String [] moveOptions = null;
		String type;
		String input;
		
		System.out.println("Please enter your piece: ");
		input = scan.next();
		if (input.equals("done")) {
			return null;
		}
		
		boolean isThereAPiece = false;
		boolean canThePieceMove = false;
		
		int[] locations = getLocatioFromType(board, input);
		if (locations != null)
			isThereAPiece = true;
		
		int i = locations[ROW_location];
		int j = locations[COL_location];
			
		moveOptions = board.getBoard()[i][j].move(color, opColor, board, i, j);
		
		if (moveOptions != null)
			canThePieceMove = true;
		
		while(canThePieceMove == false && isThereAPiece == false) {
			System.out.println("wrong input, please try again: ");
			input = scan.next();
			if (input.equals("done")) {
				return null;
			}

			
			i = getLocatioFromType(board, input)[ROW_location];
			j = getLocatioFromType(board, input)[COL_location];
			moveOptions = board.getBoard()[i][j].move(color, opColor, board, i, j);
		}
		
		
		if(moveOptions == null)
			return null;
			
		arrayOfIndexes[ROW_START_PLACE_I][COL_START_PLACE_I] = i;
		arrayOfIndexes[ROW_START_PLACE_J][COL_START_PLACE_J] = j;
		
		
		boolean corectInput = false;	
		
		System.out.println("The available spots are: ");
		for (i = 0; i < moveOptions.length; i++) {
			if (moveOptions[i] != null) {
				System.out.print(moveOptions[i] + " ");
			}

		}
		
		System.out.println("please choose one of them: ");
		input = scan.next();
		for (i = 0; i <BOARD_LENGTH; i++) {
			for (j = 0; j <BOARD_LENGTH; j++) {
				if (input.equals(board.getBoard()[i][j].getLocation()))  {
					for (int j2 = 0; j2 < moveOptions.length; j2++) {
						if (board.getBoard()[i][j].getLocation().equals(moveOptions[j2])) {
							corectInput = true;
							arrayOfIndexes[ROW_END_PLACE_I][COL_END_PLACE_I] = i;
							arrayOfIndexes[ROW_END_PLACE_J][COL_END_PLACE_J] = j;
						}
					}
				}
			}
		}
		while (corectInput == false) {
			System.out.println("wrong input, please try again: ");
			input = scan.next();
			for (i = 0; i < BOARD_LENGTH; i++) {
				for (j = 0; j < BOARD_LENGTH; j++) {
					if (input.equals(board.getBoard()[i][j].getLocation())) {
						for (int j2 = 0; j2 < moveOptions.length; j2++) {
							if (board.getBoard()[i][j].getLocation().equals(moveOptions[j2])) {
								corectInput = true;
								arrayOfIndexes[ROW_END_PLACE_I][COL_END_PLACE_I] = i;
								arrayOfIndexes[ROW_END_PLACE_J][COL_END_PLACE_J] = j;
							}
						}
					}
				}
			}
		}
		
		
		return arrayOfIndexes;
			
		
	}
	//the main loop of the game, asks from the user for inputs, the game is over when "done" is the input. 
	public String gameLoop( Board board) {
		int [][] arrayForChange = new int [NUMBER_OF_INDEXES][NUMBER_OF_INDEXES];
		System.out.print(board);
		System.out.println("it's white to start:");
		arrayForChange = input(WHITE, BLACK, board);
		if (arrayForChange == null)
			return "Game Over!\nHave a nice day!";

		board.setBoard(arrayForChange);



		while (arrayForChange != null) {
			System.out.print(board);			
			System.out.println("it's black turn: ");
			arrayForChange = input(BLACK, WHITE, board);

			if (arrayForChange == null)
				return "Game Over!\nHave a nice day!";

			board.setBoard(arrayForChange);


			System.out.print(board);
			System.out.println("it's white turn: ");
			arrayForChange = input(WHITE, BLACK, board);
			if (arrayForChange == null)
				return "Game Over!\nHave a nice day!";

			board.setBoard(arrayForChange);



		}
		return "Game Over!\nHave a nice day!";
	}




}