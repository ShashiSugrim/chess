public class Queen extends Piece {
    chessboard board;

    public Queen(int[] position, String color, chessboard board) {
        super(position, color, "Queen");
        this.board = board;
    }

    @Override
    public boolean move(int[] position) {
        if (!basicCheck(position, board)) {
            return false;
        }

        int rowDifference = Math.abs(moveRow - row);
        int colDifference = Math.abs(moveCol - col);

        // Check if the move is either a straight line or a diagonal line
        if (rowDifference == colDifference || row == moveRow || col == moveCol) {
            int rowStep = (moveRow > row) ? 1 : -1;
            int colStep = (moveCol > col) ? 1 : -1;

            // When moving in a straight line, set one of the steps to 0
            if (row == moveRow) {
                rowStep = 0;
            }
            if (col == moveCol) {
                colStep = 0;
            }

            // Check for obstacles in the path and allow capturing opponent's piece at the destination
            int pathRow = row + rowStep;
            int pathCol = col + colStep;
            while (pathRow != moveRow || pathCol != moveCol) {
                Piece pathPiece = board.getPiece(new int[]{pathRow, pathCol});
                if (!pathPiece.getColor().equals("")) {
                    // Check if the obstacle is at the destination and is an opponent's piece
                    if (pathRow == moveRow && pathCol == moveCol && !pathPiece.getColor().equals(this.getColor())) {
                        return true;
                    }
                    return false;
                }
                pathRow += rowStep;
                pathCol += colStep;
            }

            return true;
        }

        return false;
    }
}
