package com.company;

public class GamePiece {
    Color color;
    Square square;

    public GamePiece (Color color){
        this.color = color;
        this.square = new Square(1);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }
}
