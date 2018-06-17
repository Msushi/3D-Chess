package chessPieceClasses;
import javax.swing.*;
public class Queen extends ChessPiece{

    public Queen(boolean white){
       super(white);
       if (white)
           setIcon(new ImageIcon("Chess_Piece_Icons/WhiteQueen.jpg"));
       else
           setIcon(new ImageIcon("Chess_Piece_Icons/BlackQueen.jpg"));
    }

    public boolean move(ChessPiece c){
        //Checks if moving to original space
        
        if(!super.move(c)){
    		return false;
    	}
        
        ChessPiece testingRook = new Rook(isWhite());
        testingRook.setPosition(pos);
        
        ChessPiece testingBishop = new Bishop(isWhite());
        testingBishop.setPosition(pos);
        
        
        if(testingRook.move(c) || testingBishop.move(c)){
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
