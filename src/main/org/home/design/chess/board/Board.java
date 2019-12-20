package org.home.design.chess.board;

import org.home.design.chess.Color;
import org.home.design.chess.piece.Pawn;
import org.home.design.chess.piece.Piece;


public class Board {
    Square[][] board = null;
    PieceColor black  = null;
    PieceColor white = null;

    public Board() {
        board = new Square[8][8];
        black  = new PieceColor(Color.BLACK);
        white = new PieceColor(Color.WHITE);
    }

    private void initializeBoard(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board[i][j] = new Square(i,j);
            }
        }
    }

    private void assignWhitePieces(){
        for(int i=0;i<2;i++){
            board[6][i] = new Square(6,i);
            board[6][i].setPiece(new Pawn(Color.WHITE));
        }
    }

    private void assignPieces(){

    }
    public boolean isAttackingPosition(Square target){
        if(target.getPiece() != null){
            return true;
        }else{
            return false;
        }
    }

    public void removeAndUpdatePice(Square source, Square target){
        Piece oldPiece   = target.getPiece();
        target.setPiece(source.getPiece());
    }
}
