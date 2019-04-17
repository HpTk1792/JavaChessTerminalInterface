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

        int input = Integer.parseInt(br.readLine());
        i = input / 10;
        j = input % 10;
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
