
public abstract class Piece
{
	final static protected int BOARD_LENGTH = 8;
	
	final protected int EDGE_OF_BOARD_HIGHT = 7;
	final protected int EDGE_OF_BOARD_LOW = 0;
	
	private String color;
	private String type;
	private String location;

	public Piece(String color, String type, String location)
	{
		this.color = color;
		this.type = type;
		this.location = location;
	}
	
	public Piece(Piece copy)
	{
		this.color = copy.getColor();
		this.location = copy.getLocation();
		this.type = copy.getType();
	}
	
	public String getColor()
	{
		return this.color;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	public String getType()
	{
		return this.type;
	}
	public void setType(String type)
	{
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
    //this function gets array, line and row and return array with the possible moves
	public abstract String[] move(String color, String opColor, Board board, int line,int row);
	
	public String toString()
	{
		return this.type;
	}
		
}
