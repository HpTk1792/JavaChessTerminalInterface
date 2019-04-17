public class Piece {

    protected int color;
    protected int isThreatened;
    protected String name;
    protected boolean hasMoved;

    public Piece(){
        name = " ";
    }

    /**
     * Sets the color (player owner) and the name of the Piece
     *
     * @param color El color de la pieza.
     * @param name El tipo de pieza.
     */
    public Piece(int color, String name){
        this.color = color;
        this.name = name;
    }

    /**
     * getters and setters
     */
    public void setColor(int color){ this.color = color; }

    public int getColor(){ return color; }

    public void setIsThreatened(int threat){ isThreatened = threat; }

    public int getIsThreatened(){ return isThreatened; }

    public void setName(String name){ this.name = name; }

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
}
