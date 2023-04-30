public class Knight extends Piece {
    chessboard board;

    public Knight(int[] position, String color, chessboard board) {
        super(position, color, "Knight");
        this.board = board;
    }

    @Override
    public boolean move(int[] position) {
        if (!basicCheck(position, board)) {
            System.out.println("Failed basic test");
            return false;
        }

        int rowDifference = Math.abs(moveRow - row);
        int colDifference = Math.abs(moveCol - col);

        // Check if the move is an L-shape (either 2 squares in one direction and 1 square in the other)
        if (!((rowDifference == 2 && colDifference == 1) || (rowDifference == 1 && colDifference == 2))) {
            System.out.println("Failed L-shape test");
            return false;
        }

        return true;
    }
}
