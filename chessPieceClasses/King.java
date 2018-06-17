package chessPieceClasses;

import javax.swing.*;
public class King extends ChessPiece {
  
    public King(boolean white) {
       super(white);
       if (white)
           setIcon(new ImageIcon("Chess_Piece_Icons/WhiteKing.jpg"));
       else
           setIcon(new ImageIcon("Chess_Piece_Icons/BlackKing.jpg"));
    }
  
    public boolean move (ChessPiece c) {
    	if(!super.move(c)){
    		return false;
    	}
    	
        if (Math.abs(this.pos[0] - c.pos[0]) <= 1 && Math.abs(this.pos[1] - c.pos[1]) <= 1 && Math.abs(this.pos[2] - c.pos[2]) <= 1) {
            return moveThatPiece(c);
        }
        return false;
    }
    
    private boolean moveThatPiece(ChessPiece c){
        //Updates position
        this.pos[0] = c.pos[0];
        this.pos[1] = c.pos[1];
        this.pos[2] = c.pos[2];
        return true;
    }
}
            
      
