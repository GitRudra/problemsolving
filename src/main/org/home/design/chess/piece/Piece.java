package org.home.design.chess.piece;

import org.home.design.chess.Color;
import org.home.design.chess.PieceType;
import org.home.design.chess.board.Square;

public interface Piece {
    PieceType getPieceType();
    Color getColor();
    boolean isValidMove(Square source, Square target);
}
