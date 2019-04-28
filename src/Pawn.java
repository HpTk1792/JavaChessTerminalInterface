
public class Pawn extends Piece {

    public Pawn(int color, String name) {
        super(color, name);
    }

    public static Piece[][] move(Piece[][] board, int i1, int j1) {

        //DECLARING SUB_BOARD AND COPYING THE BOARD
        Piece[][] subBoard = new Piece[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                subBoard[i][j] = new Piece();
                subBoard[i][j].setName(board[i][j].getName());
                subBoard[i][j].setColor(board[i][j].getColor());
            }
        }

        // PIECE BEHAVIOR!
/*
        int black = --1;
        int white = -1;
        int var = 0;
        int black2 = --2;
        int white2 = -2;
        int var2 = 0;

        if(board[i1][j1].getColor() == 1){
            var = white;
            var2 = white2;

        } else if(board[i1][j1].getColor() == 2){
            var = black;
            var2 = black2;
        }


        if (subBoard[i1+var][j1].getColor()!=board[i1][j1].getColor()){
            subBoard[i1+var][j1].setColor(3);
            if (!board[i1][j1].getHasMoved() && subBoard[i1+var2][j1].getColor()==0) {
                subBoard[i1+var2][j1].setColor(3);
            }
        }

        if (j1 - 1 >= 0) {
            if (subBoard[i1 - 1][j1 - 1].getColor() == 2) {
                subBoard[i1 - 1][j1 - 1].setColor(3);
            }
        }
        if (j1 + 1 < 8) {
            if (subBoard[i1 - 1][j1 + 1].getColor() == 2) {
                subBoard[i1 - 1][j1 + 1].setColor(3);
            }
        }
*/



        if (board[i1][j1].getColor() == 1) {
            if (subBoard[i1 - 1][j1].getColor()==0){
                subBoard[i1 - 1][j1].setColor(3);
                if (!board[i1][j1].getHasMoved() && subBoard[i1 - 2][j1].getColor()==0) {
                    subBoard[i1 - 2][j1].setColor(3);
                }
            }

            if (j1 - 1 >= 0) {
                if (subBoard[i1 - 1][j1 - 1].getColor() == 2) {
                    subBoard[i1 - 1][j1 - 1].setColor(3);
                }
            }
            if (j1 + 1 < 8) {
                if (subBoard[i1 - 1][j1 + 1].getColor() == 2) {
                    subBoard[i1 - 1][j1 + 1].setColor(3);
                }
            }


        } else if (board[i1][j1].getColor() == 2) {
            if (subBoard[i1 + 1][j1].getColor()==0){
                subBoard[i1 + 1][j1].setColor(3);
                if (!board[i1][j1].getHasMoved() && subBoard[i1 + 2][j1].getColor()==0) {
                    subBoard[i1 + 2][j1].setColor(3);
                }
            }


            if (j1 - 1 >= 0) {
                if (subBoard[i1 + 1][j1 - 1].getColor() == 1) {
                    subBoard[i1 + 1][j1 - 1].setColor(3);
                }
            }
            if (j1 + 1 < 8) {
                if (subBoard[i1 + 1][j1 + 1].getColor() == 1) {
                    subBoard[i1 + 1][j1 + 1].setColor(3);
                }
            }

        }


        subBoard[i1][j1].setColor(4);

        return subBoard;
    }
}

