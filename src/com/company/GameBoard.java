package com.company;

public class GameBoard {
    Square [][] gameBoard = new Square[10][10];

    public GameBoard (){
        int counter = 1;
        for (int i = 0; i < gameBoard.length; i++){
            for (int j = 0; i < gameBoard.length; j++){
                gameBoard [i][j] = new Square(counter);
                counter++;
            }
        }
    }
}
