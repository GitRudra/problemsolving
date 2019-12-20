package org.home.design.chess.move;

import org.home.design.chess.board.Square;

public class KnightMoveValidator implements MovementValidator{

    int[] xMove = {2,2,-2,-2,1,-1,1,-1};
    int[] yMOve = {1,-1,1,-1,2,2,-2,-2};
    @Override
    public boolean validate(Square currentPos, Square assignedTo) {
        for(int i=0;i<8;i++){
            if(currentPos.getX()+xMove[i] == assignedTo.getX()
            && currentPos.getY()+yMOve[i] == assignedTo.getY()){
                return true;
            }
        }
        return false;
    }
}
