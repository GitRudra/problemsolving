package org.home.design.snakeladder;

public class Ladder {
    private BoardSquare ladderHead;
    private BoardSquare ladderTail;

    public Ladder(BoardSquare ladderHead, BoardSquare ladderTail) {
        this.ladderHead = ladderHead;
        this.ladderTail = ladderTail;
    }

    public BoardSquare getLadderHead() {
        return ladderHead;
    }

    public void setLadderHead(BoardSquare ladderHead) {
        this.ladderHead = ladderHead;
    }

    public BoardSquare getLadderTail() {
        return ladderTail;
    }

    public void setLadderTail(BoardSquare ladderTail) {
        this.ladderTail = ladderTail;
    }
}
