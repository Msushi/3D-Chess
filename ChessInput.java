public class ChessInput implements MouseListener {
  public void mouseClicked(MouseEvent e) {
    determineInput(e.getPoint());
  }
  //returns the chess piece at the square the player clicked at, returns null if not on the board
  private ChessPiece determineInput(Point pos) {
    int x = pos.getX();
    int y = pos.getY();
    if ((x =< 0 || x >= 360  ) || (y <= 0 || y >= 360 )
        return null;
    else {
        return ChessGame.board[x/45][y/45][currentDimension];
  }
}
       
  
