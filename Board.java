
public class Board {
	
	final static int BOARD_LENGTH = 8;
	
	final int ROW_CURRENT_PLACE_I = 0;
	final int COL_CURRENT_PLACE_I = 0;
	
	final int ROW_CURRENT_PLACE_J = 0;
	final int COL_CURRENT_PLACE_J = 1;
		
	final int ROW_FUTURE_PLACE_I = 1;
	final int COL_FUTURE_PLACE_I = 0;
	
	final int ROW_FUTURE_PLACE_J = 1;
	final int COL_FUTURE_PLACE_J = 1;
	
	
	

	private Piece[][] board = {
			{new Rook("black", "rb1", "a8"), new Knight("black", "nb1", "b8"), new Bishop("black", "bb1", "c8"), new Queen("black", "qb1", "d8"), new King("black", "kb1", "e8"), new Bishop("black", "bb2", "f8"), new Knight("black", "nb2", "g8"), new Rook("black", "rb2", "h8")},
			{new Pawn("black", "pb1", "a7"),new Pawn("black", "pb2", "b7"),new Pawn("black", "pb3", "c7"),new Pawn("black", "pb4", "d7"),new Pawn("black", "pb5", "e7"),new Pawn("black", "pb6", "f7"),new Pawn("black", "pb7", "g7"),new Pawn("black", "pb8", "h7")},
			{new Empty("empty", " _ ", "a6"),new Empty("empty", " _ ", "b6"),new Empty("empty", " _ ", "c6"),new Empty("empty", " _ ", "d6"),new Empty("empty", " _ ", "e6"),new Empty("empty", " _ ", "f6"),new Empty("empty", " _ ", "g6"),new Empty("empty", " _ ", "h6")},
			{new Empty("empty", " _ ", "a5"),new Empty("empty", " _ ", "b5"),new Empty("empty", " _ ", "c5"),new Empty("empty", " _ ", "d5"),new Empty("empty", " _ ", "e5"),new Empty("empty", " _ ", "f5"),new Empty("empty", " _ ", "g5"),new Empty("empty", " _ ", "h5")},
			{new Empty("empty", " _ ", "a4"),new Empty("empty", " _ ", "b4"),new Empty("empty", " _ ", "c4"),new Empty("empty", " _ ", "d4"),new Empty("empty", " _ ", "e4"),new Empty("empty", " _ ", "f4"),new Empty("empty", " _ ", "g4"),new Empty("empty", " _ ", "h4")},
			{new Empty("empty", " _ ", "a3"),new Empty("empty", " _ ", "b3"),new Empty("empty", " _ ", "c3"),new Empty("empty", " _ ", "d3"),new Empty("empty", " _ ", "e3"),new Empty("empty", " _ ", "f3"),new Empty("empty", " _ ", "g3"),new Empty("empty", " _ ", "h3")},
			{new Pawn("white", "pw1", "a2"),new Pawn("white", "pw2", "b2"),new Pawn("white", "pw3", "c2"),new Pawn("white", "pw4", "d2"),new Pawn("white", "pw5", "e2"),new Pawn("white", "pw6", "f2"),new Pawn("white", "pw7", "g2"),new Pawn("white", "pw8", "h2")},
			{new Rook("white", "rw1", "a1"), new Knight("white", "nw1", "b1"), new Bishop("white", "bw1", "c1"), new Queen("white", "qw1", "d1"), new King("white", "kw1", "e1"), new Bishop("white", "bw2", "f1"), new Knight("white", "nw2", "g1"), new Rook("white", "rw2", "h1")}
	};

	

	public Piece[][] getBoard()
	{
		return this.board;
	}
	
	
	public void setBoard(int [][] locations)
	{
		String temp2 = board[locations[ROW_FUTURE_PLACE_I][COL_FUTURE_PLACE_I]][locations[ROW_FUTURE_PLACE_J][COL_FUTURE_PLACE_J]].getLocation();
		board[locations[ROW_FUTURE_PLACE_I][COL_FUTURE_PLACE_I]][locations[ROW_FUTURE_PLACE_J][COL_FUTURE_PLACE_J]].setLocation(board[locations[ROW_CURRENT_PLACE_I][COL_CURRENT_PLACE_I]][locations[ROW_CURRENT_PLACE_J][COL_CURRENT_PLACE_J]].getLocation());
		board[locations[ROW_CURRENT_PLACE_I][COL_CURRENT_PLACE_I]][locations[ROW_CURRENT_PLACE_J][COL_CURRENT_PLACE_J]].setLocation(temp2);
		
		
		Piece temp = board[locations[ROW_FUTURE_PLACE_I][COL_FUTURE_PLACE_I]][locations[ROW_FUTURE_PLACE_J][COL_FUTURE_PLACE_J]];
		if (!temp.getColor().equals("empty"))
		{
			board[locations[ROW_FUTURE_PLACE_I][COL_FUTURE_PLACE_I]][locations[ROW_FUTURE_PLACE_J][COL_FUTURE_PLACE_J]] = board[locations[ROW_CURRENT_PLACE_I][COL_CURRENT_PLACE_I]][locations[ROW_CURRENT_PLACE_J][COL_CURRENT_PLACE_J]];
			board[locations[ROW_CURRENT_PLACE_I][COL_CURRENT_PLACE_I]][locations[ROW_CURRENT_PLACE_J][COL_CURRENT_PLACE_J]] = new Empty("empty", " _ ", board[locations[ROW_CURRENT_PLACE_I][COL_CURRENT_PLACE_I]][locations[ROW_CURRENT_PLACE_J][COL_CURRENT_PLACE_J]].getLocation());
		}
		
		
		else
		{
			board[locations[ROW_FUTURE_PLACE_I][COL_FUTURE_PLACE_I]][locations[ROW_FUTURE_PLACE_J][COL_FUTURE_PLACE_J]] = board[locations[ROW_CURRENT_PLACE_I][COL_CURRENT_PLACE_I]][locations[ROW_CURRENT_PLACE_J][COL_CURRENT_PLACE_J]];
			board[locations[ROW_CURRENT_PLACE_I][COL_CURRENT_PLACE_I]][locations[ROW_CURRENT_PLACE_J][COL_CURRENT_PLACE_J]] = temp;
		}
		
		
	}
	
	
	/*prints the game board and the locations of the board*/
	public String toString()
	{
		String strToPrint = "";
		
		for (int i = 0; i < BOARD_LENGTH; i++)
		{
			for (int j = 0; j < BOARD_LENGTH; j++)
				strToPrint += this.board[i][j] + " |";
			
			strToPrint += "\t";
			
			for (int j = 0; j < BOARD_LENGTH; j++)
				strToPrint += this.board[i][j].getLocation() + " | ";
			
			strToPrint += "\n";
		}
		
		return strToPrint;
	}


}