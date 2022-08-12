
public class Rook extends Piece {

	final int POSSIBLE_MOVES = 14;


	public Rook(String color, String type, String location) {
		super(color, type, location);
	}


	public String [] move (String color, String opColor, Board board, int line,int row) {
		Piece[][] gameBoard = board.getBoard();
		String [] arr = new String[POSSIBLE_MOVES];
		int count = 0;
		int x;
		int y;


		for (int endLine = line; endLine < BOARD_LENGTH; endLine++) {

			if (gameBoard[endLine][row].getColor() != color) {
				arr[count] = gameBoard[endLine][row].getLocation();
				count++;

			}
		}

		for (int endLine = line; endLine > 0; endLine--) {

			if (gameBoard[endLine][row].getColor() != color) {
				arr[count] = gameBoard[endLine][row].getLocation();
				count++;

			}

		}

		for (int endRow = row; endRow < BOARD_LENGTH; endRow++) {

			if (gameBoard[line][endRow].getColor() != color) {
				arr[count] = gameBoard[line][endRow].getLocation();
				count++;

			}
		}


		for (int endRow = line; endRow > 0; endRow--) {

			if (gameBoard[line][endRow].getColor() != color) {
				arr[count] = gameBoard[line][endRow].getLocation();
				count++;

			}
		}



		if (arr[0] == null) {
			return null;
		}
		return arr;
	}

}
