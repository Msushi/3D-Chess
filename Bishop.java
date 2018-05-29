public class Bishop extends ChessPiece{

    public Bishop(Color color){
        super(color, "Bishop");
        setIcon(//you know);
        //BLAH BLAH bLAH
    }

    public boolean move(ChessPiece c){
        //Checks if moving to original space
        if(c.pos[0] == this.pos[0] && c.pos[1] == this.pos[1] && c.pos[2] == this.pos[2]){
            return false;
        }
        //Checks if position is in range; checks whether or not pieces are blocking the way
        if(c.pos[0] - this.pos[0] == c.pos[1] - this.pos[1]){
            if(c.pos[0] > this.pos[0]){
                for(int i = 1; i < c.pos[0] - this.pos[0]; i++){
                    if(!board[this.pos[0] + i][this.pos[1] + i][i].equals(null)){
                        return false;
                    }
                }
            }
            else{
                for(int i = 1; i < this.pos[0] - c.pos[0]; i++){
                    if(!board[this.pos[0] + i][this.pos[1] + i][i].equals(null)){
                        return false;
                    }
                }
            }
        }
        else if(c.pos[0] - this.pos[0] == this.pos[1] - c.pos[1]){
            if(c.pos[0] > this.pos[0]){
                for(int i = 1; i < c.pos[0] - this.pos[0]; i++){
                    if(!board[this.pos[0] + i][this.pos[1] - i][i].equals(null)){
                        return false;
                    }
                }
            }
            else{
                for(int i = 1; i < this.pos[0] - c.pos[0]; i++){
                    if(!board[this.pos[0] + i][this.pos[1] - i][i].equals(null)){
                        return false;
                    }
                }
            }
        }
        else{
            return false;
        }
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
