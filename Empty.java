
public class Empty extends Piece{


	public Empty(String color, String type, String location) {
		super(color, type, location);
	}


	public Empty(Piece copy) {
		super(copy);
	}


	@Override
	public String[] move(String color, String opColor, Board board, int line, int row) {
		return null;
	}


}
