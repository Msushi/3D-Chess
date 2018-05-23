public class ChessGame {
    public ChessPiece[][][] board;
    private Player p1;
    private Player p2;
    
    /**
     * Initializes the chess board so all pieces are in their starting positions with each player's color
     */
    public ChessGame() {
        board = new ChessPiece[8][8][8];
        
        //Initializes player 1's panws
        for (int i = 0; i < 10;i++) {
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
        
        //Initializes player 2's panws
        for (int i = 0; i < 10;i++) {
            board[6][i][0] = new Pawn(p2.getColor());
        }
        //Initializes player 1's special pieces
        board[7][0][0] = new Rook(p2.getColor());
        board[7][7][0] = new Rook(p2.getColor());
        board[7][1][0] = new Knight(p2.getColor());
        board[7][6][0] = new Knight(p2.getColor());
        board[7][2][0] = new Bishop(p2.getColor());
        board[7][5][0] = new Bishop(p2.getColor());
        board[7][3][0] = new Queen(p2.getColor());
        board[7][4][0] = new King(p2.getColor());
    }
    
    
}
