
public class Bishop extends Piece
{
	
	final int POSSIBLE_MOVES = 25;

	
	final String EMPTY = "empty";

	public Bishop(String color, String type, String location) {
		super(color, type, location);
	}

	public String [] move(String color, String opColor, Board board, int line,int row) {//this function gets array, line and row and return array with the possible moves for bishop

		Piece[][] gameBoard = board.getBoard();
		String [] arr = new String[25];
		int count = 0;
		int i1 = line + 1;
		int i2 = row + 1;
		boolean bool = false;
		while (i1 <= EDGE_OF_BOARD_HIGHT && i2 <= EDGE_OF_BOARD_HIGHT && gameBoard[i1][i2].getColor() != color  && bool == false) {
			if (gameBoard[i1][i2].getColor() == opColor) {
				arr[count] = gameBoard[i1][i2].getLocation();
				count++;
				bool = true;
			}
			else if (gameBoard[i1][i2].getColor() == EMPTY) {
				System.out.print(gameBoard[i1][i2].getLocation() + " ");
			}
			i1++;
			i2++;
		}
		int j1 = line - 1;
		int j2 = row - 1;
		bool = false;
		while (j1 >= EDGE_OF_BOARD_LOW && j2 >= EDGE_OF_BOARD_LOW && gameBoard[j1][j2].getColor() != color && bool == false) {
			if (gameBoard[j1][j2].getColor() == opColor) {
				arr[count] = gameBoard[j1][j2].getLocation();
				count++;
				bool = true;
			}
			else if (gameBoard[j1][j2].getColor() == EMPTY) {
				arr[count] = gameBoard[j1][j2].getLocation();
				count++;
			}
			j1--;
			j2--;
		}
		int k1 = line + 1;
		int k2 = row - 1;
		bool = false;
		while (k1 <= EDGE_OF_BOARD_HIGHT && k2 >= EDGE_OF_BOARD_LOW && gameBoard[k1][k2].getColor() != color && bool == false) {
			if (gameBoard[k1][k2].getColor() == opColor) {
				arr[count] = gameBoard[k1][k2].getLocation();
				count++;;
				bool = true;
			}
			else if (gameBoard[k1][k2].getColor() == EMPTY) {
				arr[count] = gameBoard[k1][k2].getLocation();
				count++;;
			}
			k1++;
			k2--;
		}
		int l1 = line - 1;
		int l2 = row + 1;
		bool = false;
		while (l1 >= EDGE_OF_BOARD_LOW && l2 <= EDGE_OF_BOARD_HIGHT && gameBoard[l1][l2].getColor() != color && bool == false) {
			if (gameBoard[l1][l2].getColor() == opColor) {
				arr[count] = gameBoard[l1][l2].getLocation();
				count++;
				bool = true;
			}
			else if (gameBoard[l1][l2].getColor() == EMPTY) {
				arr[count] = gameBoard[l1][l2].getLocation();
				count++;;
			}

			l1--;
			l2++;
		}
		if (arr[0] == null) {
			return null;
		}
		return arr;
	}

}
