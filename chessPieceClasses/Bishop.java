package chessPieceClasses;

import javax.swing.ImageIcon;

import chessGame.ChessBoard;
public class Bishop extends ChessPiece{

    public Bishop(boolean white){
       super(white);
       if (white)
           setIcon(new ImageIcon("Chess_Piece_Icons/WhiteBishop.jpg"));
       else
           setIcon(new ImageIcon("Chess_Piece_Icons/BlackBishop.jpg"));
       
    }

    public boolean move(ChessPiece c){
    	if(!super.move(c)){
    		return false;
    	}
    	
    	if(c.pos[0] == this.pos[0] || c.pos[1] == this.pos[1] || c.pos[2] != this.pos[2]){
    		return false;
    	}
    	
        //Checks if position is in range; checks whether or not pieces are blocking the way
    	int diff = c.pos[0] - this.pos[0];
        if(diff == c.pos[1] - this.pos[1]){
            if(c.pos[0] > this.pos[0]){
                for(int i = 1; i < diff; i++){
                    if(!ChessBoard.board[this.pos[0] + i][this.pos[1] + i][this.pos[2]].isEmpty()){
                        return false;
                    }
                }
            }
            else{
                for(int i = 1; i < diff; i++){
                    if(!ChessBoard.board[this.pos[0] - i][this.pos[1] - i][this.pos[2]].isEmpty()){
                        return false;
                    }
                }
            }
        }
        else if(diff == this.pos[1] - c.pos[1]){
        	System.out.println("y");
            if(c.pos[0] > this.pos[0]){
                for(int i = 1; i < diff; i++){
                    if(!ChessBoard.board[this.pos[0] + i][this.pos[1] - i][this.pos[2]].isEmpty()){
                        return false;
                    }
                }
            }
            else{
                for(int i = 1; i < diff; i++){
                    if(!ChessBoard.board[this.pos[0] - i][this.pos[1] + i][this.pos[2]].isEmpty()){
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
