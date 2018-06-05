public class ChessGame {
    public ChessPiece[][][] board;
    //True = Player 1 (white), False = Player 2 (black)
    private boolean playerTurn;
    
    /**
     * Initializes the chess board so all pieces are in their starting positions with each player's color
     */
    public ChessGame() {
        board = new ChessPiece[8][8][8];
        
        //TODO: Initialise player objects to have colours
        
        //Initializes blacks' pawns
        for (int i = 0; i < 8;i++) {
            board[1][i][0] = new Pawn(false);
        }
        //Initializes blacks's special pieces
        board[0][0][0] = new Rook(false);
        board[0][7][0] = new Rook(false);
        board[0][1][0] = new Knight(false);
        board[0][6][0] = new Knight(false);
        board[0][2][0] = new Bishop(false);
        board[0][5][0] = new Bishop(false);
        board[0][3][0] = new Queen(false);
        board[0][4][0] = new King(false);
        
        //Initializes whites's pawns
        for (int i = 0; i < 8; i++) {
            board[6][i][0] = new Pawn(true);
        }
        //Initializes whites's special pieces
        board[7][0][0] = new Rook(true);
        board[7][7][0] = new Rook(true);
        board[7][1][0] = new Knight(true);
        board[7][6][0] = new Knight(true);
        board[7][2][0] = new Bishop(true);
        board[7][5][0] = new Bishop(true);
        board[7][3][0] = new Queen(true);
        board[7][4][0] = new King(true);
       
        //Sets chesspieces to contain position info
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                for(int k = 0; k < 8; k++){
                    board[i][j][k].setPosition(i, j, k);
                }
            }
        }
        
        
    }
    
    public int[][][] getBoard() {
        return board;
    }
    
    prviate void updateBoard(){
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
