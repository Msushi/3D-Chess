public class EmptyChessPiece extends ChessPiece {
    
    public EmptyChessPiece() {
        super(false, null);
    }
    public boolean move(ChessPiece e) {
        return false;
    }
    public boolean isEmpty() {
        return true;
    }
}
