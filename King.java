import java.util.*;
import javax.swing.*;
public class King extends ChessPiece {
  
    public King(boolean white) {
       super(white, "King");
       if (white)
           setIcon(new ImageIcon(King.class.getResource("Chess Piece Icons/WhiteKing.jpg")));
       else
           setIcon(new ImageIcon(King.class.getResource("Chess Piece Icons/BlackKing.jpg")));
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
            
      
