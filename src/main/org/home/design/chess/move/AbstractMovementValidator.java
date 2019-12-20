package org.home.design.chess.move;

import org.home.design.chess.board.Square;

public abstract class AbstractMovementValidator implements MovementValidator {

    public boolean validateBoundary(Square s){

        return true;
    }
}
