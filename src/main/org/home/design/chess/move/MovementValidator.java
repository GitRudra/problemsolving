package org.home.design.chess.move;

import org.home.design.chess.board.Square;

public interface MovementValidator {
    boolean validate(Square currentPos, Square assignedTo);
}
