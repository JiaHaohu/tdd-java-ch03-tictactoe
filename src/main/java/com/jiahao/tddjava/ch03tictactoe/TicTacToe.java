package com.jiahao.tddjava.ch03tictactoe;

public class TicTacToe {

    private char[][] board = {{'\0','\0','\0'},{'\0','\0','\0'},{'\0','\0','\0'}};

    private char lastPlayer;

    private final int SIZE =3;

    public String play(int x,int y){

        checkAxis(x,y);
        lastPlayer = nextPlayer();
        setBox(x,y,lastPlayer);


        if (isWin(x,y)){
            return lastPlayer + " is Winner!";
        }else if(isDraw()){
            return "The result is Draw!";
        }

        return "No Winner!";
    }


    public boolean isWin(int x,int y) {

        int finalResult = lastPlayer*SIZE;

        int diagonalLineTopButton = 0;

        int diagonalLineButtonTop = 0;

        int horizontal = 0;

        int vertical = 0;


        for (int index = 0; index < 3; index++) {

            horizontal += board[x-1][index];

            vertical += board[index][y-1];


            diagonalLineTopButton += board[index][index];

            diagonalLineButtonTop += board[index][2 - index];

        }

        if(diagonalLineTopButton == finalResult
            || diagonalLineButtonTop == finalResult
            || horizontal == finalResult
            || vertical == finalResult){
            return true;
        }

        return false;
    }

    public boolean isDraw(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(board[i][j] == '\0'){
                    return false;
                }
            }
        }
        return true;
    }


    private void checkAxis(int x,int y){
        if ( x < 1 || x > 3){
            throw new RuntimeException("x is outside broad");
        }
        if ( y < 1 || y >3 ){
            throw new RuntimeException("y is outside broad");
        }
    }

    private void setBox(int x,int y,char lastPlayer){
        if ( board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("Box is occupied!");
        }else {
            board[x - 1][y - 1] = lastPlayer;
        }
    }

    public char nextPlayer() {
        if (lastPlayer == 'X'){
            return 'O';
        }
        return 'X';
    }

}
