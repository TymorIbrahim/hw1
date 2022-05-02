package com.company;

public class GamePiece {
    Color color;
    Square square;
    boolean first_move;

    /**
     * Construction.
     * @param color
     */
    public GamePiece (Color color){
        this.color = color;
        this.square = new Square(1);
        this.first_move = false;
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

    public boolean isFirst_move() {
        return first_move;
    }

    public void setFirst_move(boolean first_move) {
        this.first_move = first_move;
    }
}
