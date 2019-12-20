package org.home.design.snakeladder;

public class BoardSquare {
    private int xPos;
    private int yPos;
    private boolean snakeHead;
    private boolean ladderFoot;
    private Snake snake;
    private Ladder lader;

    public BoardSquare(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getXPos() {
        return xPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public int getYPos() {
        return yPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public boolean isSnakeHead() {
        return snakeHead;
    }

    public void setSnakeHead(boolean snakeHead) {
        this.snakeHead = snakeHead;
    }

    public boolean isLadderFoot() {
        return ladderFoot;
    }

    public void setLadderFoot(boolean ladderFoot) {
        this.ladderFoot = ladderFoot;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
        snakeHead = true;
    }

    public Ladder getLader() {
        return lader;
    }

    public void setLader(Ladder lader) {
        this.lader = lader;
    }
}
