/**
 * Chess main
 *
 * Processess the game, incompleted.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chess {

    static BufferedReader br = new BufferedReader( new InputStreamReader ( System.in ));
    static int i;
    static int j;

    public static void checkPiece() throws IOException {

        int coordinates;
        String input = null;
        while(input == null || input.length() != 2) {
            input = br.readLine();
            if(input == null || input.length() != 2) {
                System.out.println("You have to input 2 valid numbers \"0 - 1 - 2 - 3 - 4 - 5 - 6 - 7\" without spaces neither jumplines");
            }
            if(input.length() == 2){
                try{
                    coordinates = Math.abs(Integer.parseInt(input));
                    i = coordinates / 10;
                    j = coordinates % 10;
                    if( i > 7 || j > 7){
                        throw new Exception();
                    }
                }
                catch(Exception e){
                    input = null;
                    System.out.println("You have to input 2 valid numbers \"0 - 1 - 2 - 3 - 4 - 5 - 6 - 7\"");
                }
            }
        }
    }

    public static void  main(String Args[]) throws IOException {

        Board board = new Board();


        board.initiateBoard();
        board.printBoard();

        while(true){
            System.out.println("Turno " + board.getPlayerTurn());
            checkPiece();
            while(!board.successMove) {
                while (board.getPieceColor(i, j) != board.getPlayerTurn()) {
                    checkPiece();
                }
                board.showMove(i, j);
                checkPiece();
                board.successMove = board.performMove(i, j);
            }
            board.printBoard();
            board.nextTurn();
            board.successMove = false;
        }
    }
}
