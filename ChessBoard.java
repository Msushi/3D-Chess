import java.awt.*;
import javax.swing.*;


public class ChessBoard extends JPanel{
    public static ChessPiece[][][] board;
    //True = Player 1 (white), False = Player 2 (black)
    private boolean playerTurn;
    
    /**
     * Initializes the chess board so all pieces are in their starting positions with each player's color
     */
    public ChessBoard() {
        board = new ChessPiece[8][8][8];
        
        for (int a = 0; a < 8; a++)
            for (int b = 0; b< 8; b++)
                for (int c = 0; c < 8; c++)
                    board[a][b][c] = new EmptyChessPiece();
        
        //Initializes player 1's pawns
        for (int i = 0; i < 8;i++) {
            board[i][1][0] = new Pawn(false);
        }
        //Initializes player 1's special pieces
        board[0][0][0] = new Rook(false);
        board[7][0][0] = new Rook(false);
        board[1][0][0] = new Knight(false);
        board[6][0][0] = new Knight(false);
        board[2][0][0] = new Bishop(false);
        board[5][0][0] = new Bishop(false);
        board[3][0][0] = new Queen(false);
        board[4][0][0] = new King(false);
        
        //Initializes player 2's pawns
        for (int i = 0; i < 8; i++) {
            board[i][6][0] = new Pawn(true);
        }
        //Initializes player 2's special pieces
        board[0][7][0] = new Rook(true);
        board[7][7][0] = new Rook(true);
        board[1][7][0] = new Knight(true);
        board[6][7][0] = new Knight(true);
        board[2][7][0] = new Bishop(true);
        board[5][7][0] = new Bishop(true);
        board[3][7][0] = new Queen(true);
        board[4][7][0] = new King(true);
       
        //Sets chesspieces to contain position info
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                for(int k = 0; k < 8; k++){
                    board[i][j][k].setPosition(i, j, k);
                }
            }
        }
        
        
    }
    
    public ChessPiece[][][] getBoard() {
        return board;
    }
    
    private void updateBoard(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                for(int k = 0; k < 8; k++){
                    int a = board[i][j][k].getPosition()[0];
                    int b = board[i][j][k].getPosition()[1];
                    int c = board[i][j][k].getPosition()[2];
                    
                    if(board[a][b][c] != board[i][j][k]){
                        board[i][j][k] = board[a][b][c];
                        board[a][b][c] = new EmptyChessPiece();
                    }
                }
            }
        }
    }
    
    public void paintComponent(Graphics g){
        //ChessGame test = new ChessGame();
        //test.board[1][1][0].getIcon().paintIcon(board, g, 45, 45);
        Icon chessboard = new ImageIcon(ChessBoard.class.getResource("Chess Piece Icons/ChessBoard.jpg"));
        chessboard.paintIcon(this, g, 10, 10);
        for(int a = 0; a < 8; a++){
            for(int b = 0; b < 8; b++){
                //System.out.println("q");
                if (!board[a][b][ChessFrame.getDimension()].isEmpty()) {
                    System.out.println("[" + a + "]" + "[" + b + "[" + ChessFrame.getDimension() + "]");
                    int[] pos = board[a][b][ChessFrame.getDimension()].getPosition();
                    board[a][b][ChessFrame.getDimension()].getIcon().paintIcon(this, g, pos[0]*45 + 10, pos[1]*45);
                }
            }
        }
    }
}
