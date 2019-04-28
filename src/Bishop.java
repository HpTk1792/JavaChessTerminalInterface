
public class Bishop extends Piece {

    public Bishop(int color, String name) {
        super(color, name);
    }

    public static Piece[][] move(Piece[][] board, int i1, int j1) {

        //DECLARING SUB_BOARD
        Piece[][] subBoard = new Piece[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                subBoard[i][j] = new Piece();
                subBoard[i][j].setName(board[i][j].getName());
                subBoard[i][j].setColor(board[i][j].getColor());
            }
        }


        // COMPORTAMIENTO DE LA PIEZA

        //turno NEGRAS

        if(board[i1][j1].getColor() == 2) {


            for (int i = i1, c = 1; i < 8 && j1 + c < 8; i++, c++) {
                if (subBoard[i + 1][j1 + c].getColor() == 1) {
                    subBoard[i + 1][j1 + c].setColor(3);
                    break;
                } else if (subBoard[i + 1][j1 + c].getColor() == 2) {
                    break;

                } else {
                    subBoard[i + 1][j1 + c].setColor(3);
                }
            }

            for (int i = i1, ci = 1; i < 8 && j1 - ci >= 0; i++, ci++) {
                if (subBoard[i + 1][j1 - ci].getColor() == 1) {
                    subBoard[i + 1][j1 - ci].setColor(3);
                    break;
                } else if (subBoard[i + 1][j1 - ci].getColor() == 2) {
                    break;

                } else {
                    subBoard[i + 1][j1 - ci].setColor(3);
                }

            }

            for (int i = i1, ci = 1; i > 0 && j1 - ci >= 0; i--, ci++) {
                if (subBoard[i - 1][j1 - ci].getColor() == 1) {
                    subBoard[i - 1][j1 - ci].setColor(3);
                    break;
                } else if (subBoard[i - 1][j1 - ci].getColor() == 2) {
                    break;

                } else {
                    subBoard[i - 1][j1 - ci].setColor(3);
                }

            }

            for (int i = i1, c = 1; i > 0 && j1 + c < 8; i--, c++) {
                if (subBoard[i - 1][j1 + c].getColor() == 1) {
                    subBoard[i - 1][j1 + c].setColor(3);
                    break;
                } else if (subBoard[i - 1][j1 + c].getColor() == 2) {
                    break;

                } else {
                    subBoard[i - 1][j1 + c].setColor(3);
                }
            }
        }
        else {
            //turno blancas

            for (int i = i1, ci = 1; i > 0 && j1 - ci >= 0; i--, ci++) {
                if (subBoard[i - 1][j1 - ci].getColor() == 2) {
                    subBoard[i - 1][j1 - ci].setColor(3);
                    break;
                } else if (subBoard[i - 1][j1 - ci].getColor() == 1) {
                    break;

                } else {
                    subBoard[i - 1][j1 - ci].setColor(3);
                }

            }

            for (int i = i1, c = 1; i > 0 && j1 + c < 8; i--, c++) {
                if (subBoard[i - 1][j1 + c].getColor() == 2) {
                    subBoard[i - 1][j1 + c].setColor(3);
                    break;
                } else if (subBoard[i - 1][j1 + c].getColor() == 1) {
                    break;

                } else {
                    subBoard[i - 1][j1 + c].setColor(3);
                }
            }

            for (int i = i1, c = 1; i < 7 && j1 + c < 8; i++, c++) {
                if (subBoard[i + 1][j1 + c].getColor() == 2) {
                    subBoard[i + 1][j1 + c].setColor(3);
                    break;
                } else if (subBoard[i + 1][j1 + c].getColor() == 1) {
                    break;

                } else {
                    subBoard[i + 1][j1 + c].setColor(3);
                }
            }

            for (int i = i1, ci = 1; i < 7 && j1 - ci >= 0; i++, ci++) {
                if (subBoard[i + 1][j1 - ci].getColor() == 2) {
                    subBoard[i + 1][j1 - ci].setColor(3);
                    break;
                } else if (subBoard[i + 1][j1 - ci].getColor() == 1) {
                    break;

                } else {
                    subBoard[i + 1][j1 - ci].setColor(3);
                }

            }
        }
        subBoard[i1][j1].setColor(4);
        return subBoard;
    }
}

