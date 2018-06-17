package chessPieceClasses;
import javax.swing.*;
import java.util.Arrays;

public abstract class ChessPiece {
	protected boolean isWhite;
	private Icon picture;
    protected int[] pos;

    public ChessPiece(boolean white) {
        isWhite = white;
        pos = new int[3];
    }
        
	public Icon getIcon(){
	    return picture;
	}
        
	public int[] getPosition(){
	    return pos;
	}
	
    public void setIcon(Icon yeet) {
        picture = yeet;
    }
    
    public boolean isWhite() {
        return isWhite;
    }
    //Sets position of chess piece
    public void setPosition(int a, int b, int c) {
        pos[0] = a;
        pos[1] = b;
        pos[2] = c;
    }
    
    public void setPosition(int[] positions){
    	pos = Arrays.copyOf(positions, 3);
    }
    
	//For use with empty chess pieces
	public boolean isEmpty() {
		return false;
	}
	
	/**
	 * Checks if move for chesspiece is valid, then moves chesspiece and captures if necessary.
	 * @return true if move is successful, false if invalid move
	 */
	public boolean move(ChessPiece c){
		if(c.pos.equals(this.pos)){
            return false;
        }
        
        if(!c.isEmpty() && c.isWhite() == this.isWhite()){
    		return false;
    	}
        return true;
	}
}
