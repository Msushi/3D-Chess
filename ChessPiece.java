import javax.swing.*;
import java.awt.*;

public abstract class ChessPiece {
	protected Color teamColor;
	private Icon picture;
        private String name;
        protected int[] pos;
	
        public ChessPiece(Icon pic, Color color, String str) {
            picture = pic;
            teamColor = color;
            name = str;
            pos = new int[3];
        }
        
	public Icon getIcon(){
		return picture;
	}
        
        public void setPosition(int a, int b, int c)
        {
            pos[0] = a;
            pos[1] = b;
            pos[2] = c;
        }
	
	/**
	 * Checks if move for chesspiece is valid, then moves chesspiece and captures if necessary.
	 * @return true if move is successful, false if invalid move
	 */
	public abstract boolean move(ChessPiece position);
}