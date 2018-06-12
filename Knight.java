import javax.swing.*;
public class Knight extends ChessPiece{

    public Knight(boolean white){
        super(white, "King");
       if (white)
           setIcon(new ImageIcon(Knight.class.getResource("Chess Piece Icons/WhiteKnight.jpg")));
       else
           setIcon(new ImageIcon(Knight.class.getResource("Chess Piece Icons/BlackKnight.jpg")));
    }

    public boolean move(ChessPiece c){
        //Checks if moving to original space
        if(c.pos[0] == this.pos[0] && c.pos[1] == this.pos[1] && c.pos[2] == this.pos[2]){
            return false;
        }
        
        if(Math.abs(this.pos[0] - c.pos[0]) == 3){
            if(this.pos[1] - c.pos[1] == 0 && Math.abs(this.pos[2] - c.pos[2]) == 1){
                return moveThatPiece(c);
            }
            if(this.pos[2] - c.pos[2] == 0 && Math.abs(this.pos[1] - c.pos[1]) == 1){
                return moveThatPiece(c);
            }
            return false;
        }
        else if(Math.abs(this.pos[1] - c.pos[1]) == 3){
            if(this.pos[0] - c.pos[0] == 0 && Math.abs(this.pos[2] - c.pos[2]) == 1){
                return moveThatPiece(c);
            }
            if(this.pos[2] - c.pos[2] == 0 && Math.abs(this.pos[0] - c.pos[0]) == 1){
                return moveThatPiece(c);
            }
            return false;
        }
        else if(Math.abs(this.pos[2] - c.pos[2]) == 3){
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
        //If existing piece
        if((c != null) && (c.teamColor == this.teamColor)){
            return false;
        }
        
        //Removes chesspiece
        if(c != null){
            c = null;
        }
        //Updates position
        this.pos[0] = c.pos[0];
        this.pos[1] = c.pos[1];
        this.pos[2] = c.pos[2];
        return true;
    }
}
