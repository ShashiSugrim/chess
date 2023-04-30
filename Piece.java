import java.util.LinkedList;

public class Piece {
    protected int row,col;
    protected int[] position = {row,col};
    protected String color;
    private String type;
    protected LinkedList<String> moves;
    protected int moveRow, moveCol; // the position we will move to
    private int initialRow, initialCol;
    protected String opp;

    public Piece(int[] position, String color, String type)
    {
        this.position = position;
        this.row = position[0];
        this.col = position[1];
        initialRow = row;
        initialCol = col;
        this.color = color;
        this.type = type;
        opp = type.equals("W")? "B":"W";

        moves = new LinkedList<String>();
    }

    public Piece(int[] position, String type)
    {
        this.position = position;
        this.row = position[0];
        this.col = position[1];
        this.type = type;
        opp = type.equals("W")? "B":"W";
        this.color = "";
    }

    public Piece(int[] position)
    {
        this(position, "Empty");
    }

    public String getColor()
    {
        return this.color;
    }

    public String getPositionStr()
    {
        return Integer.toString(row)+ Integer.toString(col);
    }

    public int[] getPosition()
    {
        return this.position;
    }

    public String toString()
    {
        return this.color + this.type;
    }

    // cant move a empty piece, otherwise this is overridden by each class that uses piece
    public boolean move(int[] position){return !type.equals("Empty");};

    public boolean basicCheck(int[] position, chessboard board)
    {
        moveRow = position[0];
        moveCol = position[1];
        // Can't move to your current position
        if(position == this.getPosition())
        {
            return false;
        }
        // cant move higher or lower than the board
        if(position[0] < 1 || position[0] > 8)
        {
            return false;
        }
        // cant move left or right off the board
        if(position[1] < 1 || position[1] > 8)
        {
            return false;
        }
        // cant take your own piece
        if(board.getPiece(position).getColor().equals(this.getColor()))
        {
            return false;
        }

        return true;
    }

    public String originalPiece()
    {
        return this.type + " on " + (char)(initialCol + 'A' -1) + initialRow;
    }

    public void recordMove()
    {
        if(type.equals("Empty")) return; // dont record a move here, this isnt a piece
        moves.push((char)(col + 'A' -1) + Integer.toString(moveRow));
        row = moveRow;
        col = moveCol;
    }


}
