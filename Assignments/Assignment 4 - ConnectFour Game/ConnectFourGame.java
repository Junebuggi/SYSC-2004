
import java.util.Observable;

/**
 * A model of a Connect-Four Game. Players attempt to place their checkers in s
 * horizontal, vertical or diagonal line with enough checkers before their
 * opponent.
 *
 * @author emmaboulay
 * @version 1.0
 */
public class ConnectFourGame extends Observable {

    private int nColumns;
    private int nRows;
    private int numToWin;
    private int nMarks;
    private ConnectFourEnum[][] grid;
    private ConnectFourEnum gameState;
    private ConnectFourEnum turn;

    /**
     * A default constructor. Will construct a 8x8 board with 4 checkers in a
     * row to win.
     *
     * @param initialTurn A ConnectFourEnum representation of a Red or Black
     * checker
     */
    public ConnectFourGame(ConnectFourEnum initialTurn) {
        this(8, 8, 4, initialTurn);
    }

    /**
     * An overloaded constructor. Will construct the custom board with custom
     * number needed to win
     *
     * @param nRows An integer representation of the number of rows in the game
     * board
     * @param nColumns An integer representation of the number of columns in the
     * game board
     * @param numToWin An integer representation of the number of checkers of
     * the same colour in a line to win
     * @param initialTurn A ConnectFourEnum representation of a Red or Black
     * checker
     */
    public ConnectFourGame(int nRows, int nColumns, int numToWin, ConnectFourEnum initialTurn) {
        if ((nRows < numToWin || nColumns < numToWin)) {
            throw new IllegalArgumentException("Number to win is to large. Winning is impossible with this size of grid");
        }
        if (nRows <= 0 || nColumns <= 0 || numToWin <= 0) {
            throw new IllegalArgumentException("All parameters must be positive integers");
        }
        this.nRows = nRows;
        this.nColumns = nColumns;
        this.numToWin = numToWin;
        this.grid = new ConnectFourEnum[nRows][nColumns];
        for (int r = 0; r < nRows; r++) {
            for (int c = 0; c < nColumns; c++) {
                this.grid[r][c] = ConnectFourEnum.EMPTY;
            }
        }
        this.gameState = ConnectFourEnum.IN_PROGRESS;
        this.turn = initialTurn;
        this.nMarks = 0;
    }

    /**
     * Resets the game and each square on the board to EMPTY.
     *
     * @param initialTurn A ConnectFourEnum representation of a Red or Black
     * checker
     */
    public void reset(ConnectFourEnum initialTurn) {
        for (int r = 0; r < nRows; r++) {
            for (int c = 0; c < nColumns; c++) {
                this.grid[r][c] = ConnectFourEnum.EMPTY;
                setChanged();
                notifyObservers(new ConnectMove(r, c, ConnectFourEnum.EMPTY));
            }
        }
        this.turn = initialTurn;
        this.gameState = ConnectFourEnum.IN_PROGRESS;
        this.nMarks = 0;
    }

    /**
     * Models a player taking a turn on a Connect Four game board. Uses the
     * private method findWinner() to check if the checker placed resulted in a
     * winner.
     *
     * @param row An integer representation of the row where the checker is to
     * be placed
     * @param column An integer representation of the column where the checker
     * is to be placed
     * @return The game State. If and which player won or if there is a draw
     */
    public ConnectFourEnum takeTurn(int row, int column) {
        if (row > 0 && grid[row - 1][column] == ConnectFourEnum.EMPTY) {
            throw new IllegalArgumentException("A checker cannot be put above an empty location. It will fall down!");
        }
        if (grid[row][column] != ConnectFourEnum.EMPTY) { //the square is already filled, instead of throwing an exception the player is allowed to try again
            System.out.println("Square is already full, try another spot");
            return this.turn;
        }
        grid[row][column] = this.turn;
        nMarks++;
        setChanged();
        notifyObservers(new ConnectMove(row, column, turn));
        if (this.turn == ConnectFourEnum.BLACK) {
            this.turn = ConnectFourEnum.RED;
        } else {
            this.turn = ConnectFourEnum.BLACK;
        }
        this.gameState = findWinner(row, column);
        return this.gameState;
    }

