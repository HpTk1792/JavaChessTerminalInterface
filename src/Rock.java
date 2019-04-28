public class Rock extends Piece {

    Rock(){ name = "R"; }

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

            //Loop for up Vertical side
            for (int i = i1; i > 0; i--) {
                if (subBoard[i - 1][j1].getColor() == 1) {
                    break;

                }else if (subBoard[i - 1][j1].getColor() == 2){
                    subBoard[i - 1][j1].setColor(3);
                    break;

                }else{
                    subBoard[i - 1][j1].setColor(3);
                }
            }

            //Loop for down Horizontal side
            for (int i = i1; i < 7; i++){
                if (subBoard[i + 1][j1].getColor() == 1) {
                    break;

                }else if (subBoard[i + 1][j1].getColor() == 2){
                    subBoard[i + 1][j1].setColor(3);
                    break;

                }else{
                    subBoard[i + 1][j1].setColor(3);
                }

            }

            // Loop for  right Horizontal side
            for (int j = j1; j < 7; j++) {
                if (subBoard[i1][j+1].getColor() == 1) {
                    break;
                } else if (subBoard[i1][j+1].getColor() == 2){
                    subBoard[i1][j + 1].setColor(3);
                    break;
                }
                else{
                    subBoard[i1][j + 1].setColor(3);
                }

            }
            // Loop for left  Horizontal side
            for (int j = j1; j > 0; j--){

                if (subBoard[i1][j-1].getColor() == 1) {
                    break;
                } else if (subBoard[i1][j-1].getColor() == 2){
                    subBoard[i1][j - 1].setColor(3);
                    break;
                }
                else{
                    subBoard[i1][j - 1].setColor(3);
                }

            }

        }

        // Black Piece Behavior
        else if(board[i1][j1].getColor() == 2) {

            //Loop for down Vertical side
            for (int i = i1; i < 7; i++) {
                if (subBoard[i + 1][j1].getColor() == 2) {
                    break;

                }else if (subBoard[i + 1][j1].getColor() == 1){
                    subBoard[i + 1][j1].setColor(3);
                    break;

                }else{
                    subBoard[i + 1][j1].setColor(3);
                }


            }

            //Loop for up Vertical side

            for (int i = i1; i > 0; i--){
                // subBoard[i - 1][j1].setColor(3);
                if (subBoard[i - 1][j1].getColor() == 2) {
                    break;

                }else if (subBoard[i - 1][j1].getColor() == 1){
                    subBoard[i - 1][j1].setColor(3);
                    break;

                }else{
                    subBoard[i - 1][j1].setColor(3);
                }

            }

            //Loop for right Horizontal side
            for (int j = j1; j < 7; j++) {
                if (subBoard[i1][j+1].getColor() == 2) {
                    break;
                } else if (subBoard[i1][j+1].getColor() == 1){
                    subBoard[i1][j + 1].setColor(3);
                    break;
                }
                else{
                    subBoard[i1][j + 1].setColor(3);
                }
            }

            //Loop for left Horizontal side
            for (int j = j1; j > 0; j--) {
                if (subBoard[i1][j-1].getColor() == 2) {
                    break;
                } else if (subBoard[i1][j-1].getColor() == 1){
                    subBoard[i1][j - 1].setColor(3);
                    break;
                }
                else{
                    subBoard[i1][j - 1].setColor(3);
                }
            }
        }

        // Changing the color to 4 in order to change the "O" or "X" to "!".
        subBoard[i1][j1].setColor(4);

        return subBoard;
    }
}
