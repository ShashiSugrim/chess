public class Bishop extends Piece {
    chessboard board;

    public Bishop(int[] position, String color, chessboard board) {
        super(position, color, "Bishop");
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

        if (rowDifference != colDifference) {
            System.out.println("Failed diagonal test");
            return false;
        }

        int rowDirection = (moveRow - row) > 0 ? 1 : -1;
        int colDirection = (moveCol - col) > 0 ? 1 : -1;

        int tempRow = row + rowDirection;
        int tempCol = col + colDirection;

        //this is for making sure we have a clear path
        while (tempRow != moveRow && tempCol != moveCol) {
            if (!board.getPiece(new int[]{tempRow, tempCol}).getColor().equals("")) {
                System.out.println("Failed path test");
                return false;
            }
            tempRow += rowDirection;
            tempCol += colDirection;
        }

        return true;
    }
}
