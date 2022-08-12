
public class Pawn extends Piece
{
	
	final int POSSIBLE_MOVES = 4;


	public Pawn(String color, String type, String location) {
		super(color, type, location);
	}
	
	public String [] move(String color,String opColor, Board board, int line,int row) {//this function gets array, line and row and return array with the possible moves for pawn
		int possibleRowOne = row + 1;
		int possibleRowTwo = row - 1;
		int possibleLine = line - 1;
		String PossibleLocations[] = new String[POSSIBLE_MOVES];
		Piece[][] gameBoard = board.getBoard();
		
		int count = 0;
		if (color.equals("white")) {
			if (possibleLine >= EDGE_OF_BOARD_LOW) {
				if (gameBoard[possibleLine][row].getColor() == "empty") {
					PossibleLocations[count] = gameBoard[possibleLine][row].getLocation();
					count++;
					if (line == 6) {
						possibleLine -= 1;
						if (gameBoard[possibleLine][row].getColor() == "empty") {
							PossibleLocations[count] = gameBoard[possibleLine][row].getLocation();
							count++;
							possibleLine = line - 1;
						}
					}
				}
			}
			possibleLine = line - 1;
			if (possibleRowOne <= EDGE_OF_BOARD_HIGHT && possibleLine >= EDGE_OF_BOARD_LOW) {
				if (gameBoard[possibleLine][possibleRowOne].getColor() == opColor) {
					PossibleLocations[count] = gameBoard[possibleLine][possibleRowOne].getLocation();
					count++;
					possibleLine = line - 1;

				}
			}
			if (possibleRowTwo >= EDGE_OF_BOARD_LOW && possibleLine >= EDGE_OF_BOARD_LOW) {
				if (gameBoard[possibleLine][possibleRowTwo].getColor() == opColor) {
					PossibleLocations[count] = gameBoard[possibleLine][possibleRowTwo].getLocation();
					count++;			}
			}
		}
		else if (color.equals("black")) {
			possibleLine = line + 1;
			if (possibleLine <= EDGE_OF_BOARD_HIGHT) {
				if (gameBoard[possibleLine][row].getColor() == "empty") {
					PossibleLocations[count] = gameBoard[possibleLine][row].getLocation();
					count++;
					if (line == 1) {
						possibleLine += 1;
						if (gameBoard[possibleLine][row].getColor() == "empty") {
							PossibleLocations[count] = gameBoard[possibleLine][row].getLocation();
							count++;
							possibleLine = line + 1;
						}
					}
				}
			}
			possibleLine = line + 1;
			if (possibleRowOne <= EDGE_OF_BOARD_HIGHT && possibleLine <= EDGE_OF_BOARD_HIGHT) {
				if (gameBoard[possibleLine][possibleRowOne].getColor() == opColor) {
					PossibleLocations[count] = gameBoard[possibleLine][possibleRowOne].getLocation();
					count++;
					possibleLine = line + 1;

				}
			}
			if (possibleRowTwo >= EDGE_OF_BOARD_LOW && possibleLine <= EDGE_OF_BOARD_HIGHT) {
				if (gameBoard[possibleLine][possibleRowTwo].getColor() == opColor) {
					PossibleLocations[count] = gameBoard[possibleLine][possibleRowTwo].getLocation();
					count++;
				}
			}
		}
		if (PossibleLocations[0] == null) {
			return null;
		}
		return PossibleLocations;
	}

}
