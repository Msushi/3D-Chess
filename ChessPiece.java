import javax.swing.*;
import java.awt.*;

public abstract class ChessPiece {
	protected boolean isWhite;
	private Icon picture;
        private String name;
        protected int[] pos;
	
        public ChessPiece(boolean white, String str) {
            isWhite = white;
            name = str;
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
	//Sets position of chess piece
        public void setPosition(int a, int b, int c) {
            pos[0] = a;
            pos[1] = b;
            pos[2] = c;
        }
	//For use with empty chess pieces
	public boolean isEmpty() {
		return false;
	}
	
	/**
	 * Checks if move for chesspiece is valid, then moves chesspiece and captures if necessary.
	 * @return true if move is successful, false if invalid move
	 */
	public abstract boolean move(ChessPiece position);
}
