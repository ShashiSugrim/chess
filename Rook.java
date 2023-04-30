public class Rook extends Piece {
    chessboard board;

    public Rook(int[] position, String color, chessboard board) {
        super(position, color, "Rook");
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

        if (rowDifference != 0 && colDifference != 0) {
            System.out.println("Failed straight line test");
            return false;
        }

        int rowDirection = 0;
        int colDirection = 0;

        if (rowDifference != 0) {
            rowDirection = (moveRow - row) > 0 ? 1 : -1;
        } else {
            colDirection = (moveCol - col) > 0 ? 1 : -1;
        }

        int tempRow = row + rowDirection;
        int tempCol = col + colDirection;

        while (tempRow != moveRow || tempCol != moveCol) {
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
