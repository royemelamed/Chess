public class RunGame{

	public static void main(String[] args) {
		Board board = new Board();//creates a new 'ArraysForGame' object
		Game game = new Game();// creates a new 'Game' object
		System.out.println(game.gameLoop(board));//running the loop
	}
	
}