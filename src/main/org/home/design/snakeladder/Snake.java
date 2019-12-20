package org.home.design.snakeladder;

public class Snake {
    private BoardSquare snakeHead;
    private BoardSquare snakeTail;

    public Snake(BoardSquare snakeHead, BoardSquare snakeTail) {
        this.snakeHead = snakeHead;
        this.snakeTail = snakeTail;
    }

    public BoardSquare getSnakeHead() {
        return snakeHead;
    }

    public void setSnakeHead(BoardSquare snakeHead) {
        this.snakeHead = snakeHead;
    }

    public BoardSquare getSnakeTail() {
        return snakeTail;
    }

    public void setSnakeTail(BoardSquare snakeTail) {
        this.snakeTail = snakeTail;
    }
}