    /**
     * A private method that checks if the checker placed in takeTurn resulted
     * in a winner. Looks for a continuous horizontal, vertical and diagonal
     * line that meets the number needed to win
     *
     * @param row An integer representation of the row where the checker is to
     * be placed
     * @param column An integer representation of the column where the checker
     * is to be placed
     * @return The gameState. If and which player won or if there is a draw
     */
    private ConnectFourEnum findWinner(int row, int column) {
        int count = 1;
        // Look horizontally - to the left of the square
        for (int c = column - 1; c >= 0; c--) {
            if (this.grid[row][column] == this.grid[row][c]) {
                count++;
                if (count == this.numToWin) {
                    return grid[row][column];
                }
            } else //needs to be consecutive
                break;
            
        }
        // if this does not return winner also look to right of square
        for (int c = column + 1; c < this.nColumns; c++) {
            if (this.grid[row][column] == this.grid[row][c]) {
                count++;
                if (count == this.numToWin) {
                    return grid[row][column];
                }
            } else //needs to be consecutive
                break;
            
        }
        // Look vertically - below the sqaure, no need to look above
        count = 1;
        for (int r = row - 1; r >= 0; r--) {
            if (this.grid[r][column] == this.grid[row][column]) {
                count++;
                if (count == this.numToWin) {
                    return grid[row][column];
                }
            } else //needs to be consecutive
                break;
            
        }
        count = 1;
        //Diagonaly Down and to the right
        int c = column + 1;
        for (int r = row + 1; r < this.nRows && c < this.nColumns; r++, c++) {
            if (this.grid[row][column] == this.grid[r][c]) {
                count++;
                if (count == this.numToWin) {
                    return grid[row][column];
                }
            } else //needs to be consecutive
                break;
            
        }
        //If this does not return a winner also look up and to the left
        c = column - 1;
        for (int r = row - 1; r >= 0 && c >= 0; r--, c--) {
            if (this.grid[row][column] == this.grid[r][c]) {
                count++;
                if (count == this.numToWin) {
                    return grid[row][column];
                }
            } else //needs to be consecutive
                break;   
        }
        count = 1;
        //Diagonaly Down and to the left
        c = column - 1;
        for (int r = row + 1; r < this.nRows && c >= 0; r++, c--) {
            if (this.grid[row][column] == this.grid[r][c]) {
                count++;
                if (count == this.numToWin) {
                    return grid[row][column];
                }
            } else //needs to be consecutive
                break;
        }
        //If this does not return a winner also look up and to the right
        c = column + 1;
        for (int r = row - 1; r >= 0 && c < this.nColumns; r--, c++) {
            if (this.grid[row][column] == this.grid[r][c]) {
                count++;
                if (count == this.numToWin) {
                    return grid[row][column];
                }
            } else //needs to be consecutive
                break;
        }
        if (nMarks == this.nRows * this.nColumns) {  //If all the squares are occupied and still no winner then it's a draw
            return ConnectFourEnum.DRAW;
        }
        return ConnectFourEnum.IN_PROGRESS;
    }

    /**
     * Returns the gameState
     *
     * @return A ConnectFourEnum representation of the game State. If and which
     * player won or if there is a draw
     */
    public ConnectFourEnum getGameState() {
        return gameState;
    }

    /**
     * Returns the current player
     * 
     * @return A ConnectFourEnum representation of the current player
     */
    public ConnectFourEnum getTurn() {
        return this.turn;
    }

    /**
     * @return A string representation of the connect four board
     */
    @Override
    public String toString() {
        String s = "";
        for (int r = 0; r < nRows; r++) {
            for (int c = 0; c < nColumns; c++) {
                s += grid[r][c] + " | ";
            }
            s += "\n";
        }
        return s;
    }
}