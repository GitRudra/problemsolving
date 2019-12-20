package org.home.design.snakeladder;

public class PlayerPiece {
    private String color;
    private BoardSquare currentPosition;

    public PlayerPiece(String color, BoardSquare currentPosition) {
        this.color = color;
        this.currentPosition = currentPosition;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BoardSquare getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(BoardSquare currentPosition) {
        this.currentPosition = currentPosition;
    }
}
