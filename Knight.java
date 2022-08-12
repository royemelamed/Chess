
public class Knight extends Piece
{
	final int POSSIBLE_MOVES = 8;

    public Knight(String color, String type, String location) {
        super(color, type, location);
    }


    public String [] move (String color, String opColor, Board board, int line,int row) {
        Piece[][] gameBoard = board.getBoard();
        String [] PossibleLocations = new String[POSSIBLE_MOVES];
        int count = 0;
        int x;
        int y;
        for (int endLine = 0; endLine < BOARD_LENGTH; endLine++) {
            for (int endRow = 0; endRow < BOARD_LENGTH; endRow++) {
            	
            	x = Math.abs(line - endLine);
                y = Math.abs(row - endRow);
               
                
                if (x * y == 2 && gameBoard[endLine][endRow].getColor() != color) {
                	PossibleLocations[count] = gameBoard[endLine][endRow].getLocation();
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
