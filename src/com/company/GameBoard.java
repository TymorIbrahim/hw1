package com.company;

public class GameBoard {
    Square [] gameBoard = new Square[100];

    /**
     * Construction. builds the game board from squares and put the right number to all the squares.
     */
    public GameBoard (){
        int counter = 1;
        for (int i = 0; i < gameBoard.length; i++){
            gameBoard [i] = new Square(i + 1);
        }
    }
}
