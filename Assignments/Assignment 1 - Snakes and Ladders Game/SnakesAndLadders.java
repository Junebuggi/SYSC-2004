/**
 * Models a game of Snakes and Ladders
 * 
 * @author emmaboulay
 * @version 1.0
 */
public class SnakesAndLadders {
	
	public static final int DEFAULT_NUM_PLAYERS = 2;
	public static final int NUM_SQUARES = 100;
	private SnLSquare[] board;
	private int[] players;
	private Dice dice;
	
	/**
	 * Default Constructor : 2 players
	 */
	public SnakesAndLadders() {
		this(DEFAULT_NUM_PLAYERS);
	}
	
	/**
	 * Constructs a game of Snakes and Ladders with nPlayers
	 * @param nPlayers The number of players
	 */
	public SnakesAndLadders(int nPlayers){
		board = new SnLSquare[NUM_SQUARES]; //Constructs a SnLs board of 100 squares
		
		//Constructs new LadderSquare at desired position on board
		board[3] = new LadderSquare(4, 14);
		board[8] = new LadderSquare(9, 31);
		board[19] = new LadderSquare(20, 38);
		board[27] = new LadderSquare(28, 84);
		board[39] = new LadderSquare(40, 59);
		board[62] = new LadderSquare(63, 81);
		board[70] = new LadderSquare(71, 92);
		
		//Constructs new SnakeSquare at desired position on board	
		board[16] = new SnakeSquare(17, 7);
		board[53] = new SnakeSquare(54, 34);
		board[61] = new SnakeSquare(62, 18);
		board[63] = new SnakeSquare(64, 60);
		board[86] = new SnakeSquare(87, 24);
		board[92] = new SnakeSquare(93, 73);
		board[94] = new SnakeSquare(95, 75);
		board[98] = new SnakeSquare(99, 78);
		
		for(int i = 0; i < NUM_SQUARES; i++) {
			if(board[i] == null) board[i] = new SnLSquare(i+1); //Initializes every null square in the board from 1 to 100
		}
		
		dice =  new Dice(); //Constructs a pair of dice
		
		players = new int[nPlayers];
		for(int i = 0; i < players.length; i++) players[i] = 1; //Every player starts on square 1
	}
	
	/**
	 * Mimics the actions of a player taking their turn
	 * @param player The assigned index in the players array
	 * @return True if the player rolled doubles
	 */
	public boolean takeTurn(int player) {
		
		int roll = dice.roll(); 
		System.out.println("Player " + player +" rolled " + roll );
		int square = players[player] + roll; //Roll the dice and calculate to which square the player moves
		
		if(square > NUM_SQUARES) square = NUM_SQUARES * 2 - square; //The player did not land exactly on 100. Roll is too large, player must move back in excess amount
																	//Expands NUM_SQUARES - (square - NUM_SQUARES)
		players[player] = board[square - 1].landOn(); //Player moves and lands on new square
		
		return dice.hasDoubles();
	}
	
	/**
	 * @param player The assigned index in the players array
	 * @return True if player is a winner
	 */
	public boolean isPlayerWinner(int player) {
		if(players[player] == 100) return true; //Only a winner if player lands exactly on 100
		return false;
	}
	
	/**
	 * @return First player found to be a winner, when no winners exists returns -1
	 */
	public int getWinner() {
		for (int i = 0; i < players.length ; i++) { //Returns the first winner found
			if(isPlayerWinner(i)) return i;
		}
		return -1;
	} 
	
	/** 
	 * @param player The assigned index in the players array
	 * @return The current square of the player
	 */
	public int getPlayerPosition(int player) { 
		return players[player];
	}
	
	/**
	 * @return A String representation of a Snakes and Ladders board
	 */
	@Override
	public String toString() {
		String s = "Snakes and Ladders\n";
		for(int i = 0; i < 100; i += 10) {
			for(int j = 0; j < 10; j++ ) {
				s += "| " + board[i+j].toString() + " ";
			}
			s += "\n";
		}
		return s;
	}
	
	/** 
	 * @return A String representation of every player's current position
	 */
	public String toStringCurrentPositions() {
		String s = "";
		for(int i = 0; i < players.length; i++) {
			s+= i + ":" + players[i] + " ";
		}
		return s;
	}

	/** 
	 * This is the main method which makes use of the SnakesAndLadders class
	 * to simulate a game of Snakes and Ladders
	 * @param args Unused.
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
	
		SnakesAndLadders game = new SnakesAndLadders(); //Default number of players is 2. Change this by changing DEFAULT_NUM_PLAYERS constant in SnakesAndLadders class
		System.out.println("\n" + game.toString());
		
		boolean hasDoubles;
		int i;
		
		for(i = 0; game.getWinner() == -1; i = (i + 1) % game.DEFAULT_NUM_PLAYERS) { //Treats DEFAULT_NUM_PLAYERS as indices in a circular array
			hasDoubles = game.takeTurn(i);   
			if (!game.isPlayerWinner(i)) System.out.println(game.toStringCurrentPositions()); //Only prints out current position if current player is not winner
			if (hasDoubles || game.isPlayerWinner(i)) i--;  // If the player rolled doubles they will take another turn
		}
		
		System.out.println("Player " + i + " wins.");
		
	}
}
