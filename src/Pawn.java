
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
        // Se asignan los movimientos a variables para poder reutilizar el código para ambos jugadores.

        int blackPlayer = -1;
        int white = 1;
        int movements = 0;

        int blackPlayer2 = -2;
        int white2 = 2;
        int movements2 = 0;

        int rivalColour = 0;

        //Se asignan variables a cada color-jugador
        if(board[i1][j1].getColor() == 1){
            movements = white;
            movements2 = white2;
            rivalColour = 2;

        } else if(board[i1][j1].getColor() == 2){
            movements = blackPlayer;
            movements2 = blackPlayer2;
            rivalColour = 1;
        }

        //avance peón
        if (subBoard[i1-movements][j1].getColor()!=board[i1][j1].getColor()){
            subBoard[i1-movements][j1].setColor(3);
            if (!board[i1][j1].getHasMoved() && subBoard[i1-movements2][j1].getColor()!=board[i1][j1].getColor()) {
                subBoard[i1-movements2][j1].setColor(3);
            }
        }
        //atacar ficha rival
        if (j1 - 1 >= 0) {
            if (subBoard[i1 - movements][j1 - movements].getColor() == rivalColour) {
                subBoard[i1 - movements][j1 - movements].setColor(3);
            }
        }
        if (j1 + 1 < 8) {
            if (subBoard[i1 - movements][j1 - movements].getColor() == rivalColour) {
                subBoard[i1 - movements][j1 - movements].setColor(3);
            }
        }
        subBoard[i1][j1].setColor(4);

        return subBoard;
    }
}

