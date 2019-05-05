/**
 * Author: Alejandro Quiroga
 */
public class Piece {

    protected int color;
    protected String name;
    protected boolean hasMoved;
    protected Piece[][] subBoard;

    Piece(){ name = " "; }

    /**
     * getters and setters.
     */
    public void setColor(int color){ this.color = color; }

    public int getColor(){ return color; }

    public String getName(){ return name; }

    public void setHasMoved(boolean bool) { hasMoved = bool; }

    public boolean getHasMoved() { return hasMoved; }

    /**
     * @return String in order to print the correspondent information to the player.
     */
    public String pieceConvert(){
        if(color == 0) { return " "; }
        else if(color == 1) { return "O"; }
        else if(color == 2) { return "X"; }
        else if(color == 3) { return "*"; }
        else { return "!"; }
    }

    /**
     * Copying the board to the subBoard.
     *
     * @param board the main board.
     */
    public void copyBoard(Piece[][] board){
        subBoard = new Piece[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                whichPiece(board, i, j);
                subBoard[i][j].setColor(board[i][j].getColor());
            }
        }
    }

    /**
     * Creates the correct instance of every piece in subBoard.
     * @param board the main board.
     * @param i coordinate.
     * @param j coordinate.
     */
    public void whichPiece(Piece[][] board, int i, int j){

        if(board[i][j] instanceof Pawn) { subBoard[i][j] = new Pawn(); }
        else if(board[i][j] instanceof Rock) { subBoard[i][j] = new Rock(); }
        else if(board[i][j] instanceof Knight) { subBoard[i][j] = new Knight(); }
        else if(board[i][j] instanceof Bishop) { subBoard[i][j] = new Bishop(); }
        else if(board[i][j] instanceof Queen) { subBoard[i][j] = new Queen(); }
        else if(board[i][j] instanceof King) { subBoard[i][j] = new King(); }
        else{ subBoard[i][j] = new Piece(); }

    }

    /**
     * No move in case of selecting a void piece.
     * @param board the main board.
     * @param i coordinate.
     * @param j coordinate.
     * @return the main board without changes.
     */
    public Piece[][] move(Piece[][] board, int i, int j){
        return board;
    }
}