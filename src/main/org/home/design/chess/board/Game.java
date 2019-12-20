package org.home.design.chess.board;

import org.home.design.chess.Player;


public class Game {
    private Player whitePlayer;
    private Player blackPlayer;
    private Board board;

    public Game(Player whitePlayer, Player blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        board = new Board();
        whitePlayer.setColor(board.white);
        blackPlayer.setColor(board.black);
    }

    public void move(Player player,Square source, Square target){
        if(source.getPiece().isValidMove(source, target)){
            if(board.isAttackingPosition(target)){
                board.removeAndUpdatePice(source,target);
            }
        }
    }
}
