public class Pawn extends Piece {

    Pawn(){ name = "P"; }

    public Piece[][] move(Piece[][] board, int i1, int j1){

        //DECLARING SUB_BOARD AND COPYING THE BOARD
        subBoard = new Piece[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                whichPiece(board, i, j);
                subBoard[i][j].setColor(board[i][j].getColor());
            }
        }

        // PIECE BEHAVIOR!
        // The movements are assigned to variables to be able to reuse the code for both players.

        int blackPlayer = -1;
        int white = 1;
        int movements = 0;

        int blackPlayer2 = -2;
        int white2 = 2;
        int movements2 = 0;

        int rivalColour = 0;

        //Assing variables for each colour
        if(board[i1][j1].getColor() == 1){
            movements = white;
            movements2 = white2;
            rivalColour = 2;

        } else if(board[i1][j1].getColor() == 2){
            movements = blackPlayer;
            movements2 = blackPlayer2;
            rivalColour = 1;
        }

        //go on
        if (subBoard[i1-movements][j1].getColor()==0){
            subBoard[i1-movements][j1].setColor(3);
            if (!board[i1][j1].getHasMoved() && subBoard[i1-movements2][j1].getColor()!=board[i1][j1].getColor()) {
                subBoard[i1-movements2][j1].setColor(3);
            }
        }
        //diagonal attack
        if (j1 - 1 >= 0) {
            if (subBoard[i1 - movements][j1 - 1].getColor() == rivalColour) {
                subBoard[i1 - movements][j1 - 1].setColor(3);
            }
        }
        if (j1 + 1 < 8) {
            if (subBoard[i1 - movements][j1 + 1].getColor() == rivalColour) {
                subBoard[i1 - movements][j1 + 1].setColor(3);
            }
        }
        subBoard[i1][j1].setColor(4);

        return subBoard;
    }
}