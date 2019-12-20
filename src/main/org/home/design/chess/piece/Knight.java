package org.home.design.chess.piece;

import org.home.design.chess.Color;
import org.home.design.chess.PieceType;
import org.home.design.chess.board.Square;
import org.home.design.chess.move.MovementValidator;

public class Knight implements Piece {
    MovementValidator validator;
    Color color;

    public Knight(MovementValidator validator, Color color) {
        this.validator = validator;
        this.color = color;
    }

    @Override
    public PieceType getPieceType() {
        return PieceType.KNIGHT;
    }

    @Override
    public Color getColor() {
        return color;
    }


    @Override
    public boolean isValidMove(Square source ,Square target) {
        return validator.validate(source,target);
    }
}
