/**
 * Author: Alejandro Quiroga
 */
public class King extends Piece {

    King(){ name = "K"; }

    public Piece[][] move(Piece[][] board, int i1, int j1){

        //DECLARING SUB_BOARD AND COPYING THE BOARD
        copyBoard(board);

        boolean isTop, isBottom, isLeft, isRight;

        //Checking if the piece is in a border
        isTop = i1 == 0;
        isBottom = i1 == 7;
        isLeft = j1 == 0;
        isRight = j1 == 7;

        //Posible moves of the piece
        if(!isTop && !isLeft) {
            if(board[i1][j1].getColor() != board[i1 - 1][j1 - 1].getColor()) { subBoard[i1 - 1][j1 - 1].setColor(3); }
        }
        if(!isTop) {
            if(board[i1][j1].getColor() != board[i1 - 1][j1].getColor()) { subBoard[i1 - 1][j1].setColor(3); }
        }
        if(!isTop && !isRight) {
            if(board[i1][j1].getColor() != board[i1 - 1][j1 + 1].getColor()) { subBoard[i1 - 1][j1 + 1].setColor(3); }
        }
        if(!isLeft){
            if(board[i1][j1].getColor() != board[i1][j1 - 1].getColor()) { subBoard[i1][j1 - 1].setColor(3); }
        }
        if(!isRight){
            if(board[i1][j1].getColor() != board[i1][j1 + 1].getColor()) { subBoard[i1][j1 + 1].setColor(3); }
        }
        if(!isBottom && !isLeft){
            if(board[i1][j1].getColor() != board[i1 + 1][j1 - 1].getColor()) { subBoard[i1 + 1][j1 - 1].setColor(3); }
        }
        if(!isBottom) {
            if(board[i1][j1].getColor() != board[i1 + 1][j1].getColor()) { subBoard[i1 + 1][j1].setColor(3); }
        }
        if(!isBottom && !isRight) {
            if(board[i1][j1].getColor() != board[i1 + 1][j1 + 1].getColor()) { subBoard[i1 + 1][j1 + 1].setColor(3); }
        }

        subBoard[i1][j1].setColor(4);

        return subBoard;
    }
}
