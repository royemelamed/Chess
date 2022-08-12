
public class Queen extends Piece
{
	
	final int POSSIBLE_MOVES = 28;


	public Queen(String color, String type, String location) {
		super(color, type, location);
	}
	
	public String[] move(String color, String opColor, Board board, int line,int row) {
		Bishop bishop = new Bishop(null, null, null);
		Rook rook = new Rook(null, null, null);
		
		String [] firstArr = bishop.move(color, opColor, board, line, row);
		String [] secondArr = rook.move(color, opColor, board, line, row);
		
		String [] PossibleLocations = new String[POSSIBLE_MOVES];
		int count = 0;
		if (firstArr != null) {
			for (int i = 0; i < firstArr.length; i++) {
				if (firstArr[i] != null) {
					PossibleLocations[count] = firstArr[i];
					count++;
				}
			}
		}
		if (secondArr != null) {
			for (int i = 0; i < secondArr.length; i++) {
				if (secondArr[i] != null) {
					PossibleLocations[count] = secondArr[i];
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
