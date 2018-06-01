public class ChessGame {
    public ChessPiece[][][] board;
    private Player p1;
    private Player p2;
    
    /**
     * Initializes the chess board so all pieces are in their starting positions with each player's color
     */
    public ChessGame() {
        board = new ChessPiece[8][8][8];
        
        //TODO: Initialise player objects to have colours
        
        //Initializes player 1's pawns
        for (int i = 0; i < 8;i++) {
            board[1][i][0] = new Pawn(p1.getColor());
        }
        //Initializes player 1's special pieces
        board[0][0][0] = new Rook(p1.getColor());
        board[0][7][0] = new Rook(p1.getColor());
        board[0][1][0] = new Knight(p1.getColor());
        board[0][6][0] = new Knight(p1.getColor());
        board[0][2][0] = new Bishop(p1.getColor());
        board[0][5][0] = new Bishop(p1.getColor());
        board[0][3][0] = new Queen(p1.getColor());
        board[0][4][0] = new King(p1.getColor());
        
        //Initializes player 2's pawns
        for (int i = 0; i < 8; i++) {
            board[6][i][0] = new Pawn(p2.getColor());
        }
        //Initializes player 2's special pieces
        board[7][0][0] = new Rook(p2.getColor());
        board[7][7][0] = new Rook(p2.getColor());
        board[7][1][0] = new Knight(p2.getColor());
        board[7][6][0] = new Knight(p2.getColor());
        board[7][2][0] = new Bishop(p2.getColor());
        board[7][5][0] = new Bishop(p2.getColor());
        board[7][3][0] = new Queen(p2.getColor());
        board[7][4][0] = new King(p2.getColor());
       
        //Sets chesspieces to contain position info
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                for(int k = 0; k < 8; k++){
                    board[i][j][k].setPosition(i, j, k);
                }
            }
        }
        
        
    }
    
    public void updateBoard(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                for(int k = 0; k < 8; k++){
                    int a = board[i][j][k].getPosition()[0];
                    int b = board[i][j][k].getPosition()[1];
                    int c = board[i][j][k].getPosition()[2];
                    
                    if(board[a][b][c] != board[i][j][k]){
                        board[i][j][k] = board[a][b][c];
                        board[a][b][c] = new EmptyPiece();
                    }
                }
            }
        }
    }
}
