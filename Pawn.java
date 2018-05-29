import java.awt.*;
public class Pawn extends ChessPiece {
    
    private boolean isFirstMove;
    
    public Pawn(Color c) {
        super(c, pic, "Pawn");
        isFirstMove = true;
    }
    public boolean move(ChessPiece c) {
        //Checking if the move is valid when a pawn moves normally (forward)
        if (this.teamColor == Color.WHITE) {
            if (isFirstMove) { //On the first move, the pawn can move 2 spaces forward
                if (this.pos[1] == c.pos[1] && this.pos[2] == c.pos[2] && this.pos[0] - c.pos[0] == -1 || this.pos[0] - c.pos[0] == -2) {
                    this.pos = c.pos;
                    isFirstMove = false;
                    return true;
                }
            }
            else
                if (this.pos[1] == c.pos[1] && this.pos[2] == c.pos[2] && this.pos[0] - c.pos[0] == -1)
                    return true;
           
        }
        else {//if (this.teamColor == Color.BLACK) 
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
        //Checking for a valid capture move
        if (this.teamColor == Color.WHITE) {
            //Checking for normal two dimensional capture
            if (this.pos[2] == c.pos[2] && this.pos[0] == c.pos[0] - 1 && (this.pos[1] == c.pos[1] + 1 || this.pos[1] == c.pos[1] + 1))
                //Checking that the square has a piece that belongs to the opponent
                if (c != null && c.teamColor != this.teamColor) {
                    this.pos = c.pos;
                    c = null;
                    return true;
                }
        }
        else { //if  (this.teamColor == Color.BLACK); 
            //Checking for normal two dimensional capture
            if (this.pos[2] == c.pos[2] && this.pos[0] == c.pos[0] - 1 && (this.pos[1] == c.pos[1] - 1 || this.pos[1] == c.pos[1] + 1))
                //Checking that the square has a piece that belongs to the opponent
                if (c != null && c.teamColor != this.teamColor) {
                    this.pos = c.pos;
                    c = null;
                    return true;
                }
        }
            
        
    }
    
    
}
