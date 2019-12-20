package org.home.design.chess.piece;

import org.home.design.chess.Color;
import org.home.design.chess.PieceType;
import org.home.design.chess.board.Square;

public class Pawn implements Piece {
    private Color color;

    public Pawn(Color color) {
        this.color = color;
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.PAWN;
    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public boolean isValidMove(Square source, Square target) {
        return false;
    }
}
