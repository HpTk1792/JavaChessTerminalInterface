public class Piece {

    protected int color;
    protected String name;
    protected boolean hasMoved;
    protected Piece[][] subBoard;

    Piece(){
        name = " ";
    }

    /**
     * getters and setters
     */
    public void setColor(int color){ this.color = color; }

    public int getColor(){ return color; }

    public String getName(){ return name; }

    public void setHasMoved(boolean bool) { hasMoved = bool; }

    public boolean getHasMoved() { return hasMoved; }

    //TODO refactor! pieceConvert
    /**
     * @return String in order to print the correspondent information to the player.
     */
    public String pc(){
        if(color == 0) { return " "; }
        else if(color == 1) { return "O"; }
        else if(color == 2) { return "X"; }
        else if(color == 3) { return "*"; }
        else { return "!"; }
    }

    public void whichPiece(Piece[][] board, int i, int j){

        if(board[i][j] instanceof Pawn) { subBoard[i][j] = new Pawn(); }
        else if(board[i][j] instanceof Rock) { subBoard[i][j] = new Rock(); }
        else if(board[i][j] instanceof Knight) { subBoard[i][j] = new Knight(); }
        else if(board[i][j] instanceof Bishop) { subBoard[i][j] = new Bishop(); }
        else if(board[i][j] instanceof Queen) { subBoard[i][j] = new Queen(); }
        else if(board[i][j] instanceof King) { subBoard[i][j] = new King(); }
        else{ subBoard[i][j] = new Piece(); }

    }

    public Piece[][] move(Piece[][] board, int i, int j){
        return board;
    }
}
