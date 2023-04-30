public class King extends Piece {
    chessboard board;

    public King(int[] position, String color, chessboard board) {
        super(position, color, "King");
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

        // Check if the move is one square in any direction
        if (rowDifference > 1 || colDifference > 1) {
            System.out.println("Failed one-square move test");
            return false;
        }

        return true;
    }
}
