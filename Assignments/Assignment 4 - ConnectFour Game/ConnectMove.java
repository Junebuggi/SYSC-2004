
/**
 * Used to store information about the move made in ConnectFourGame.java to be
 * passed on to its observer ConnectFourApplication.java to update the GUI
 * representation of the board
 *
 * @author emmaboulay
 * @version 1.0
 */
public class ConnectMove {

    private int row;
    private int column;
    private ConnectFourEnum colour;

    /**
     * Models the checker being placed
     *
     * @param row The row the checker is placed on on the game board
     * @param column The column the checker is placed on on the game board
     * @param colour A ConnectFourEnum representation of the color of the
     * checker placed
     */
    public ConnectMove(int row, int column, ConnectFourEnum colour) {
        this.row = row;
        this.column = column;
        this.colour = colour;
    }

    /**
     * @return An integer representation of the row where the checker is placed
     */
    public int getRow() {
        return this.row;
    }

    /**
     * @return An integer representation of the column where the checker is
     * placed
     */
    public int getColumn() {
        return this.column;
    }

    /**
     * @return An ConnectFourEnum representation of the colour of the checker
     */
    public ConnectFourEnum getColour() {
        return this.colour;
    }
}
