/**
 * Author: Maite Navarro
 */
public class Knight extends Piece {
    Knight(){ name = "N"; }

    public Piece[][] move(Piece[][] board, int i1, int j1) {

        //DECLARING SUB_BOARD AND COPYING THE BOARD
        copyBoard(board);

        // POSIBLES MOVIMIENTOS DE LA PIEZA
        boolean arribaIzq = i1 - 1 >= 0 && i1 - 1 <= 7 && j1 - 2 >= 0 && j1 - 2 <= 7;
        boolean arriba2Izq = i1 - 2 >= 0 && i1 - 2 <= 7 && j1 - 1 >= 0 && j1 - 1 <= 7;
        boolean abajoIzq = i1 + 1 >= 0 && i1 + 1 <= 7 && j1 - 2 >= 0 && j1 - 2 <= 7;
        boolean abajo2Izq = i1 + 2 >= 0 && i1 + 2 <= 7 && j1 - 1 >= 0 && j1 - 1 <= 7;
        boolean abajoDer = i1 + 1 >= 0 && i1 + 2 <= 7 && j1 + 1 >= 0 && j1 + 1 <= 7;
        boolean abajo2Der = i1 + 1 >= 0 && i1 + 1 <= 7 && j1 + 2 >= 0 && j1 + 2 <= 7;
        boolean arribaDer = i1 - 1 >= 0 && i1 - 1 <= 7 && j1 + 2 >= 0 && j1 + 2 <= 7;
        boolean arriba2Der = i1 - 2 >= 0 && i1 - 2 <= 7 && j1 + 1 >= 0 && j1 + 1 <= 7;

        if (arribaIzq && subBoard[i1 - 1][j1 - 2].getColor() != board[i1][j1].getColor() ) {
            subBoard[i1 - 1][j1 - 2].setColor(3);
        }

        if  (abajoIzq && subBoard[i1 + 1][j1 - 2].getColor() != board[i1][j1].getColor() ) {
            subBoard[i1 + 1][j1 - 2].setColor(3);
        }

        if  (abajo2Izq && subBoard[i1 + 2][j1 - 1].getColor() != board[i1][j1].getColor() ){
            subBoard[i1 + 2][j1 - 1].setColor(3);
        }

        if  (abajoDer && subBoard[i1 + 2][j1 + 1].getColor() != board[i1][j1].getColor() ){
            subBoard[i1 + 2][j1 + 1].setColor(3);
        }

        if (abajo2Der && subBoard[i1 + 1][j1 + 2].getColor() != board[i1][j1].getColor() ){
            subBoard[i1 + 1][j1 + 2].setColor(3);
        }

        if (arribaDer && subBoard[i1 - 1][j1 + 2].getColor() != board[i1][j1].getColor() ) {
            subBoard[i1 - 1][j1 + 2].setColor(3);
        }

        if  (arriba2Der && subBoard[i1 - 2][j1 + 1].getColor() != board[i1][j1].getColor() ){
            subBoard[i1 - 2][j1 + 1].setColor(3);
        }

        if (arriba2Izq && subBoard[i1 - 2][j1 - 1].getColor() != board[i1][j1].getColor() ) {
            subBoard[i1 - 2][j1 - 1].setColor(3);
        }

        subBoard[i1][j1].setColor(4);
        return subBoard;
    }
}

