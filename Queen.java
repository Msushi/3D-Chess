public class Queen extends ChessPiece{

    public Queen(white){
        super(white, "Queen");
        if (white)
            setIcon(new ImageIcon("Chess Piece Icons/WhiteQueen.jpg"));
        else
            setIcon(new ImageIcon("Chess Piece Icons/BlackQueen.jpg"));
    }

    public boolean move(ChessPiece c){
        //Checks if moving to original space
        boolean rookBeValid = true;
        boolean bishopBeValid = true;
        
        if(c.pos[0] == this.pos[0] && c.pos[1] == this.pos[1] && c.pos[2] == this.pos[2]){
            rookBeValid = false;
            break;
        }
        //Checks if position is in range; checks whether or not pieces are blocking the way
        if(c.pos[0] == this.pos[0] && c.pos[1] == this.pos[1]){
            if(c.pos[2] < this.pos[2]){
                for(int i = this.pos[2]; i > c.pos[2]; i--){
                    if(!board[c.pos[0]][c.pos[1]][i].equals(null)){
                        rookBeValid = false;
                        break;
                    }
                }
            }
            else{
                for(int i = this.pos[2]; i < c.pos[2]; i++){
                    if(!board[c.pos[0]][c.pos[1]][i].equals(null)){
                        rookBeValid = false;
                        break;
                    }
                }
            }
        }
        else if(c.pos[1] == this.pos[1] && c.pos[2] == this.pos[2]){
            if(c.pos[0] < this.pos[0]){
                for(int i = this.pos[0]; i > c.pos[0]; i--){
                    if(!board[i][c.pos[1]][c.pos[2]].equals(null)){
                        rookBeValid = false;
                        break;
                    }
                }
            }
            else{
                for(int i = this.pos[0]; i < c.pos[0]; i++){
                    if(!board[i][c.pos[1]][c.pos[2]].equals(null)){
                        rookBeValid = false;
                        break;
                    }
                }
            }
        }
        else if(c.pos[0] == this.pos[0] && c.pos[2] == this.pos[2]){
            if(c.pos[1] < this.pos[1]){
                for(int i = this.pos[1]; i > c.pos[1]; i--){
                    if(!board[c.pos[0]][i][c.pos[2]].equals(null)){
                        rookBeValid = false;
                        break;
                    }
                }
            }
            else{
                for(int i = this.pos[1]; i < c.pos[1]; i++){
                    if(!board[c.pos[0]][i][c.pos[2]].equals(null)){
                        rookBeValid = false;
                        break;
                    }
                }
            }
        }
        else{
            rookBeValid = false;
        }
         //Checks if position is in range; checks whether or not pieces are blocking the way
        if(c.pos[0] - this.pos[0] == c.pos[1] - this.pos[1]){
            if(c.pos[0] > this.pos[0]){
                for(int i = 1; i < c.pos[0] - this.pos[0]; i++){
                    if(!board[this.pos[0] + i][this.pos[1] + i][i].equals(null)){
                        bishopBeValid = false;
                        break;
                    }
                }
            }
            else{
                for(int i = 1; i < this.pos[0] - c.pos[0]; i++){
                    if(!board[this.pos[0] + i][this.pos[1] + i][i].equals(null)){
                        bishopBeValid = false;
                        break;
                    }
                }
            }
        }
        else if(c.pos[0] - this.pos[0] == this.pos[1] - c.pos[1]){
            if(c.pos[0] > this.pos[0]){
                for(int i = 1; i < c.pos[0] - this.pos[0]; i++){
                    if(!board[this.pos[0] + i][this.pos[1] - i][i].equals(null)){
                        bishopBeValid = false;
                        break;
                    }
                }
            }
            else{
                for(int i = 1; i < this.pos[0] - c.pos[0]; i++){
                    if(!board[this.pos[0] + i][this.pos[1] - i][i].equals(null)){
                        bishopBeValid = false;
                        break;
                    }
                }
            }
        }
        else{
            bishopBeValid = false;
            break;
        }
        if(!bishopBeValid && !rookBeValid){
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
