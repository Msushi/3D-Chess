package chessPieceClasses;
import javax.swing.*;

import chessGame.ChessBoard;
public class Rook extends ChessPiece{

    public Rook (boolean white){
       super(white);
       if (white)
           setIcon(new ImageIcon("Chess_Piece_Icons/WhiteRook.jpg"));
       else
           setIcon(new ImageIcon("Chess_Piece_Icons/BlackRook.jpg"));
    }

    public boolean move(ChessPiece c){
    	if(!super.move(c)){
    		return false;
    	}

        //Checks if position is in range; checks whether or not pieces are blocking the way
        if(c.pos[0] == this.pos[0] && c.pos[1] == this.pos[1]){
            if(c.pos[2] < this.pos[2]){
                for(int i = this.pos[2] - 1; i > c.pos[2]; i--){
                    if(!ChessBoard.board[this.pos[0]][this.pos[1]][i].isEmpty()){
                        return false;
                    }
                }
            }
            else{
                for(int i = this.pos[2] + 1; i < c.pos[2]; i++){
                    if(!ChessBoard.board[this.pos[0]][this.pos[1]][i].isEmpty()){
                        return false;
                    }
                }
            }
        }
        else if(c.pos[1] == this.pos[1] && c.pos[2] == this.pos[2]){
            if(c.pos[0] < this.pos[0]){
                for(int i = this.pos[0] - 1; i > c.pos[0]; i--){
                    if(!ChessBoard.board[i][this.pos[1]][this.pos[2]].isEmpty()){
                        return false;
                    }
                }
            }
            else{
                for(int i = this.pos[0] + 1; i < c.pos[0]; i++){
                    if(!ChessBoard.board[i][this.pos[1]][this.pos[2]].isEmpty()){
                        return false;
                    }
                }
            }
        }
        else if(c.pos[0] == this.pos[0] && c.pos[2] == this.pos[2]){
            if(c.pos[1] < this.pos[1]){
                for(int i = this.pos[1] - 1; i > c.pos[1]; i--){
                    if(!ChessBoard.board[this.pos[0]][i][this.pos[2]].isEmpty()){
                        return false;
                    }
                }
            }
            else{
                for(int i = this.pos[1] + 1; i < c.pos[1]; i++){
                    if(!ChessBoard.board[this.pos[0]][i][this.pos[2]].isEmpty()){
                        return false;
                    }
                }
            }
        }
        else{
            return false;
        }
        return moveThatPiece(c);
    }
    private boolean moveThatPiece(ChessPiece c){
        //Updates position
        this.pos[0] = c.pos[0];
        this.pos[1] = c.pos[1];
        this.pos[2] = c.pos[2];
        return true;
    }
}
