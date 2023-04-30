import java.util.Arrays;
import java.util.LinkedList;

public class chessboard {
    Piece[][] board = new Piece[9][9];
    LinkedList<String[]> moveList;

    public chessboard()
    {

        initBoard();
        moveList = new LinkedList<String[]>();
    }



    public void move(String from, String to)
    {
        int fromCol = Character.toLowerCase(from.charAt(0)) - 'a'+ 1;
        int fromRow = Integer.parseInt(from.substring(1));

        int toCol = Character.toLowerCase(to.charAt(0)) - 'a'+ 1;
        int toRow = Integer.parseInt(to.substring(1));

        int[] fromPosition = new int[]{fromRow, fromCol};
        int[] toPosition = new int[]{toRow, toCol};


        if(board[fromRow][fromCol].move(toPosition))
        {
            board[fromRow][fromCol].recordMove();
            board[toRow][toCol] = board[fromRow][fromCol];
            board[fromRow][fromCol] = new Piece(fromPosition);
            System.out.println("Moved piece on " + from + " to " + to);
            System.out.println("Piece moved was " + board[toRow][toCol].originalPiece());


        } else
        {
            System.out.println("Failed to move piece from " + from + " to " + to);
        }

    }

public void initBoard() {
    // Initialize pawns
    for (int i = 1; i <= 8; i++) {
        insertPiece(new Pawn(new int[]{2, i}, "W", this), (char) ('a' + i - 1) + "2");
        insertPiece(new Pawn(new int[]{7, i}, "B", this), (char) ('a' + i - 1) + "7");
    }

    // Initialize white pieces
    insertPiece(new Rook(new int[]{1, 1}, "W", this), "a1");
    insertPiece(new Knight(new int[]{1, 2}, "W", this), "b1");
    insertPiece(new Bishop(new int[]{1, 3}, "W", this), "c1");
    insertPiece(new Queen(new int[]{1, 4}, "W", this), "d1");
    insertPiece(new King(new int[]{1, 5}, "W", this), "e1");
    insertPiece(new Bishop(new int[]{1, 6}, "W", this), "f1");
    insertPiece(new Knight(new int[]{1, 7}, "W", this), "g1");
    insertPiece(new Rook(new int[]{1, 8}, "W", this), "h1");

    // Initialize black pieces
    insertPiece(new Rook(new int[]{8, 1}, "B", this), "a8");
    insertPiece(new Knight(new int[]{8, 2}, "B", this), "b8");
    insertPiece(new Bishop(new int[]{8, 3}, "B", this), "c8");
    insertPiece(new Queen(new int[]{8, 4}, "B", this), "d8");
    insertPiece(new King(new int[]{8, 5}, "B", this), "e8");
    insertPiece(new Bishop(new int[]{8, 6}, "B", this), "f8");
    insertPiece(new Knight(new int[]{8, 7}, "B", this), "g8");
    insertPiece(new Rook(new int[]{8, 8}, "B", this), "h8");
// Fill the remaining board positions with empty pieces
    for (int i = 3; i <= 6; i++) {
        for (int j = 1; j <= 8; j++) {
            insertPiece(new Piece(new int[]{i, j}, "Empty"), (char) ('a' + j - 1) + Integer.toString(i));
        }
    }
}


    public void insertPiece(Piece p, String position) {
        int col = Character.toLowerCase(position.charAt(0)) - 'a' + 1;
        int row = Integer.parseInt(position.substring(1));

        board[row][col] = p;
    }

public void printBoard() {
    System.out.println("\n  +---------+---------+---------+---------+---------+---------+---------+---------+");
    for (int i = 8; i >= 1; i--) {
        System.out.print(i + " ");
        for (int j = 1; j <= 8; j++) {
            String piece = board[i][j].toString();
            int spacesBefore = (9 - piece.length()) / 2;
            int spacesAfter = 9 - piece.length() - spacesBefore;
            System.out.print("|" + " ".repeat(spacesBefore) + piece + " ".repeat(spacesAfter));
        }
        System.out.println("|");
        System.out.println("  +---------+---------+---------+---------+---------+---------+---------+---------+");
    }
    System.out.println("    a         b         c         d         e         f         g         h");
}




    public Piece getPiece(int[] position)
    {
        return this.board[position[0]][position[1]];
    }
}
