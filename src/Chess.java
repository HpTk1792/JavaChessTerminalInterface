/**
 * Authors: Isha Noor, Maite Navarro, Alejandro Quiroga
 *
 * Chess main
 *
 * Contains the main method of the program.
 * It processes all the movements
 *
 * There is no check mate so the program will end when one player inputs "END".
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Chess {

    static BufferedReader br = new BufferedReader( new InputStreamReader ( System.in ));
    static int i;
    static int j;
    static boolean endGame;

    /**
     * It processes all the inputs and makes sure the entry of the data is correct.
     *
     * @throws IOException for the BufferedReader
     */
    public static boolean checkPiece() throws IOException {

        int coordinates;
        String input = null;
        while(input == null || input.length() != 2) {
            input = br.readLine();
            if(input.equals("END")) { return true; }
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
        return false;
    }

    public static void  main(String Args[]) throws IOException {

        Board board = new Board();

        board.initiateBoard();
        board.printBoard();

        endGame = false;

        while(!endGame){
            System.out.println("Turno " + board.getPlayerTurn());
            endGame = checkPiece();
            while(!endGame && !board.successMove) {
                while (!endGame && board.getPieceColor(i, j) != board.getPlayerTurn()) {
                    System.out.println("You have to select a correct piece.");
                    endGame = checkPiece();
                }
                if(endGame) { break; }
                board.showMove(i, j);
                endGame = checkPiece();
                if(endGame) { break; }
                board.successMove = board.performMove(i, j);
                if(!board.successMove) {
                    System.out.println("Wrong move, please select the piece you want to move.");
                    endGame = checkPiece();
                }
            }
            if(!endGame) { board.printBoard(); }
            board.nextTurn();
            board.successMove = false;
        }
    }
}
