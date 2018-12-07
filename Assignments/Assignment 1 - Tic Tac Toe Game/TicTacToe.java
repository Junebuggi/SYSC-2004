package assignment1_TicTacToe;

import static assignment1_TicTacToe.TicTacToeEnum.IN_PROGRESS;
import java.util.Scanner;


/**
 *
 * @author Junebuggi
 */
public class TicTacToe {
    
    private int nRows;
    private int nColumns;
    private int numToWin;
    private char[][] grid;
    private char turn;
    private TicTacToeEnum gameState = IN_PROGRESS;
    private int nMarks = 0;
    
    public TicTacToe(char initialTurn) {
        
    	this( 3, 3, 3, initialTurn);  
    		
    }
    public TicTacToe(int nRows, int nColumns, int numToWin, char initialTurn) {
  
    	if (nRows < 0 || nColumns < 0)
    		throw new IllegalArgumentException("Grid size must be positive");
    	if (numToWin > nRows || numToWin > nColumns)
    		throw new IllegalArgumentException("numToWin must be less than or eqaul to grid dimensions");
        this.nRows = nRows;
        this.nColumns = nColumns;
        this.numToWin = numToWin;
        this.grid = new char[nRows][nColumns];
        reset(initialTurn);
    			
    }
    
    public void reset(char initialTurn) {
 
    	for (int r = 0; r < nRows; r++) {
    		for(int c = 0; c < nColumns; c++) {
    			this.grid[r][c] = ' ';
    		}
    	}
    	
        this.turn = initialTurn;        
        this.nMarks = 0;
        this.gameState = TicTacToeEnum.IN_PROGRESS;
    }
    
   

    
    public char getTurn() {
        return this.turn;
    }
    
    public TicTacToeEnum getGameState() {
        return this.gameState;
    }
    
    private TicTacToeEnum charToEnum (char player) {
        
    	if (player == 'X') return TicTacToeEnum.X_WON;
        if (player == 'O') return TicTacToeEnum.O_WON;
        throw new IllegalArgumentException("charToEnum(' + player + '): player must be either X or O");
    
    }
    
    public TicTacToeEnum takeTurn(int row, int column)  {  

        if (row < 0 || row > this.nRows) 
            throw new IllegalArgumentException("Grid is " + this.nRows + " by " + this.nColumns);
        
        if (column < 0 || column > this.nColumns) 
            throw new IllegalArgumentException("Grid is " + this.nRows + " by " + this.nColumns);        
        
        if (this.grid[row][column] != ' ') 
            throw new IllegalArgumentException("Square is already occupied");
        
        this.grid[row][column] = this.turn;
        this.nMarks++;
    
        if(this.turn == 'X') this.turn = 'O';   //Switches who is playing now
        else this.turn = 'X';
        
        this.gameState = findWinner();
        return this.gameState;
        
    }
 
    private TicTacToeEnum findWinner() {
     
        for (int row = 0; row < nRows; row++) {
            for (int column = 0; column < nColumns; column++) {
                if (grid[row][column] != ' ') {
                    int count = 1;
                    // Look horizontally - to the left of the square 
                    for (int c = column - 1; c > 0; c--) {
                    	if (this.grid[row][column] == this.grid[row][c]) {
                    		count++;
                    		if (count == this.numToWin) {
                    			return charToEnum(grid[row][column]);
                    		}	
                    	} 
                    }
                    
                 // if this does not return winner also look to right of square
                    for (int c = column + 1; c < this.nColumns; c++) {
                    	if (this.grid[row][column] == this.grid[row][c]) {
                    		count++;
                    		if (count == this.numToWin) {
                    return charToEnum(grid[row][column]);
                    		}
                    	} 
                    }
    
                    // Look vertically - above the sqaure
                    count = 1;
                    for (int r = row - 1; r > 0; r--) {
                    	if (this.grid[r][column] == this.grid[row][column]) {
                    		count++;
                    		if (count == this.numToWin) {
                    			return charToEnum(grid[row][column]);
                    		}
                    	} 
                    }
                    
                    // If this does not return a winner also look below the square
                    for (int r = row + 1; r < this.nRows; r++) {
                    	if (this.grid[row][column] == this.grid[r][column]) {
                    		count++;
                    		if (count == this.numToWin) {
                    			return charToEnum(grid[row][column]);
                    		}
                    	} 
                    }
                }
            }
        }
        if (nMarks == this.nRows * this.nColumns) {  //If all the squares are occupied and still no winner then it's a draw
            return TicTacToeEnum.DRAW;
        }  
        return TicTacToeEnum.IN_PROGRESS;
    }
    
  @Override   
    public String toString() {
        String str = "";
        for (int r = 0; r < nRows; r++ ) {
            for (int c = 0; c < nColumns; c++) {
                str += grid[r][c] + " | ";
            }
            str += "\n";
        }
        return str;
    }
    
    public static void main(String args[]) {
        TicTacToe game = new TicTacToe('X');
        Scanner scanner = new Scanner(System.in);

        do { 
            System.out.println(game.toString());
            System.out.println(game.getTurn() + ": Where do you want to mark? Enter row column");
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            scanner.nextLine();
            game.takeTurn(row, column);
            
        } while (game.getGameState() == TicTacToeEnum.IN_PROGRESS);
        System.out.println( game.getGameState());
       
    }
}
