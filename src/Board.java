/**
 * Author: Alejandro Quiroga
 */
public class Board {

    Piece[][] board = new Piece[8][8];
    protected Piece[][] nextMove;
    protected int playerTurn;
    public boolean successMove;

    /**
     * Initializes the matrix of Piece
     */
    public Board() {
        playerTurn = 1;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                board[i][j] = new Piece();
            }
        }
    }

    /**
     * @param i coordinate in i
     * @param j coordinate in j
     * @return the color of the piece selected.
     */
    public int getPieceColor(int i, int j){ return board[i][j].getColor(); }

    /**
     * Changes the turn of the current player.
     */
    public void nextTurn() {
        if(playerTurn == 1) { playerTurn = 2; }
        else { playerTurn = 1; }
    }

    /**
     * @return playerTurn
     */
    public int getPlayerTurn() { return playerTurn; }

    /**
     * Sets the pieces on the board.
     */
    public void initiateBoard() {

        for(int x = 0, i = 0; i < 2; i++, x = 7) {
            board[x][0] = new Rock();
            board[x][1] = new Knight();
            board[x][2] = new Bishop();
            board[x][3] = new Queen();
            board[x][4] = new King();
            board[x][5] = new Bishop();
            board[x][6] = new Knight();
            board[x][7] = new Rock();
        }

        for(int i = 0; i < 8; i++) {
            board[1][i] = new Pawn();
            board[6][i] = new Pawn();

            board[0][i].setColor(2);
            board[1][i].setColor(2);
            board[6][i].setColor(1);
            board[7][i].setColor(1);
        }
    }

    /**
     * Prints the main board.
     */
    public void printBoard(){
        System.out.print("-+--+--+--+--+--+--+--+--+");
        for(int i = 0; i < 8; i++) {
            System.out.print("\n" + i + "|");
            for(int j = 0; j < 8; j++) {
                System.out.print(board[i][j].pieceConvert() + board[i][j].getName() + "|");
            }
            System.out.print("\n-+--+--+--+--+--+--+--+--+");
        }
        System.out.print("\n |0 |1 |2 |3 |4 |5 |6 |7 |\n\n");

    }

    /**
     * Gets the move from pieceSelector and prints the subBoard of the game with the possible moves.
     *
     * @param i1 coordinate in "i".
     * @param j1 coordinate in "j".
     */
    public void showMove(int i1, int j1){

        nextMove = board[i1][j1].move(board, i1, j1);
        System.out.print("-+--+--+--+--+--+--+--+--+");
        for(int i = 0; i < 8; i++) {
            System.out.print("\n" + i + "|");
            for(int j = 0; j < 8; j++) {
                System.out.print(nextMove[i][j].pieceConvert() + nextMove[i][j].getName() + "|");
            }
            System.out.print("\n-+--+--+--+--+--+--+--+--+");
        }
        System.out.print("\n |0 |1 |2 |3 |4 |5 |6 |7 |\n\n");
    }

    /**
     * Makes the move from the possible moves from subBoard.
     *
     * @param i1 coordinate in "i".
     * @param j1 coordinate in "j".
     */
    public boolean performMove(int i1, int j1){

        if(nextMove[i1][j1].getColor() == 3) {
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++){
                    if(nextMove[i][j].getColor() == 4){

                        board[i1][j1] = board[i][j];
                        board[i][j] = new Piece();

                        board[i1][j1].setHasMoved(true);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}