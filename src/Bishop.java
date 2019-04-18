import java.lang.Math;

public class Bishop extends Piece{
    
    public Bishop(int color, String name) {super(color, name);}

    public static Piece[][] move(Piece[][] board, int i1, int j1){

        //DECLARING SUB_BOARD
        Piece[][] subBoard = new Piece[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                subBoard[i][j] = new Piece();
            }
        }

        //COPY BOARD
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                subBoard[i][j].setName(board[i][j].getName());
                subBoard[i][j].setColor(board[i][j].getColor());
            }
        }
        
        // COMPORTAMIENTO DE LA PIEZA
        
        if Math.abs(board[i1][i2])==Math.abs(board[j1]-[j2]) {
  

        }

       
        
    return subBoard;
    }
}

