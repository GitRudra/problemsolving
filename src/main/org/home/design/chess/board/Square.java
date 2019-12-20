package org.home.design.chess.board;

import org.home.design.chess.piece.Piece;

public class Square {
    private int x;
    private int y;
    Piece piece;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void removePiece(){
        setPiece(null);
    }

    public void placePiece(Piece piece){
        setPiece(piece);
    }

    public  boolean isEmpty(){
        return piece == null;
    }
}
