import java.util.*;
public class King extends ChessPiece {
  
    public King(Color c) {
        super (c, "King");
        setIcon(king.jpg);
    }
  
    public boolean move (ChessPiece c) {
        if (Arrays.equals(this.pos, c.pos)) //If inputted move is the current square
            return false;
        if (Math.abs(this.pos[0] - c.pos[0]) <= 1 && Math.abs(this.pos[1] - c.pos[1]) <= 1 && Math.abs(this.pos[2] - c.pos[2]) <= 1) {
            if (c != null && c.teamColor == this.teamColor) //If a friednly piece occupies the square
                return false;
            else if (c != null && c.teamColor != this.teamColor) //If capture
                c = null;
            this.pos = c.pos;
            return true;
        }
        return false;
    }
}
            
      
