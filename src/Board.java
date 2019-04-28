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

        board[0][0].setName("R");
        board[0][1].setName("N");
        board[0][2].setName("B");
        board[0][3].setName("Q");
        board[0][4].setName("K");
        board[0][5].setName("B");
        board[0][6].setName("N");
        board[0][7].setName("R");

        for(int i = 0; i < 8; i++) {
            board[1][i].setName("P");
            board[6][i].setName("P");
        }

        board[7][0].setName("R");
        board[7][1].setName("N");
        board[7][2].setName("B");
        board[7][3].setName("Q");
        board[7][4].setName("K");
        board[7][5].setName("B");
        board[7][6].setName("N");
        board[7][7].setName("R");

        for(int i = 0; i < 8; i++) {
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
                System.out.print(board[i][j].pc() + board[i][j].getName() + "|");
            }
            System.out.print("\n-+--+--+--+--+--+--+--+--+");
        }
        System.out.print("\n |0 |1 |2 |3 |4 |5 |6 |7 |\n\n");

    }


    /**
     * Gets the move from pieceSelector and prints the subBoard of the game with the possible moves.
     *
     * @param i1 coordinate in "i"
     * @param j1 coordinate in "j"
     */
    public void showMove(int i1, int j1){

        nextMove = pieceSelector(i1, j1);
        System.out.print("-+--+--+--+--+--+--+--+--+");
        for(int i = 0; i < 8; i++) {
            System.out.print("\n" + i + "|");
            for(int j = 0; j < 8; j++) {
                System.out.print(nextMove[i][j].pc() + nextMove[i][j].getName() + "|");
            }
            System.out.print("\n-+--+--+--+--+--+--+--+--+");
        }
        System.out.print("\n |0 |1 |2 |3 |4 |5 |6 |7 |\n\n");
    }

    /**
     * Makes the move from the possible moves from subBoard.
     *
     * @param i1 coordinate in "i"
     * @param j1 coordinate in "j"
     */
    public boolean performMove(int i1, int j1){

        if(nextMove[i1][j1].getColor() == 3) {
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++){
                    if(nextMove[i][j].getColor() == 4){
                        board[i1][j1].setName(board[i][j].getName());
                        board[i1][j1].setColor(playerTurn);
                        board[i][j].setColor(0);
                        board[i][j].setName(" ");
                        board[i1][j1].setHasMoved(true);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Calls the current move method from the correspondent Piece
     *
     * @param i Coordenada en "i"
     * @param j Coordenada en "j"
     * @return the subBoard with the possible moves.
     */
    public Piece[][] pieceSelector(int i, int j) {

        String piece = board[i][j].getName();

        if(piece.equals("P")) { return Pawn.move(board, i, j); }
        // else if(piece.equals("R")) { return Rock.move(board, i, j); }
        else if(piece.equals("N")) { return Knight.move(board, i, j); }
        else if(piece.equals("B")) { return Bishop.move(board, i, j); }
        // else if(piece.equals("Q")) { return Queen.move(board, i, j); }
        // else if(piece.equals("K")) { return King.move(board, i, j); }
        else { return board ;}
    }

}




