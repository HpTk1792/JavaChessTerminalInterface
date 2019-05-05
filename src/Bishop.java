/**
 * Author: Maite Navarro
 */
public class Bishop extends Piece {
    Bishop(){ name = "B"; }
    public Piece[][] move(Piece[][] board, int i1, int j1) {

        //DECLARING SUB_BOARD AND COPYING THE BOARD
        copyBoard(board);

        // The movements are assigned to variables to be able to reuse the code for both players.
        int rivalColour = 0;
        int sumarI = -1;
        int restarI = 1;

        if(board[i1][j1].getColor() == 1){
            rivalColour = 2;

        } else if(board[i1][j1].getColor() == 2) {
            rivalColour = 1;
        }

        //go down to the right
        for (int i = i1, c = 1; i < 7 && j1 + c < 7; i++, c++) {
            if (subBoard[i - sumarI][j1 + c].getColor() == rivalColour) {
                subBoard[i - sumarI][j1 + c].setColor(3);
                break;
            } else if (subBoard[i - sumarI][j1 + c].getColor() == board[i1][j1].getColor()) {
                break;

            } else {
                subBoard[i - sumarI][j1 + c].setColor(3);
            }
        }

        //go down to the left
        for (int i = i1, ci = 1; i < 7 && j1 - ci >= 0; i++, ci++) {
            if (subBoard[i - sumarI][j1 - ci].getColor() == rivalColour) {
                subBoard[i - sumarI][j1 - ci].setColor(3);
                break;
            } else if (subBoard[i -sumarI][j1 - ci].getColor() == board[i1][j1].getColor()) {
                break;

            } else {
                subBoard[i -sumarI][j1 - ci].setColor(3);
            }

        }

        //go up to the right
        for (int i = i1, ci = 1; i > 0 && j1 - ci >= 0; i--, ci++) {
            if (subBoard[i - restarI][j1 - ci].getColor() == rivalColour) {
                subBoard[i - restarI][j1 - ci].setColor(3);
                break;
            } else if (subBoard[i - restarI][j1 - ci].getColor() == board[i1][j1].getColor()) {
                break;

            } else {
                subBoard[i - restarI][j1 - ci].setColor(3);
            }

        }

        //go up to the left
        for (int i = i1, c = 1; i > 0 && j1 + c < 8; i--, c++) {
            if (subBoard[i - restarI][j1 + c].getColor() == rivalColour) {
                subBoard[i - restarI][j1 + c].setColor(3);
                break;
            } else if (subBoard[i - restarI][j1 + c].getColor() == board[i1][j1].getColor()) {
                break;

            } else {
                subBoard[i - restarI][j1 + c].setColor(3);
            }
        }

        subBoard[i1][j1].setColor(4);
        return subBoard;
    }
}
