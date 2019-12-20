package org.home.design.snakeladder;

import java.util.List;

public class GameBoard {

    private BoardSquare[][] board ;

    public GameBoard(List<Snake> snakes, List<Ladder> ladders) {
        this.board = new BoardSquare[10][10];
        initBoard();
        putSnakes(snakes);
        putLadders(ladders);
    }

    private void putSnakes(List<Snake> snakes){
        for(Snake s:snakes){
            board[s.getSnakeHead().getXPos()][s.getSnakeHead().getYPos()].setSnake(s);
        }
    }

    private void putLadders(List<Ladder> ladders){
        for(Ladder l: ladders){
            board[l.getLadderTail().getXPos()][l.getLadderTail().getYPos()].setLader(l);
        }
    }

    private void initBoard(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                board[i][j] = new BoardSquare(i,j);
            }
        }
    }
}
