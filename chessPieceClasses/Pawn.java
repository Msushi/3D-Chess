package chessPieceClasses;
import javax.swing.*;

public class Pawn extends ChessPiece {
    
    private boolean isFirstMove;
    
    public Pawn(boolean white){
       super(white);
       if(white){
           setIcon(new ImageIcon("Chess_Piece_Icons/WhitePawn.jpg"));
       }
       else{
           setIcon(new ImageIcon("Chess_Piece_Icons/BlackPawn.jpg"));
       }
       isFirstMove = true;
    }
    
    public boolean move(ChessPiece c){
    	if(!super.move(c)){
    		return false;
    	}
    	
        //Checking if the move is valid when a pawn moves normally (forward)
    	if(c.isEmpty()){
	    	if(this.pos[0] == c.pos[0] && this.pos[2] == c.pos[2]){//Positions must be in the same column
	    		if(this.isWhite()){
	    			if(this.pos[1] - c.pos[1] == 1){
	    				return moveThatPiece(c);
	    			}
	    			else if(isFirstMove){
	    				if(this.pos[1] - c.pos[1] == 2){
	    					return moveThatPiece(c);
	    				}
	    			}
	    			else{
	    				return false;
	    			}
	    		}
	    		else{
	    			if(isFirstMove){
	    				if(this.pos[1] - c.pos[1] == -2){
	    					return moveThatPiece(c);
	    				}
	    			}
	    			if(this.pos[1] - c.pos[1] == -1){
	    				return moveThatPiece(c);
	    			}
	    			else{
	    				return false;
	    			}
	    		}
	    	}
	    	return false;
    	}
    	
    	//Checking if the move is valid when a pawn is capturing
    	else{
	    	if(Math.abs(this.pos[2] - c.pos[2]) <= 1){//Neighbouring or same floors
	    		if(c.isEmpty()){ //Must be a capture
	    			return false;
	    		}
	    		
	    		if(Math.abs(this.pos[0] - c.pos[0]) != 1){ //Must be on corner
	    			return false;
	    		}
	    		
	    		if(this.isWhite()){
	    			if(this.pos[1] == c.pos[1] + 1){ //Guarantees chesspiece is in front of pawn
	    				System.out.println("Mr. Clean");
	    				return moveThatPiece(c);
	    			}
	    		}
	    		else{
	    			if(this.pos[1] == c.pos[1] - 1){
	    				return moveThatPiece(c);
	    			}
	    		}
	    	}
	        
	        return false;
    	}
    }
    
    private boolean moveThatPiece(ChessPiece c){
        //Updates position
    	isFirstMove = false;
        this.pos[0] = c.pos[0];
        this.pos[1] = c.pos[1];
        this.pos[2] = c.pos[2];
        return true;
    }
}
