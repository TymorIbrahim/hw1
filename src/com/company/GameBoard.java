package com.company;

public class GameBoard {
    Square [] gameBoard = new Square[100];

    public GameBoard (){
        int counter = 1;
        for (int i = 1; i < gameBoard.length + 1; i++){
            gameBoard [i] = new Square(i);
        }
    }
}
