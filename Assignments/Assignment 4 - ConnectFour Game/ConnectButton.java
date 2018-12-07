
/**
 * A model of a connect-four square on a connect-four game board
 *
 * @author emmaboulay
 * @version 1.0
 */
public class ConnectButton extends javafx.scene.control.Button {

    private int row;
    private int column;

    /**
     * Constructs a Connect Button
     *
     * @param label Either RED, BLACK or EMPTY
     * @param row The row the button is on on the game board
     * @param column The column the button is on on the game board
     */
    public ConnectButton(String label, int row, int column) {
        super(label);
        this.row = row;
        this.column = column;
        setMaxWidth(Double.MAX_VALUE);

    }

    /**
     * @return An integer representation of the row of the button
     */
    public int getRow() {
        return this.row;
    }

    /**
     * @return An integer representation of the column of the button
     */
    public int getColumn() {
        return this.column;
    }

    @Override
    /**
     * @return A string representation of the button in the form <row>,<column>
     */
    public String toString() {
        return "(<" + row + ">,<" + column + ">)";
    }

}
