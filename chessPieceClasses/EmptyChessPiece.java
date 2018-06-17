package chessPieceClasses;
public class EmptyChessPiece extends ChessPiece {
    
    public EmptyChessPiece() {
        super(false);
    }
    
    public boolean isEmpty() {
        return true;
    }
}
