package chessPieceClasses;
import javax.swing.*;

/**
 *
 * @author mlyons1388
 */
public class Knight extends ChessPiece{

    public Knight(boolean white){
       super(white);
       if (white)
           setIcon(new ImageIcon("Chess_Piece_Icons/WhiteKnight.jpg"));
       else
           setIcon(new ImageIcon("Chess_Piece_Icons/BlackKnight.jpg"));
    }

    public boolean move(ChessPiece c){
    	if(!super.move(c)){
    		return false;
    	}
        
        if(Math.abs(this.pos[0] - c.pos[0]) == 2){ 
            if(this.pos[1] - c.pos[1] == 0 && Math.abs(this.pos[2] - c.pos[2]) == 1){
                return moveThatPiece(c);
            }
            if(this.pos[2] - c.pos[2] == 0 && Math.abs(this.pos[1] - c.pos[1]) == 1){
                return moveThatPiece(c);
            }
            return false;
        }
        else if(Math.abs(this.pos[1] - c.pos[1]) == 2){
            if(this.pos[0] - c.pos[0] == 0 && Math.abs(this.pos[2] - c.pos[2]) == 1){
                return moveThatPiece(c);
            }
            if(this.pos[2] - c.pos[2] == 0 && Math.abs(this.pos[0] - c.pos[0]) == 1){
                return moveThatPiece(c);
            }
            return false;
        }
        else if(Math.abs(this.pos[2] - c.pos[2]) == 2){
            if(this.pos[1] - c.pos[1] == 0 && Math.abs(this.pos[0] - c.pos[0]) == 1){
                return moveThatPiece(c);
            }
            if(this.pos[0] - c.pos[0] == 0 && Math.abs(this.pos[1] - c.pos[1]) == 1){
                return moveThatPiece(c);
            }
            return false;
        }
        else{
          return false;
        }
    }
    
    private boolean moveThatPiece(ChessPiece c){
        //Updates position
        this.pos[0] = c.pos[0];
        this.pos[1] = c.pos[1];
        this.pos[2] = c.pos[2];
        return true;
    }
}
