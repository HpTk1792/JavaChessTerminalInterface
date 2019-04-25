public class Pawn extends Piece {

    Pawn(){ name = "P"; }

    public Piece[][] move(Piece[][] board, int i1, int j1){

        //DECLARING SUB_BOARD AND COPYING THE BOARD
        subBoard = new Piece[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                whichPiece(board, i, j);
                //subBoard[i][j] = new Piece();
                //subBoard[i][j].setName(board[i][j].getName());
                subBoard[i][j].setColor(board[i][j].getColor());
            }
        }

        // PIECE BEHAVIOR!
        if(board[i1][j1].getColor() == 1) {
            if(!board[i1][j1].getHasMoved()) { subBoard[i1-2][j1].setColor(3); }
            subBoard[i1-1][j1].setColor(3);
            if(subBoard[i1-1][j1-1].getColor() == 2) { subBoard[i1-1][j1-1].setColor(3); }
            if(subBoard[i1-1][j1+1].getColor() == 2) { subBoard[i1-1][j1+1].setColor(3); }
        }
        else if(board[i1][j1].getColor() == 2) {
            if (!board[i1][j1].getHasMoved()) { subBoard[i1+2][j1].setColor(3); }
            subBoard[i1+1][j1].setColor(3);
            if(subBoard[i1+1][j1-1].getColor() == 1) { subBoard[i1+1][j1-1].setColor(3); }
            if(subBoard[i1+1][j1+1].getColor() == 1) { subBoard[i1+1][j1+1].setColor(3); }
        }

        subBoard[i1][j1].setColor(4);

        return subBoard;
    }
}
