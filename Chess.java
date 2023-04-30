import java.util.Scanner;

public class Chess {
    public static void main(String[] args){
        chessboard bChessboard = new chessboard();
//        bChessboard.printBoard();
        Scanner input = new Scanner(System.in);

        // TODO implement testing
        while(true)
        {
            bChessboard.printBoard();
            System.out.println("Enter STOP to stop ");
            System.out.println("Enter whites move to : " );
            String[] data = input.nextLine().split(" "); // example is b4
            if(data[0].equals("STOP"))
            {
                break;
            }
            String from = data[0];
            String to = data[1];
            bChessboard.move(from, to);

        }
        // bChessboard.printBoard();
    }
}
