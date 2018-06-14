import java.awt.*;
import javax.swing.*;
public class Pawn extends ChessPiece {
    
    private boolean isFirstMove;
    
    public Pawn(boolean white) {
       super(white, "Pawn");
       if (white)
           setIcon(new ImageIcon(Pawn.class.getResource("Chess Piece Icons/WhitePawn.jpg")));
       else
           setIcon(new ImageIcon(Pawn.class.getResource("Chess Piece Icons/BlackPawn.jpg")));
    }
    public boolean move(ChessPiece c) {
        //Checking if the move is valid when a pawn moves normally (forward)
        if (isWhite) {
            if (isFirstMove) { //On the first move, the pawn can move 2 spaces forward
                if (this.pos[0] == c.pos[0] && this.pos[2] == c.pos[2] && (this.pos[1] - c.pos[1] == 1 || this.pos[1] - c.pos[1] == 2)) {
                    this.pos = c.pos;
                    isFirstMove = false;
                    setPosition(c.pos[0], c.pos[1], c.pos[2]);
                    return true;
                }
            }
            else
                if (this.pos[0] == c.pos[0] && this.pos[2] == c.pos[2] && this.pos[1] - c.pos[1] == 1) {
                    setPosition(c.pos[0], c.pos[1], c.pos[2]);
                    return true;
                }
           
        }
        else {//if (this.isWhite == Color.BLACK) 
            if (isFirstMove) { //On the first move, the pawn can move 2 spaces forward
                if (this.pos[1] == c.pos[1] && this.pos[2] == c.pos[2] && this.pos[0] - c.pos[0] == 1 || this.pos[0] - c.pos[0] == 2) {
                    this.pos = c.pos;
                    isFirstMove = false;
                    return true;
                }
            }
            else
                if (this.pos[1] == c.pos[1] && this.pos[2] == c.pos[2] && this.pos[0] - c.pos[0] == 1)
                    return true;
             
        }
        //Checking for a valid two dimensional capture move
        if (this.isWhite == c.isWhite) {
            if (this.pos[2] == c.pos[2] && this.pos[0] == c.pos[0] - 1 && (this.pos[1] == c.pos[1] + 1 || this.pos[1] == c.pos[1] + 1))
                //Checking that the square has a piece that belongs to the opponent
                if (c != null && c.isWhite != this.isWhite) {
                    this.pos = c.pos;
                    c = null;
                    return true;
                }
        }
        else { //if  (this.isWhite == Color.BLACK); 
            //Checking for normal two dimensional capture
            if (this.pos[2] == c.pos[2] && this.pos[0] == c.pos[0] - 1 && (this.pos[1] == c.pos[1] - 1 || this.pos[1] == c.pos[1] + 1))
                //Checking that the square has a piece that belongs to the opponent
                if (c != null && c.isWhite != this.isWhite) {
                    this.pos = c.pos;
                    c = null;
                    return true;
                }
        }
        //Checking for a valid three dimensional capture move
         if (this.isWhite == c.isWhite) {
            if (this.pos[2] == c.pos[2] - 1 && this.pos[0] == c.pos[0] - 1 && (this.pos[1] == c.pos[1] + 1 || this.pos[1] == c.pos[1] + 1))
                //Checking that the square has a piece that belongs to the opponent
                if (c != null && c.isWhite != this.isWhite) {
                    this.pos = c.pos;
                    c = null;
                    return true;
                }
        }
        else { //if  (this.isWhite == Color.BLACK); 
            if (this.pos[2] == c.pos[2] - 1 && this.pos[0] == c.pos[0] - 1 && (this.pos[1] == c.pos[1] - 1 || this.pos[1] == c.pos[1] + 1))
                //Checking that the square has a piece that belongs to the opponent
                if (c != null && c.isWhite != this.isWhite) {
                    this.pos = c.pos;
                    c = null;
                    return true;
                }
        }
        return false;
        
            
        
    }
    
    
}
