public class Pawn extends Piece{
    chessboard board;
    public Pawn(int[] position, String color, chessboard board)
    {
        super(position, color, "Pawn");
        this.board = board;
    }

    @Override
    public boolean move(int[] position)
    {

        if(basicCheck(position, board) == false)
        {
            System.out.println("failed basic test");
            return false;
        }


        System.out.println("we did a pawn move");

        //if its too far left/right, pawn can move 1 left-up or 1 right-up, no more on either diagonal
        if(Math.abs(moveCol - col) > 1)
        {
            System.out.println("Failed column test");
            return false;
        }

        // TODO enpassant

        //if you didnt move yet, you are allowed to move two up, white case
        System.out.println("Move size is " + moves.size());
        System.out.println("Move row is " + moveRow);
        System.out.println("Move col is " + moveCol);
        System.out.println("Our row is " + row);
        System.out.println("Our col is " + col);

        if(moveRow == (row+2) && color.equals("W") && moves.size()==0)
        {
            return true;
        }
        //if you didnt move yet, you are allowed to move two up, black case
        if(moveRow == (row-2) && color.equals("B") && moves.size()==0)
        {
            return true;
        }

        System.out.println("we have passed the above, we cant move more than 2 up/down now");
        // if its too far up/down
        if(moveRow-row < 1 && (this.getColor().equals("B")))
        {
            return false;
        }
        if(moveRow-row > 1 && (this.getColor().equals("W")))
        {
            return false;
        }



        return true;
    }
}
